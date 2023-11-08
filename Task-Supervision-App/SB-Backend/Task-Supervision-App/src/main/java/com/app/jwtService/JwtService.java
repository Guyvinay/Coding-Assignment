package com.app.jwtService;


import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.app.model.Profile;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtService {

	public String jwtTokenGeneration(Profile profile) {
		SecretKey key = Keys.hmacShaKeyFor(JwtVars.JWT_KEY.getBytes());
		Date now = new Date();
		Date validTill = new Date(System.currentTimeMillis() + 30L * 24 * 3600 * 1000);
		
		String token =  Jwts
		                  .builder()
		                  .setSubject(profile.getEmail())
		                  .claim("role", profile.getRole())
		                  .setIssuedAt(now)
		                  .setExpiration(validTill)
		                  .signWith(key)
		                  .compact();
		return token;
	}
	
}
