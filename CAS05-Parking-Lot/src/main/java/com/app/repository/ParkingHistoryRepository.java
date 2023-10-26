package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ParkingHistory;

public interface ParkingHistoryRepository extends JpaRepository<ParkingHistory, Long>  {

}
