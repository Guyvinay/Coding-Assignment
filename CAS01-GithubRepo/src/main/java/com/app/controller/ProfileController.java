package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Profile;
import com.app.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value = "/users/{username}")
	public ResponseEntity<Profile> getOwner(@PathVariable("username")String username){
//		System.out.println("HII");
		return new ResponseEntity<Profile>(profileService.getProfile(username), HttpStatus.ACCEPTED);

	}
	
}
