package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;

    private String description;
    @UpdateTimestamp
    private LocalDate uDate;
    @CreationTimestamp
    private LocalDate cDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
