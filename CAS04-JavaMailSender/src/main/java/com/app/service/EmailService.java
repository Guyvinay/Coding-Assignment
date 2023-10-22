package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String recpientEmail, String username) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(recpientEmail);
		simpleMailMessage.setSubject("this is simple message");
		simpleMailMessage.setText("Dear " + username + ",\n\nWelcome to Our App! Thank you for registering.");
		
		javaMailSender.send(simpleMailMessage);
	}
}
