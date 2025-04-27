package com.shoppingApp.demo.controller;

import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/users/createNew")
    public void createNewUser (@RequestBody Users user){
        userService.createNewUser(user);
    }

}
