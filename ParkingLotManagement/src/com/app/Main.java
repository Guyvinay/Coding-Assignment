package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.app.modal.Floor;
import com.app.modal.ParkingLot;
import com.app.modal.Vehicle;
import com.app.modal.VehicleType;
import com.app.service.VehicleServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		//Creating Instance of Scanner Class
		Scanner scanner = new Scanner(System.in);
		
		//Creating Instance of VehicleServiceImpl Class to perform Vehicle ops.
		VehicleServiceImpl vehicleService = new VehicleServiceImpl();
		
		//Initializing Parking Lots with 2 floors with 5 Capacity
		List<Floor> floors = parkingLotInitMethod(2, 5);
		
		//Creating Instance of Parking Lot and pass Floors 
        ParkingLot parkingLot = new ParkingLot(floors);
        
//        List<Vehicle> vehicles = Arrays.asList(
//        		new Vehicle("Car01", "Model C","Red", VehicleType.CAR),
//        		new Vehicle("BUS01","Model B", "Blue", VehicleType.BUS) );
        
        // Add vehicles to the parking lot
        Vehicle vehicle1 = new Vehicle("Car01", "Model C","Red", VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("BUS01","Model B", "Blue", VehicleType.BUS);
        
        
        
        vehiclesInitMethod(vehicleService, vehicle1);
        vehiclesInitMethod(vehicleService, vehicle2);
        
        parkingLot.addVehicleToTheParkingLot(vehicle1);
        parkingLot.addVehicleToTheParkingLot(vehicle2);
        
		try {
			String pref = "";
			do {
				System.out.println("Choose below"
			                        +"\n" + 
						            "Press '1' Add Vehicle"
			                        +"\n" + 
			                        "Press '2' Remove a Vehicle"
			                        +"\n" +
			                        "Press '3' Remove a Vehicle From Parking Lot"
			                        +"\n" +
			                        "Press '4' All Vehicles"
			                        +"\n" + 
						            "Press '0' For Existing the System. " + "\n");
				
				pref = scanner.next();
				
				switch(pref) {
				case "1" : addVehicle(scanner, vehicleService,parkingLot);
				break;
				case "2" : removeVehicle(scanner, vehicleService);
				break;
				case "3" : removeVehicleFromParkingLot(scanner,vehicleService,parkingLot);
				break;
				case "4" : allVehicles(vehicleService);
				break;
				default : throw new IllegalArgumentException("Please Select a Valid one");
				
				}
			}
			while(!pref.equals("0"));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void removeVehicleFromParkingLot(Scanner scanner, VehicleServiceImpl vehicleService,
			ParkingLot parkingLot) {
		System.out.print("Enter ID of Vehicle you want to remove from Parking Lot!!");
		String id = scanner.next();
		vehicleService.removeVehicle(id);
		int charge = parkingLot.removeVehicleFromParkingLot(id);
		System.out.println(id+" Removed from Parking Lot");
		System.out.println("Charge: "+charge);
		
	}

	private static void allVehicles(VehicleServiceImpl vehicleService) {
		vehicleService.printAllVehicles();
	}

	private static void removeVehicle(Scanner scanner, VehicleServiceImpl vehicleService) {
		System.out.println("Enter Vehicle ID:- ");
		String id = scanner.next();
		vehicleService.removeVehicle(id);
		
	}

	private static void addVehicle(Scanner scanner, VehicleServiceImpl vehicleService, ParkingLot parkingLot) {
		
		
		VehicleType vehicleType = VehicleType.CAR;
		
		
		System.out.println("Enter Following details");
		System.out.println("Enter a ID :- ");
		String id = scanner.next();
		System.out.println("Enter Model Name :-");
		String model = scanner.next();
		System.out.println("Enter a COLOR");
		String color = scanner.next();
		System.out.println("Choose Vehice Type"+"/n"+"1. Car"+"/n"+"2. Bus"+"/n"+"3. Truck");
		String type = scanner.next();
		
		if(type.equals("1"))vehicleType = VehicleType.CAR;
		else if(type.equals("2"))vehicleType = VehicleType.BUS;
		else if(type.equals("2"))vehicleType = VehicleType.TRUCK;
		
		Vehicle vehicle = new Vehicle(id, model, color, vehicleType);
		
		vehicleService.addVehicle(vehicle);
		
		parkingLot.addVehicleToTheParkingLot(vehicle);
				
	}
	
	
	public static void vehiclesInitMethod(VehicleServiceImpl vehicleService, Vehicle vehicle) {
		
        vehicleService.addVehicle(vehicle);
	}
	
    public static List<Floor> parkingLotInitMethod(int numFloors, int spacesPerFloor) {
    	
        List<Floor> floors = new ArrayList<>();
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i, spacesPerFloor));
        }
        return floors;
    }
	
}
