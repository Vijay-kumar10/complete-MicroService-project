package com.userservice.service;

import com.userservice.entities.User;

import java.util.List;

public interface UserService {

    //create user
    User save(User user);

    //get all users
   List<User> getAllUsers();

   //get single user by id
    User getUserById(String id);

    //delete user by id

    User deleteUserById(String id);

    //update user
    User updateUser(User user);
}
