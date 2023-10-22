package com.app;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class Cas04JavaMailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cas04JavaMailSenderApplication.class, args);
	}

	
	
}
