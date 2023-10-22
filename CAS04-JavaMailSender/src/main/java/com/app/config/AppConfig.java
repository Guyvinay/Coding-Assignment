package com.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class AppConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
		   .authorizeHttpRequests(auth->{
			   auth
			   .requestMatchers(HttpMethod.POST,"/register").permitAll()
			   .requestMatchers(HttpMethod.POST,"/test").permitAll()
			       .anyRequest()
			       .authenticated();
		   })
		   .csrf(csrf->csrf.disable())
		   .formLogin(Customizer.withDefaults())
		   .httpBasic(Customizer.withDefaults())
		;
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		
		
		mailSenderImpl.setHost("smtp.elasticemail.com");
		mailSenderImpl.setPort(2525); 	
		mailSenderImpl.setUsername("indexvinay1@gmail.com");
		mailSenderImpl.setPassword("BA0A1DADDA5E3373FD3C29C931D8A14D2842");
		
		Properties props = mailSenderImpl.getJavaMailProperties();
		    props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");

		return mailSenderImpl;
	}
	
}
