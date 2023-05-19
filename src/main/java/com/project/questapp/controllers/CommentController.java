package com.project.questapp.controllers;

import com.project.questapp.models.Comment;
import com.project.questapp.repos.CommentRepository;
import jakarta.persistence.AssociationOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    public CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    @PostMapping
    public Comment createOneComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }


    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId,@RequestBody Comment comment ){
        return commentRepository.save(comment);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
    }
}
