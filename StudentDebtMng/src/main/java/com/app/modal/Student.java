package com.app.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String _id;

	private String name;

	@Column(unique = true)
	private String email;

	private String college_name;

	private Double college_fee;

	private Double current_debt;

	private LocalDate admission_date;
	
	@OneToMany(mappedBy = "student_id")
	private List<Payment> payments = new ArrayList<>();
	
}
