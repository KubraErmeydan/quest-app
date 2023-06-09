package com.project.questapp.services;

import com.project.questapp.models.User;
import com.project.questapp.repos.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users=userRepository.findAll();
        if (users.isEmpty()){
            throw new RuntimeException("Kayıtlı kullanıcı bulunamadı.");
        }
        return users;
    }

    public User createUser(User newUser){
        if (newUser.getUserName()==null){
            throw new RuntimeException("Kayıtlı kullanıcı bulunamadı.");
        }
        return userRepository.save(newUser);
    }

    public User updateOneUser(User newUser,Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user==null){
            throw new RuntimeException("Kayıtlı kullanıcı bulunamadı.");
        }
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        user.setAvatar(newUser.getAvatar());
        userRepository.save(user);
        return user;
    }

    public User getOneUser(Long userId ){
        User user =userRepository.findById(userId).orElse(null);
        if (user ==null){throw new RuntimeException("Kullanıcı bulunamadı..");
        }
        return user;
    }

    public void deleteById(Long userId){
        User user= userRepository.findById(userId).orElse(null);
        if(user==null) {
            System.out.println("User "+ userId+ " bulunamadı.");
        }else{
        userRepository.delete(user); }
    }



}
