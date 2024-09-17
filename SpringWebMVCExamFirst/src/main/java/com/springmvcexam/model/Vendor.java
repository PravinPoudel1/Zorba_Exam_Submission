package com.springmvcexam.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Vendor {
    private int id;
    private String name;
    private String email;
}
