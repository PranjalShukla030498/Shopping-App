package com.shoppingApp.demo.service;

import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    public String createNewUser (Users user){
        Users existingUser = userRepository.getExistingUser(user.getEmail());
        System.out.println(existingUser);
        if (user.getEmail().equalsIgnoreCase(existingUser.getEmail())){
            System.out.println("This Email already exists !!");
            return "This Email already exists !!";
        }
        userRepository.saveAndFlush(user);
            return "Your account is created";
    }


    public List<Users> getAllUsers() {
       List<Users> userList = userRepository.findAll();
       return userList;
    }

    public void deleteUser (int id){
        System.out.println(id);
        userRepository.deleteById(id);
    }

}
