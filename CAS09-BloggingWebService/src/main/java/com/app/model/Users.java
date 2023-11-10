package com.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

}
