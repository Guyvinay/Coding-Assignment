package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.exception.UsersRegistrationException;
import com.app.modal.Users;
import com.app.repo.UserRepository;

@Service
public class UserService {
	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder; // Use BCryptPasswordEncoder

	    public Users registerUsers(Users user) {
	        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
	            throw new UsersRegistrationException("Usersname is already taken");
	        }

	        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
	            throw new UsersRegistrationException("Email is already registered");
	        }

	        // Encrypt password before saving to the database
	        user.setPassword(passwordEncoder.encode(user.getPassword()));

	        return userRepository.save(user);
	    }
	
	    public String test(Users user) {
	    	return user.getEmail()+" "+user.getPassword();
	    }
	
}
