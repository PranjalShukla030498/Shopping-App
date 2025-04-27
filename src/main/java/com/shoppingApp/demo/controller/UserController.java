package com.shoppingApp.demo.controller;

import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/users/createNew")
    public String createNewUser (@RequestBody Users user){
        userService.createNewUser(user);
        return "Your account is created";
    }

    @GetMapping("/users/getAllUsers")
    public List<Users> getAllusers(){
       return userService.getAllUsers();
    }

}
