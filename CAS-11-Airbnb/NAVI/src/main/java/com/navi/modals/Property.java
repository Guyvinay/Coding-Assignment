package com.navi.modals;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

	private String propertyId;
	private String propertyName;
	private String propertyLocation;
	private int rooms;
	private double pricePerNight;
	private boolean isAvailable;
	private ProperyType propertyType;
	
}
