package com.shoppingApp.demo.repository;

import com.shoppingApp.demo.domain.Address;
import com.shoppingApp.demo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("Select u from Users u where email= :mail ")
    public Users getExistingUser (@Param("mail") String mail);

    @Query("Select u from Users u where u.id = :userId")
    public Users getExistingAddressForUserId(@Param("userId")int  userId);
}
