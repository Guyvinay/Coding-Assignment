package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.exception.ParkingSlotException;
import com.app.modal.Car;
import com.app.modal.ParkingSlot;
import com.app.repo.CarRepository;
import com.app.repo.ParkingSlotRepository;

import io.github.cdimascio.dotenv.Dotenv;
@Service
public class ParkingService {
	
	    @Autowired
	    private CarRepository carRepository;
	    @Autowired
	    private ParkingSlotRepository slotRepository;

	    
	    @Autowired
	    private Dotenv dotenv;

	    public int getMaxParkingLotSize() {
	        return Integer.parseInt(dotenv.get("PARKING_LOT_SIZE"));
	    }
	    
	    // Define the maximum parking lot size from environment variable
        	    
        private int maxParkingLotSize = getMaxParkingLotSize();

	    public ParkingSlot parkCar(String carNumber) {
	        if (isParkingLotFull()) {
	            throw new ParkingSlotException("Parking lot is full. Cannot park more cars.");
	        }

	        Car car = carRepository.findByCarNumber(carNumber);
	        if (car == null) {
	            car = new Car();
	            car.setCarNumber(carNumber);
	            car = carRepository.save(car);
	        }

	        ParkingSlot emptySlot = findEmptyParkingSlot();
	        emptySlot.setCarId(car.getId());
	        slotRepository.save(emptySlot);

	        return emptySlot;
	    }

	    public void unparkCar(int slotNumber) {
	        ParkingSlot parkingSlot = slotRepository.findBySlotNumber(slotNumber);
	        if (parkingSlot != null) {
	            parkingSlot.setCarId(null);
	            slotRepository.save(parkingSlot);
	        } else {
	            throw new ParkingSlotException("Slot number " + slotNumber + " not found.");
	        }
	    }

	    public Car getCarInformation(String carNumber) {
	        return carRepository.findByCarNumber(carNumber);
	    }

	    public ParkingSlot getSlotInformation(int slotNumber) {
	        return slotRepository.findBySlotNumber(slotNumber);
	    }

	    private boolean isParkingLotFull() {
	        long occupiedSlots = slotRepository.count();
	        return occupiedSlots >= maxParkingLotSize;
	    }

	    private ParkingSlot findEmptyParkingSlot() {
	        for (int slotNumber = 1; slotNumber <= maxParkingLotSize; slotNumber++) {
	            ParkingSlot slot = slotRepository.findBySlotNumber(slotNumber);
	            if (slot == null || slot.getCarId() == null) {
	                if (slot == null) {
	                    slot = new ParkingSlot();
	                    slot.setSlotNumber(slotNumber);
	                }
	                return slot;
	            }
	        }
	        throw new ParkingSlotException("Parking lot is full. Cannot find an empty slot.");
	    }
	}

	
//	@Autowired
//	private CarRepository carRepository;
	
//	@Autowired
//	private ParkingSlotRepository parkingSlotRepository;
//	
//	private int maxParkingSlotSize;
//	
//	public ParkingSlot parkCar(String carNumber) {
//		if(isParkingSlotFull())throw new ParkingSlotException("Parking Slots are Full!");
//		
//		Car car = carRepository.findByCarNumber(carNumber);
//		if(car==null) {
//			car = new Car();
//			car.setCarNumber(carNumber);
//			car = carRepository.save(car);
//		}
//		
//		ParkingSlot parkingSlot = findEmptyParkingSlot();
//		
//		parkingSlot.setCarId(car.getId());
//		parkingSlotRepository.save(parkingSlot);
//		
//		return parkingSlot;
//		
//	}
//	
//	public ParkingSlot findEmptyParkingSlot() {
//		return new ParkingSlot();
//	}
//	
//	public boolean isParkingSlotFull() {
//		return false;
//	}
//	
	
//}
