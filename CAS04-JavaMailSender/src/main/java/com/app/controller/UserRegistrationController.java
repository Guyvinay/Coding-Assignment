package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Users;
import com.app.service.EmailService;
import com.app.service.UserService;

@RestController
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Users> registerUser(@RequestBody Users users){
		
		emailService.sendEmail(users.getEmail(), users.getUsername());
		
		return new ResponseEntity<Users>(userService.registerUsers(users),HttpStatus.ACCEPTED);
	}
	@PostMapping(value = "/test")
	public ResponseEntity<String> testingEndpoint(@RequestBody Users users){
		
//		emailService.sendEmail(users.getEmail(), users.getUsername());
		
		return new ResponseEntity<String>(userService.test(users),HttpStatus.ACCEPTED);
	}
	
}
