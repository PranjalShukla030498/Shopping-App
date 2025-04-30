package com.shoppingApp.demo.controller;

import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/users/createNew")
    public String createNewUser (@RequestBody Users user){
        return userService.createNewUser(user);

    }

    @GetMapping("/users/getAllUsers")
    public List<Users> getAllusers(){
       return userService.getAllUsers();
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser (@PathVariable int id ){
        userService.deleteUser(id);
        return "Your Account is deleted";

    }

}
