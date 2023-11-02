package com.app.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product { //Inverse Side
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private String productName;
	private double price;
	private LocalDate cDate = LocalDate.now();
	private LocalDate uDate = LocalDate.now();
	
	@OneToMany(mappedBy = "product")
	private List<Review> reviews = new ArrayList<>();
	
}
