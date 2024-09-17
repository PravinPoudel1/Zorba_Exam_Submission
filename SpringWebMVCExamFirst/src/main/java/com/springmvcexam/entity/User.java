package com.springmvcexam.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_fullname", length = 255)
    private String userFullName;
    @Column(name = "user_email", length = 50)
    private String userEmail;
    @Column(name = "user_mobile", length = 10)
    private Long userMobile;
    @Column(name = "user_name", length = 30)
    private String username;
    @Column(name = "user_pass", length = 30)
    private String userPass;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;
}
