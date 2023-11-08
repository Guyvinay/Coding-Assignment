package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.exception.ProfileNotFoundException;
import com.app.jwtService.JwtService;
import com.app.model.Profile;
import com.app.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired private ProfileRepository profileRepository;
	
	@Autowired private PasswordEncoder passwordEncoder;
	
//	@Autowired private JwtService jwtService;
	
	@Override
	public Map<String, Object> createProfile(Profile profile) {
		Map<String, Object> map = new HashMap<>();
		
		profile.setPassword(passwordEncoder.encode(profile.getPassword()));
		profile.setRole("ROLE_"+profile.getRole().toUpperCase());
		Profile save = profileRepository.save(profile);
		
		if(save!=null) {
			map.put("msg", "User Successfully Created");
			map.put("userData", save);
			map.put("status", "OK");
		}else {
			map.put("msg", "User Creation Failed");
			map.put("status", "Bad-Request");
		}
		return map;		
	}

	@Override
	public Map<String, Object> getProfileById(Long id) {
		Map<String, Object> map = new HashMap<>(); 
		Optional<Profile> optional = profileRepository.findById(id);
		if(optional.isEmpty()) {
			map.put("Message", "User Not Found with id:- "+id);
			map.put("status", "NOT-FOUND");
		} else {
			map.put("userDetails", optional.get());
			map.put("status", "OK");
		}
		return map;
	}

	@Override
	public Map<String, Object> getProfileByEmail(String email) {
		Map<String, Object> map = new HashMap<>(); 
		Optional<Profile> optional = profileRepository.findByEmail(email);
		if(optional.isEmpty()) {
			map.put("Message", "User Not Found with Email:- "+email);
			map.put("status", "NOT-FOUND");
		} else {
			map.put("userDetails", optional.get());
			map.put("status", "OK");
		}
		return map;
	}

	@Override
	public Map<String, Object> getAllProfiles() {
		Map<String, Object> map = new HashMap<>(); 
		List<Profile> list = profileRepository.findAll();
		if(list.isEmpty()) {
			map.put("Message", "Users Not Found");
			map.put("status", "NOT-FOUND");
		} else {
			map.put("users", list);
			map.put("status", "OK");
		}
		return map;
	}

	@Override
	public Map<String, Object> generateJwtToken(Profile profile) {
		Map<String, Object> map = new HashMap<>();
		JwtService jwtService = new JwtService();
		String jwtToken = jwtService.jwtTokenGeneration(profile);
		map.put("token", jwtToken);
		map.put("email", profile.getEmail());
		map.put("role", profile.getRole());
		map.put("name", profile.getName());
		map.put("picture", profile.getProfilePic());
		return map;
	}

	@Override
	public Profile getProfileOnlyByEmail(String email) {
        Optional<Profile> optional = profileRepository.findByEmail(email);
		
		if(optional.isEmpty()) throw new UsernameNotFoundException("User "+email+" Not Found!");
		else {
			Profile profile = optional.get();
			
			return profile;
		}
	}



}
