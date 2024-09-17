package com.springmvcexam.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table( name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", length = 10)
    private Integer roleId;
    @Column(name = "role_name", length = 40)
    private String roleName;

    private String role_Name= "Customer";

}
