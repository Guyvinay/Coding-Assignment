package com.app.service;

import com.app.modal.Vehicle;

public interface VehicleService {

	public void addVehicle(Vehicle vehicle);
	public void removeVehicle(String id);
	public void printAllVehicles();
}
