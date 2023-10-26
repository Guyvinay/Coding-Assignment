package com.app.service;

import java.util.List;

import com.app.model.ParkingLot;

public interface ParkingLotService {

	public List<ParkingLot> getAllParkingLots();
	public ParkingLot getParkingLotById(Long id);
	public void createParkingLot(ParkingLot parkingLot);
	public void updateParkingLot(ParkingLot parkingLot);
	public void deleteParkingLot(Long id) ;
	
}
