package com.app.modal;

import java.util.ArrayList;
import java.util.List;


public class Floor {

	private int floorNumber;
    private int capacity;
    private List<Vehicle> vehicles;
    
    // Constructor
    public Floor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
    }
    //Getters and Setters Method

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Floor [floorNumber=" + floorNumber + ", capacity=" + capacity + ", vehicles=" + vehicles + "]";
	}

	
    
    
    
}
