package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.ParkingSlotException;
import com.app.modal.Car;
import com.app.modal.ParkingSlot;
import com.app.repo.CarRepository;
import com.app.repo.ParkingSlotRepository;

@Service
public class ParkingService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ParkingSlotRepository parkingSlotRepository;
	
	private int maxParkingSlotSize;
	
	public ParkingSlot parkCar(String carNumber) {
		if(isParkingSlotFull())throw new ParkingSlotException("Parking Slots are Full!");
		
		Car car = carRepository.findByCarNumber(carNumber);
		if(car==null) {
			car = new Car();
			car.setCarNumber(carNumber);
			car = carRepository.save(car);
		}
		
		ParkingSlot parkingSlot = findEmptyParkingSlot();
		
		parkingSlot.setCarId(car.getId());
		parkingSlotRepository.save(parkingSlot);
		
		return parkingSlot;
		
	}
	
	public ParkingSlot findEmptyParkingSlot() {
		return new ParkingSlot();
	}
	
	public boolean isParkingSlotFull() {
		return false;
	}
	
	
}
