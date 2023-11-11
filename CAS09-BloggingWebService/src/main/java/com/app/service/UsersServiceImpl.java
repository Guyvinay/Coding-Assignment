package com.app.service;


import com.app.model.Users;
import com.app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired private UsersRepository usersRepository;

    @Override
    public Map<String, Object> createUser(Users user) {

        Map<String, Object> map = new HashMap<>();
        map.put("user",usersRepository.save(user));
        return map;
    }

    @Override
    public Map<String, Object> findUserById(String _id) {
        Map<String, Object> map = new HashMap<>();
        Optional<Users> optional = usersRepository.findById(_id);
        if(optional.isPresent()){
            map.put("user", optional.get());
        }else{
            map.put("status", "User not found");
        }
        return map;
    }

    @Override
    public Map<String, Object> findUsersByEmail(String email) {
        Map<String, Object> map = new HashMap<>();
        Optional<Users> optional = usersRepository.findByEmail(email);
        if(optional.isPresent()){
            map.put("user", optional.get());
        }else{
            map.put("status", "User not found");
        }
        return map;
    }

    @Override
    public Map<String, Object> findAllUsers() {

        List<Users> users = usersRepository.findAll();

        Map<String, Object> map = new HashMap<>();
        if(!users.isEmpty()){
            map.put("users", users);
            map.put("total_users",users.size());
        }else{
            map.put("users","No users available");
        }

        return map;
    }

    @Override
    public Map<String, Object> deleteUserById(String _id) {
        Optional<Users> optional =  usersRepository.findById(_id);
        usersRepository.deleteById(_id);
        return null;
    }
}
