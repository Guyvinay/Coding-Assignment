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
public class Host {

	private String hostName;
	private String hostStatus;
	private String hostLocatiion;
	private String about;
	private LocalDate hostingSince;
	
}
