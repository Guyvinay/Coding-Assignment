package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class Config {

	 @Bean
	    public Dotenv dotenv() {
	        return Dotenv.configure().filename(".env").load();
	    }
	
}
