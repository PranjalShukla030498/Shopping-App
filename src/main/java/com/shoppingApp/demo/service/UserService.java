package com.shoppingApp.demo.service;

import com.shoppingApp.demo.Dto.AddressDto;
import com.shoppingApp.demo.domain.Address;
import com.shoppingApp.demo.domain.Users;
import com.shoppingApp.demo.repository.AddressRepository;
import com.shoppingApp.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private UserRepository userRepository;
    @Autowired private AddressRepository addressRepository;

    public String createNewUser (Users user){
        logger.info("Request recieved to save new user : {}", user);
        Users existingUser = userRepository.getExistingUser(user.getEmail());
        System.out.println(existingUser);
        if (user.getEmail().equalsIgnoreCase(existingUser.getEmail())){
           logger.info("This Email already exists with email: {}",existingUser.getEmail());
            return "This Email already exists !!";
        }

        userRepository.saveAndFlush(user);
            return "Your account is created";
    }


    public List<Users> getAllUsers() {
        logger.info("Request recieved to getAll users");
        List<Users> userList = userRepository.findAll();
       return userList;
    }

    public void deleteUser (int id){
        logger.info("Request recieved to delete user by id: {}", id);
        System.out.println(id);
        userRepository.deleteById(id);
    }


    public String createNewAddress (AddressDto addressDto){
        logger.info("Request recieved to save address : {}", addressDto);
        Optional<Users> user = userRepository.findById(addressDto.getUserId());
        Address address = new Address();
        if(user.isPresent()){
            logger.info("Request recieved to save new address for user : {}", user.get().getId());
            address.setId(addressDto.getId());
            address.setUser(user.get());
            address.setFlatNo(addressDto.getFlatNo());
            address.setAddressLine(addressDto.getAddressLine());
            address.setCity(addressDto.getCity());
            address.setLandmark(addressDto.getLandmark());
            address.setCountry(addressDto.getCountry());
            address.setState(addressDto.getState());
            address.setZipCode(addressDto.getZipCode());
            addressRepository.saveAndFlush(address);
            return "Address Saved !!";
        }
        return "No user found with userId";

    }

    public List <AddressDto> getAllAddress(int userId){
        logger.info("userId is : {}", userId);
        Optional<Users> user = userRepository.findById(userId);
        logger.info("user : {}", user);
        if (user.isPresent()){
            List<Address> address = addressRepository.findByUserId(userId);
            List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
            for(Address ad: address ){
                AddressDto addressDto= new AddressDto();
                addressDto.setId(ad.getId());
                addressDto.setUserId(ad.getUser().getId());
                addressDto.setFlatNo(ad.getFlatNo());
                addressDto.setAddressLine(ad.getAddressLine());
                addressDto.setCity(ad.getCity());
                addressDto.setLandmark(ad.getLandmark());
                addressDto.setCountry(ad.getCountry());
                addressDto.setState(ad.getState());
                addressDto.setZipCode(ad.getZipCode());
                addressDtoList.add(addressDto);
            }
            return addressDtoList;
        }
        return null;
    }


}
