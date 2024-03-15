package com.app.repository;

import java.util.HashSet;
import java.util.Set;

import com.app.modal.Vehicle;

public class VehicleRepository {

	private Set<Vehicle> vehicles;
	
	public VehicleRepository() {
		this.vehicles = new HashSet<>();
	}
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
}
