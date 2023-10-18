package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ParkingSlotException;
import com.app.modal.Car;
import com.app.modal.ParkingSlot;
import com.app.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/park")
    public ResponseEntity<ParkingSlot> parkCar(@RequestBody String carNumber) {
        try {
            ParkingSlot parkingSlot = parkingService.parkCar(carNumber);
            return new ResponseEntity<>(parkingSlot, HttpStatus.OK);
        } catch (ParkingSlotException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/unpark/{slotNumber}")
    public ResponseEntity<String> unparkCar(@PathVariable int slotNumber) {
        try {
            parkingService.unparkCar(slotNumber);
            return new ResponseEntity<>("Car unparked successfully", HttpStatus.OK);
        } catch (ParkingSlotException e) {
            return new ResponseEntity<>("Slot not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/car/{carNumber}")
    public ResponseEntity<Car> getCarInformation(@PathVariable String carNumber) {
        Car car = parkingService.getCarInformation(carNumber);
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slot/{slotNumber}")
    public ResponseEntity<ParkingSlot> getSlotInformation(@PathVariable int slotNumber) {
        ParkingSlot slot = parkingService.getSlotInformation(slotNumber);
        if (slot != null) {
            return new ResponseEntity<>(slot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

