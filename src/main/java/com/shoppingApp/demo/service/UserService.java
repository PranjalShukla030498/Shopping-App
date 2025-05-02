package com.shoppingApp.demo.service;

import com.shoppingApp.demo.domain.Address;
import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.repository.AddressRepository;
import com.shoppingApp.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private UserRepository userRepository;
    @Autowired private AddressRepository addressRepository;

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


    public String createNewAddress (Address address){
        addressRepository.saveAndFlush(address);
        return "Address Saved !!";
    }

    public List <Address> getAllAddress(int userId){
        logger.info("userId is : {}", userId);
        Optional<Users> user = userRepository.findById(userId);
        logger.info("user : {}", user);
        if (user.isPresent()){
            List <Address> addressList = addressRepository.getExistingAddressForUserId(userId);
            return addressList;
        }
        return null;
    }


}
