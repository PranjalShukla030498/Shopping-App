package com.shoppingApp.demo.controller;

import com.shoppingApp.demo.Dto.AddressDto;
import com.shoppingApp.demo.domain.Address;
import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @PostMapping("/users/address/create")
    public String createAddress( @Valid  @RequestBody AddressDto address) {
        return userService.createNewAddress(address);
    }

}
