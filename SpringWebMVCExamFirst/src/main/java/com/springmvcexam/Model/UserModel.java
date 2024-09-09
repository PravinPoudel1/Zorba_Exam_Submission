package com.springmvcexam.Model;

import lombok.Data;

@Data
public class UserModel {
    private String name;
    private String email;
    private Long mobile;
    private String userName;
    private String password;
}