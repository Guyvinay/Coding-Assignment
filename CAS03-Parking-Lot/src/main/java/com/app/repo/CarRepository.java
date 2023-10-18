package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Car;

public interface CarRepository extends  JpaRepository<Car, Long> {

	Car findByCarNumber(String carNumber);
	
}
