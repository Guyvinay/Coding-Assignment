package com.app.repository;

import java.util.HashSet;
import java.util.Set;

import com.app.modal.Floor;

public class FloorRepository {

	private Set<Floor> floors;

    public FloorRepository() {
        this.floors = new HashSet<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
	
}
