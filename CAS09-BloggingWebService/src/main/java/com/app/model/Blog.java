package com.app.model;

import jakarta.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;
    private String title;
    private String body;
    private String cDate;
    private String uDate;

    @ManyToOne
    @Column(name = "user_id")
    private Users user;



}
