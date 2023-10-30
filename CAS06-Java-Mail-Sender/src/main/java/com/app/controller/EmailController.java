package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Emails;
import com.app.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	

	@PostMapping(value = "/end")
	public ResponseEntity<Emails> sendEmail(Emails emailRequest){
		Emails sendEmail = emailService.sendEmail(emailRequest);
		return new ResponseEntity<Emails>(sendEmail,HttpStatus.ACCEPTED);
	}
	
}
