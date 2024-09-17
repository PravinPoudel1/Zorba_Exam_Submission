package com.springmvcexam.service;


import com.springmvcexam.dao.UserDAO;
import com.springmvcexam.entity.Role;
import com.springmvcexam.entity.User;
import com.springmvcexam.exception.InvalidEmailException;
import com.springmvcexam.exception.InvalidMobileNumber;
import com.springmvcexam.exception.InvalidPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public boolean saveUser(User user) {
        if (!user.getUserEmail().contains("@")) {
            throw new InvalidEmailException("Email is incorrect");
        } else if (!(user.getUserMobile().toString().length()==10)) {
            throw new InvalidMobileNumber("Mobile number is invalid");
        } else if (!(user.getUserPass().length()>=10)) {
            throw new InvalidPassword("Password needs to be at least 10 characters");
        }
        return this.userDAO.saveUser(user);
    }

    public boolean updateUser(Integer userId,String roleName) {
        User user = this.userDAO.getUser(userId);
        if (user != null && !roleName.isEmpty()) {
            Role role = userDAO.getRole(roleName);
            if (role != null) {
                user.getRoles().add(role);
            } else {
                Role newRole = new Role();
                newRole.setRoleName(roleName);
                user.getRoles().add(newRole);
            }


            return this.userDAO.updateUser(user);
        }
        return false;
    }

    public User getUser(Integer id) {
        if (id == 0) {
            return null;
        }
        return this.userDAO.getUser(id);
    }

    public User getUser(String userName, String password, String roleName) {
        User user = this.userDAO.getUser(userName, password);
        if (user != null) {
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                if (role.getRoleName().equalsIgnoreCase(roleName)) {
                    return user;
                }
            }
        }
        return null;
    }

    public List<Role> getAllRoles() {
        return this.userDAO.getAllRoles();
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    public User removeRole(Integer userId, Integer roleId) {
        return this.userDAO.removeRole(userId, roleId);

    }


}
