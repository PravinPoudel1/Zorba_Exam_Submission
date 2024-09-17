package com.springmvcexam.controller;


import com.springmvcexam.entity.Role;
import com.springmvcexam.entity.User;
import com.springmvcexam.exception.InvalidEmailException;
import com.springmvcexam.exception.InvalidMobileNumber;
import com.springmvcexam.exception.InvalidPassword;
import com.springmvcexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/registerUser")
    public ModelAndView showStudentForm() {
        return new ModelAndView("registerUser");
    }

    @PostMapping(path = "/saveUser")
    public ModelAndView saveUser(@ModelAttribute User user) {
        boolean response = this.userService.saveUser(user);
        if (response) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("fail");
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("userId") Integer userId,
                             @RequestParam("role") String role) {
        System.out.println(userId);
        System.out.println(role);
        boolean response = this.userService.updateUser(userId, role);
        if (response) {
            return "redirect:/user/userList";
        } else {
            throw new InvalidEmailException("Unable to update user");
        }
    }

    @GetMapping("/userList")
    public ModelAndView getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/getUser/{userId}")
    public ModelAndView getUser(@PathVariable String userId) {
        Integer Id = Integer.parseInt(userId);
        ModelAndView modelAndView = new ModelAndView("userDashboard");
        User user = this.userService.getUser(Id);
        modelAndView.addObject("userObj", user);
        return modelAndView;
    }

    @GetMapping("/viewUser/{userId}")
    public ModelAndView addRole(@PathVariable String userId) {
        ModelAndView modelAndView = new ModelAndView("viewUser");
        Integer Id = Integer.parseInt(userId);
        User user = this.userService.getUser(Id);
        List<Role> roles = this.userService.getAllRoles();
        modelAndView.addObject("userObj", user);
        modelAndView.addObject("roles", roles);
        return modelAndView;
    }

    @GetMapping("/removeRole/{roleId}/{userId}")
    public ModelAndView removeRole(@PathVariable("roleId") String stringRoleId,
                                   @PathVariable("userId") String stringUserId) {
        Integer userId = Integer.parseInt(stringUserId);
        Integer roleId = Integer.parseInt(stringRoleId);
        ModelAndView modelAndView = new ModelAndView("viewUser");
        User user = this.userService.removeRole(userId, roleId);
        List<Role> roles = this.userService.getAllRoles();
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("userObj", user);
        return modelAndView;
    }




    @ExceptionHandler(InvalidEmailException.class)
    public ModelAndView handleInvalidEmailException(InvalidEmailException exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorDetails",exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(InvalidPassword.class)
    public ModelAndView handleInvalidPassword(InvalidPassword exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorDetails",exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(InvalidMobileNumber.class)
    public ModelAndView handleInvalidMobileNumber(InvalidMobileNumber exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorDetails",exception.getMessage());
        return modelAndView;
    }






}
