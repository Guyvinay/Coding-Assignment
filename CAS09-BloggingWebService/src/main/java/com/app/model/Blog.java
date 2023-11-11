package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;
    private String title;
    private String body;
    @CreationTimestamp
    private LocalDateTime cDate;
    @UpdateTimestamp
    private LocalDateTime uDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;



}
