package com.app.modal;

import java.time.LocalDate;
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
	private double price;
	private LocalDate cDate;
	private LocalDate uDate;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Review> reviews;
	
}
