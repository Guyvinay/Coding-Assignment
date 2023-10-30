package com.app;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {

	@Bean
    JavaMailSender javaMailSender() {
       
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		
//		System.out.println("Mail Sender");
		
		mailSenderImpl.setHost("smtp-relay.brevo.com");
		mailSenderImpl.setPort(587); 	
		mailSenderImpl.setUsername("mrsinghvinay563@gmail.com");
		mailSenderImpl.setPassword("xsmtpsib-c2134a69bf956c699ba4783b06aba46ce11604c695dbd6f36be6244b7f044cd1-m2K079bU54JntG8s");
		
		Properties props = mailSenderImpl.getJavaMailProperties();
		    props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        
//	        System.out.println(mailSenderImpl);
	        
		return mailSenderImpl;
	}
	
}
