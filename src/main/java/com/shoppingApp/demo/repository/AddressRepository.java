package com.shoppingApp.demo.repository;


import com.shoppingApp.demo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository <Address, Integer> {

}
