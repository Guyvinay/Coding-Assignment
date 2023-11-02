package com.app.modal;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/*
 * userId, description, creation date (cDate), update date (uDate), and a 
unique identifier (_id)
 */
@Entity
@Data
public class Review { //Owning side

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private String userId;
	private String description;
	private LocalDate cDate=LocalDate.now();
	private LocalDate uDate=LocalDate.now();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}
