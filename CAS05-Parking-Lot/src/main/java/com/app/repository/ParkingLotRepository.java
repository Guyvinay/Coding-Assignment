package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ParkingLot;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

}
