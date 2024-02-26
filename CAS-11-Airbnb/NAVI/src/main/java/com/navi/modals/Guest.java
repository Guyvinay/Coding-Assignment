package com.navi.modals;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

	private String name;
	private String bio;
    private Gender gender;
    private LocalDate dateOfBirth;
	
}
