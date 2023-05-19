package com.project.questapp.controllers;

import com.project.questapp.models.Post;
import com.project.questapp.models.User;
import com.project.questapp.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/posts")

public class PostController {
    @Autowired
    public PostRepository postRepository;

    @PostMapping
    public Post createOnePost(){
        Post post = new Post();
        User newUser = new User();
        newUser.setUserName("user1");
        newUser.setPassword("147");
        newUser.setAvatar(3);
        post.setUser(newUser);
        post.setText("Post123");
        post.setTitle("HELLO");
        //post.setCreateDate(new Date());
        return  postRepository.save(post);
    }
}

