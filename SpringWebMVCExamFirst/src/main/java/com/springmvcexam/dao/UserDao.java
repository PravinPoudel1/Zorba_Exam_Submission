package com.springmvcexam.dao;

import com.springmvcexam.entity.User;

import java.util.List;

public interface UserDao {

    String saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer userId);

}
