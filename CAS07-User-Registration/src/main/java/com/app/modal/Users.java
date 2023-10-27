package com.app.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotBlank(message = "First Name cannot be blank")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;
	
	@Email(message = "Email Must be in Valid Format")
	@NotBlank(message = "Email Name cannot be blank")
	private String email;
	
	@Pattern(regexp = "^[0-9]{10}" , message = "Mobile Number must be 10 digit")
	@NotBlank(message = "Mobile Number cannot be blank")
	private String mobile;
	
	@Size(min = 8, message = "Password must be of minimum 8 characters.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).*&" , message = "Password must contain at least one Uppercase Later, one special character, and must not contain whitespaces.")
	@NotBlank(message = "Password cannot be blank")
	private String password;
	
	@NotBlank(message = "Role cannot be blank")
	private String role;
	
	@NotBlank(message = "Status cannot be blank")
	private String status;
	
}
