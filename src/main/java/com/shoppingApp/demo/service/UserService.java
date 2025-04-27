package com.shoppingApp.demo.service;

import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    public void createNewUser (Users user){
       userRepository.saveAndFlush(user);
    }
}
