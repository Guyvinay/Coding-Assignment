package com.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;

    private String description;
    private LocalDate uDate;
    private LocalDate cDate;

    @ManyToOne
    @Column(name = "user_id")
    private Users user;

}
