package com.app.modal;

public class Vehicle {

	private String id;
	private String model;
	private String color;
	private VehicleType vehicleType;
	public Vehicle(String id, String model, String color, VehicleType vehicleType) {
		super();
		this.id = id;
		this.model = model;
		this.color = color;
		this.vehicleType = vehicleType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", color=" + color + ", vehicleType=" + vehicleType + "]";
	}
}
