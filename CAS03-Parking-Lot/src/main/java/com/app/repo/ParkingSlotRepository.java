package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.ParkingSlot;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

	 ParkingSlot findBySlotNumber(int slotNumber);
	
}
