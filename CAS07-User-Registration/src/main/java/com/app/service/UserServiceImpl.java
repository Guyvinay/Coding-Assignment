package com.app.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.exceptions.UserNotFound;
import com.app.modal.UserLoginRequest;
import com.app.modal.Users;
import com.app.repository.UsersRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserServiceImpl implements UsersService {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
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

	@Override
	public Map<String, Object> login(UserLoginRequest request) {

		String email = request.getEmail();
		String password = request.getPassword();
		Users user = usersRepository.findByEmail(email)
		.orElseThrow( ()->
		new UserNotFound("User Not Found"));
		
		if(passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			String token = generateToken(user);
			System.out.println(token);
			
			Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("userDetails", user);
            responseBody.put("token", token);
            return responseBody;
		}
		
		return null;
	}
	
	public String generateToken(Users user) {
		Date now = new Date();
		Date valid = new Date(now.getTime()+30 * 24 * 3600 * 1000);
		
		String token =  Jwts
				           .builder()
				           .setSubject(user.getEmail())
				           .claim("role", user.getRole())
				           .setIssuedAt(now)
				           .setExpiration(valid)
				           .signWith(secretKey)
				           .compact();
		return token;
	}

}
