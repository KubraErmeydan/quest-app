package com.project.questapp.controllers;

import com.project.questapp.models.User;
import com.project.questapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(){
        User newUser = new User();
        newUser.setUserName("user1");
        newUser.setPassword("147");
        newUser.setAvatar(3);

        return userRepository.save(newUser);
    }


}
