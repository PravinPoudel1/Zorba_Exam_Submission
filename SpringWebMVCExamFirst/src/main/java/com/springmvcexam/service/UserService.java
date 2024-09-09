package com.springmvcexam.service;
import com.springmvcexam.Model.UserModel;
import com.springmvcexam.dao.UserDao;
import com.springmvcexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public String saveUserData(UserModel userModel) {
        /*if (userModel.getUserEmail() != null && userModel.getUserName() != null && userModel.getUserMobile() != null && userModel.getUserPassword() != null) {
            User user = new User();
            user.setName(userModel.getName());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserMobile(userModel.getUserMobile());
            user.setUserName(userModel.getUserName());
            user.setUserPassword(userModel.getUserPassword());
            return userDao.saveUser(user);
        }
        return "Incomplete data. Please provide all required fields.";*/
        if (userModel.getEmail() != null && userModel.getUserName() != null && userModel.getMobile() != null && userModel.getPassword() != null) {
            User user = new User();
            user.setName(userModel.getUserName());
            user.setEmail(userModel.getEmail());
            user.setMobile(userModel.getMobile());
            user.setUserName(userModel.getUserName());
            user.setPassword(userModel.getPassword());
            userDao.saveUser(user);
        }
        return "Incomplete data. Please provide all required fields.";
    }

    public List<UserModel> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        List<UserModel> userModels = new ArrayList<>();
        for (User user : users) {
            UserModel userModel = new UserModel();
            userModel.setUserId(user.getUserId());
            userModel.setName(user.getName());
            userModel.setUserEmail(user.getUserEmail());
            userModel.setUserMobile(user.getUserMobile());
            userModel.setUserName(user.getUserName());
            userModel.setUserPassword(user.getUserPassword());
            userModels.add(userModel);
        }
        return userModels;
    }

    public UserModel getUserById(Integer userId) {
        if (userId == null) {
            return new UserModel();
        }
        User user = userDao.getUserById(userId);
        if (user == null) {
            return new UserModel();
        }
        UserModel userModel = new UserModel();
        userModel.setUserId(user.getUserId());
        userModel.setName(user.getName());
        userModel.setUserEmail(user.getUserEmail());
        userModel.setUserMobile(user.getUserMobile());
        userModel.setUserName(user.getUserName());
        userModel.setUserPassword(user.getUserPassword());
        return userModel;
    }

    public UserModel findUserByUsername(String username) {

        User user = userDao.findByUsername(username);
        if (user != null) {
            UserModel userModel = new UserModel();
            userModel.setUserId(user.getUserId());
            userModel.setName(user.getName());
            userModel.setUserEmail(user.getUserEmail());
            userModel.setUserMobile(user.getUserMobile());
            userModel.setUserName(user.getUserName());
            userModel.setUserPassword(user.getUserPassword());
            return userModel;
        }
        return null;
    }

    public boolean validateUser(String username, String password, String role) {
        UserModel user = findUserByUsername(username);
        return user != null && user.getUserPassword().equals(password) && user.getRole().equals(role);
    }

}
