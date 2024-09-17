package com.springmvcexam.model;

import lombok.Data;

@Data
public class Admin {
    private String username;
    private String password;
    private String role;

    public Admin() {
        this.role = "Admin";
    }
}
