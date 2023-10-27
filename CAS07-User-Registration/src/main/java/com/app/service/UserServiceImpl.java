package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.exceptions.UserNotFound;
import com.app.modal.Users;
import com.app.repository.UsersRepository;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Users registerUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_"+user.getRole().toUpperCase());
		return usersRepository.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUserDetails(String email) {
		return usersRepository.findByEmail(email)
				.orElseThrow( ()->
				new UserNotFound("User Not Found"));
		
	}

}
