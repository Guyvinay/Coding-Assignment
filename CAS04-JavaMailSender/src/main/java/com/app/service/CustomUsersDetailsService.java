package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.modal.Users;
import com.app.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUsersDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optional = repository.findByEmail(username);
		if(optional.isEmpty()) {
			log.info("Inside Custom  UserDetailsService User not Varified");
			throw new UsernameNotFoundException("User not found with the Email: "+username);
		}
		else{
			Users user = optional.get();
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
//			grantedAuths.add(new SimpleGrantedAuthority(user.getRole()));
			log.info("Inside Custome UserDetailsService User Varified");
			return new User(user.getEmail(),user.getPassword(),grantedAuths);
		}
	}
}
