package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modal.Users;
import com.app.repository.UsersRepository;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public Users registerUser(Users user) {
		
		
		
		return null;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
