package com.app.modal;

import java.util.List;

public class ParkingLot {

	//Initialising Number of Floors
    private List<Floor> numberOfFloors;
    
    // Constructor OF Parking Lot
    public ParkingLot(List<Floor> floors) {
        this.numberOfFloors = floors;
    }

    // Add vehicle to parking lot
    public void addVehicleToTheParkingLot(Vehicle vehicle) {
        for(Floor floor: numberOfFloors) {
        	if(floor.getCapacity()>=floor.getVehicles().size()) {
        		floor.getVehicles().add(vehicle);
        	}
        }
    }

    // Remove vehicle from parking lot
    public int removeVehicleFromParkingLot(String registrationNumber) {
    	int amount = 0;
        for(Floor floor: numberOfFloors) {
        	List<Vehicle> vehicles = floor.getVehicles();
//        	vehicles.removeIf((v)->v.getId().equals(registrationNumber));
        	for(Vehicle vehicle: vehicles) {
        		if(vehicle.getId().equals(registrationNumber)) {
        			amount = calCulateAmount(vehicle);
        			vehicles.remove(vehicle);
        		}
        		else throw new IllegalArgumentException("Vehicle With Id: "+registrationNumber+"  Not Found");
        	}
        }
        return amount;
    }

	private int calCulateAmount(Vehicle vehicle) {
		int am = 0;
		if(vehicle.getVehicleType().equals(VehicleType.BIKE))am+=10;
		else if(vehicle.getVehicleType().equals(VehicleType.CAR))am+=20;
		else am+=30;
		return am;
	}
	
}
