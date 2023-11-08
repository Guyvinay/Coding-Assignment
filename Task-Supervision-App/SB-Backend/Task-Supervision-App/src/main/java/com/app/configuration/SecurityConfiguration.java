package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		
		httpSecurity
		        .authorizeHttpRequests(auth->{
		        	auth
		        	.requestMatchers(HttpMethod.POST,"/api/tasks/createTask").permitAll()
		        	.requestMatchers(HttpMethod.POST,"/api/profile/createProfile").permitAll()
		        	.requestMatchers(HttpMethod.POST,"/api/profile/postSignIn").permitAll()
		        	.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
		        	  .anyRequest()
				       .authenticated();
		        })
		        .csrf(csrf->csrf.disable())
		         .formLogin(Customizer.withDefaults())
				   .httpBasic(Customizer.withDefaults());
		
		
		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
}
