package com.springmvcexam.model;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
