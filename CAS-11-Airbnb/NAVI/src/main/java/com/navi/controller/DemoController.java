package com.navi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.modals.DemoDTO;
import com.navi.service.DemoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/navi")
public class DemoController {

	@GetMapping()
    public String sayHello(Model model) {
        // Add a model attribute named "message"
        model.addAttribute("message", "Hello, World!");
        // Return the logical view name
        return "helloView";
    }
	
	    @Autowired
	    private DemoService userService;

	    @PostMapping("/create")
	    public ResponseEntity<?> createUser(@Valid @RequestBody DemoDTO userDTO, BindingResult bindingResult) {
	    	System.out.println(bindingResult);
	        if (bindingResult.hasErrors()) {
	            // If validation errors exist, return bad request with error details
	            return ResponseEntity.badRequest().body(createErrorResponse(bindingResult));
	        }

	        // Process valid user data
	        DemoDTO user = userService.createUser(userDTO);
	        return ResponseEntity.ok().body(user);
	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<?> getUser(@PathVariable Long userId) {
	        DemoDTO userDTO = userService.getUser(userId);
	        if (userDTO != null) {
	            return ResponseEntity.ok(userDTO);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Method to create error response from BindingResult
	    private Map<String, String> createErrorResponse(BindingResult bindingResult) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : bindingResult.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return errors;
	    }

	
}
