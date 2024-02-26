package com.navi.service;

import org.springframework.stereotype.Service;

import com.navi.modals.DemoDTO;

@Service
public class DemoService {

	public DemoDTO createUser(DemoDTO userDTO) {
        // Perform logic to create user
        // This could involve persisting user data to a database
		return userDTO;
    }

    public DemoDTO getUser(Long userId) {
        // Perform logic to fetch user by ID
        // This could involve querying a database
        return null; // Dummy implementation for demonstration
    }
	
}
