package com.app.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

//    @NotBlank
//    @Email
    private String email;

//    @NotBlank
    private String password;
    
    private String mailHeading;
    private String mailBody;

    // Other fields, getters, setters, and constructors as needed
}

