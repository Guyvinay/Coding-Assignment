package com.app.service;

import java.util.HashSet;
import java.util.Set;

import com.app.modal.Vehicle;

public class VehicleServiceImpl implements VehicleService{

    private Set<Vehicle> vehicles;
	
	public VehicleServiceImpl() {
		this.vehicles = new HashSet<>();
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
		printAllVehicles();
	}

	@Override
	public void removeVehicle(String id) {
		vehicles.removeIf((v)->v.getId().equals(id));
	}

	@Override
	public void printAllVehicles() {
		System.out.println("All Vehicles");
		for(Vehicle vehice:vehicles) {
			System.out.println(vehice);
		}
	}

}
