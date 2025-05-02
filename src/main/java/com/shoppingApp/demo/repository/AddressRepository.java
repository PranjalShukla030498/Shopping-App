package com.shoppingApp.demo.repository;


import com.shoppingApp.demo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository <Address, Integer> {

    @Query("Select a from Address LEFT JOIN Users u where u.id = :userId")
    public List<Address> getExistingAddressForUserId (@Param("userId")int  userId);

}
