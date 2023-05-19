package com.project.questapp.controllers;

import com.project.questapp.models.Post;
import com.project.questapp.models.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.repos.UserRepository;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")


public class PostController {
    @Autowired
    public PostRepository postRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @PostMapping
    public Post createOnePost(){
        User newUser = userRepository.findById(1L).orElse(null);
        Post post = new Post();
        post.setUser(newUser);
        post.setText("Post123");
        post.setTitle("HELLO");

        //post.setCreateDate(new Date());
        return  postRepository.save(post);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody Post updatePost){
        return postRepository.save(updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postRepository.deleteById(postId);
    }


}

