package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.modal.Users;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Users user) {
//		log.info("Inside Mail Service before simple mail");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("mrsinghvinay563@gmail.com");
		simpleMailMessage.setTo(user.getEmail());	
		simpleMailMessage.setSubject(user.getMailHeading());
		simpleMailMessage.setText("Dear "+user.getUsername() +",\n\n" + user.getMailBody());
//		log.info("Inside Mail Service after simple mail");

		javaMailSender.send(simpleMailMessage);
//		System.out.println(simpleMailMessage);
//		log.info("Inside Mail Service after send simple mail");
	}
}
