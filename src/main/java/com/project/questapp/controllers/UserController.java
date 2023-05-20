package com.project.questapp.controllers;

import com.project.questapp.models.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.getOneUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){

        userService.deleteById(userId);
    }


}
