package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.modal.Owner;
import com.app.modal.Profile;
import com.app.repository.ProfileRepository;

@Service
public class ProfileSerImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	public static String ownerUrl = "https://api.github.com/users/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Profile getProfile(String username) {
		
		ResponseEntity<Profile> responseEntity = restTemplate.getForEntity(
				ownerUrl+username, 
				Profile.class
				);
//		System.out.println(responseEntity.getHeaders());
		Profile owner = responseEntity.getBody();
		
		return owner;
	}

	@Override
	public Profile saveProfile(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile getSavedProfile(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile getAllSavedProfile() {
		// TODO Auto-generated method stub
		return null;
	}

}
