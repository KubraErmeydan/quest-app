package com.project.questapp.controllers;

import com.project.questapp.models.Like;
import com.project.questapp.repos.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    public LikeRepository likeRepository;

    @GetMapping
    public List<Like> getAllLikes(){
        return likeRepository.findAll();
    }

    @PostMapping
    public Like createOneLike(@RequestBody Like like){
        return likeRepository.save(like);
    }



}
