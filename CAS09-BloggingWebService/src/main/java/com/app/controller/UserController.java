package com.app.controller;

import com.app.model.Users;
import com.app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired private UsersService usersService;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<Map<String, Object>> saveUsers(@RequestBody Users user){
        return new ResponseEntity<Map<String, Object>>(usersService.createUser(user), HttpStatus.CREATED);
    }
    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<Map<String, Object>> getAllUsers(){
        return new ResponseEntity<Map<String, Object>>(usersService.findAllUsers(), HttpStatus.CREATED);
    }
}
