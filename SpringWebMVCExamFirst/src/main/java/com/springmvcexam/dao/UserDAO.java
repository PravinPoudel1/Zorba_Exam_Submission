package com.springmvcexam.dao;

import com.springmvcexam.entity.Role;
import com.springmvcexam.entity.User;

import java.util.List;

public interface UserDAO {

    boolean saveUser (User user);
    boolean updateUser(User user);
    User getUser (Integer id);
    User getUser (String userName, String password);
    Role getRole(Integer roleId);
    Role getRole(String roleName);
    List<User> getAllUsers();
    List<Role> getAllRoles();
    User removeRole(Integer roleId, Integer userId);
}
