package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.model.Emails;
import com.app.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Override
	public Emails sendEmail(Emails emailRequest) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("mrsinghvinay563@gmail.com");
		mailMessage.setTo(emailRequest.getEmail());
		mailMessage.setSubject(emailRequest.getSubject());
		mailMessage.setText(emailRequest.getBody());
		System.out.println("Email");
		javaMailSender.send(mailMessage);
//		emailRepository.save(emailRequest);
		return emailRequest;
	}

}
