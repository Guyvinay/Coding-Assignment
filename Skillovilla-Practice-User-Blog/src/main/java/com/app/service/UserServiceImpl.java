package com.app.service;

import com.app.exception.UserNotFoundException;
import com.app.jwtImpl.JwtSource;
import com.app.modal.Users;
import com.app.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users getUserById(String _id) {
        Users user = usersRepository.findById(_id)
                .orElseThrow(
                        ()->new UserNotFoundException("User: "+_id+", not found!")
                );
        return user;
    }

    @Override
    public Users getUserByEmail(String email) {
        Users user = usersRepository.findById(email)
                .orElseThrow(
                        ()->new UserNotFoundException("User: "+email+", not found!")
                );
        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> list = usersRepository.findAll();
        if(list.isEmpty())throw new UserNotFoundException("No Users Found!");
        return list;
    }

    @Override
    public Users createUsers(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_" + user.getRole().toUpperCase());
        Users saveUser = usersRepository.save(user);
        return saveUser;
    }

    @Override
    public Users updateUsers(String user_id, Users user) {
        return null;
    }

    @Override
    public String deleteUsers(String email) {
        Users user = usersRepository.findById(email)
                .orElseThrow(
                        ()->new UserNotFoundException("User: "+email+", not found!")
                );

            usersRepository.delete(user);
        return "User "+email+", deleted successfully!";
    }

    @Override
    public Map<String, Object> loginUser(String email, String password) {
        Map<String, Object> map = new HashMap<>();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        JwtSource jwtSource = new JwtSource();
        String token = jwtSource.generateToken(
                new User(
                        email,
                        password,
                        authentication.getAuthorities())
        );
        map.put("token", token);
        map.put("email",email);
        map.put("stats","Login-Successfully");
        return map;
    }
}
