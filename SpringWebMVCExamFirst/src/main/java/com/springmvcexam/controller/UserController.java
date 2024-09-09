package com.springmvcexam.controller;


import com.springmvcexam.Model.UserModel;
import com.springmvcexam.exception.InvalidEmail;
import com.springmvcexam.exception.InvalidMobile;
import com.springmvcexam.exception.InvalidPassword;
import com.springmvcexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*@RequestMapping(value = "/,", method = RequestMethod.GET)
    public String saveUserData(@ModelAttribute UserModel userModel, Model model) {
        String response = userService.saveUserData(userModel);
        model.addAttribute("message", response);
        return "userForm";
    }*/

    @PostMapping(value = "/userForm")
    public String saveUserData(@ModelAttribute UserModel userModel, Model model) throws Exception {
        if (!userModel.getEmail().contains("@")) {
            throw new InvalidEmail("Data provided not Correct");
        }
        if (userModel.getMobile().toString().length() != 10) {
            throw new InvalidMobile("Mobile number not correct. Must be 10 digits only.");
        }
        if (userModel.getPassword().length() < 8) {
            throw new InvalidPassword("Password Incorrect, should be minimum of 8 digits");
        }
        userService.saveUserData(userModel);
        return "success";
    }

    @ExceptionHandler(InvalidMobile.class)
    public ModelAndView handleInvalidMobile(InvalidMobile exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionDetails", exception);
        return modelAndView;
    }
    @ExceptionHandler(InvalidEmail.class)
    public ModelAndView handleInvalidEmail(InvalidEmail exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionDetails", exception);
        return modelAndView;
    }
    @ExceptionHandler(InvalidPassword.class)
    public ModelAndView handleInvalidPassword(InvalidPassword exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionDetails", exception);
        return modelAndView;
    }

    @GetMapping("/getUserData")
    public String getAllUser (Model model) {
        List<UserModel> userModels = this.userService.getAllUsers();
        ModelAndView m = new ModelAndView("viewUser");
        m.addObject("userModels", userModels);
        System.out.println(userModels);
        return "viewUser";
    }
    @GetMapping("/getUserById/{id}")
    public ModelAndView getStudentById(@PathVariable("id") String userId) {
        Integer uId = Integer.parseInt(userId);
        ModelAndView modelAndView = new ModelAndView("addRole");
        UserModel userModel = this.userService.getUserById(uId);
        modelAndView.addObject("userObj", userModel);
        return modelAndView;
    }
}
