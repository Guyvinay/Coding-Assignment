package com.navi.modals;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DemoDTO {

	    @NotBlank(message = "Name is required!!!")
	    private String name;

	    @NotBlank(message = "Email is required!!!")
	    @Email(message = "Email should be valid")
	    private String email;
	
}
