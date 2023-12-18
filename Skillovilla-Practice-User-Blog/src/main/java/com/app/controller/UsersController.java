package com.app.controller;

import com.app.modal.Users;
import com.app.service.UsersService;
import lombok.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
{
		    "name":"User One",
			"email":"userone@gmail.com",
			"password":"string",
			"phoneNo":"1234567890",
			"role":"admin",
			"address":"Patna",
			"dob":"2000-01-01"
	}
 */

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
    private UsersService usersService;

    @PostMapping()
    private ResponseEntity<Users> createUsers(@RequestBody Users user){
        return new ResponseEntity<Users>(usersService.createUsers(user), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{_id}")
    private ResponseEntity<Users> getUserById(@PathVariable("_id") String _id){
        return new ResponseEntity<Users>(usersService.getUserById(_id), HttpStatus.OK);
    }
    @GetMapping()
    private ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<List<Users>>(usersService.getAllUsers(), HttpStatus.OK);
    }
    @PutMapping(value = "/{_id}")
    private ResponseEntity<Users> updateUserById(@PathVariable("_id") String _id, @RequestBody Users user){
        return new ResponseEntity<Users>(usersService.updateUsers(_id, user), HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{email}")
    private ResponseEntity<String> deleteUserById(@PathVariable("email") String email){
        return new ResponseEntity<String>(usersService.deleteUsers(email), HttpStatus.OK);
    }

}
