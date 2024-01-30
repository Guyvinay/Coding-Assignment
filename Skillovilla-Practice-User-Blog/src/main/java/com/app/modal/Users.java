package com.app.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {



	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String _id;
	@NotBlank(message = "Name cannot be blank!")
	private String name;

	@Column(unique = true)
	@NotBlank(message = "Email cannot be blank!")
	@Email(
			regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
			message = "email should be in proper format i.e : johndoe@example.com"
	)
	private String email;

	@Pattern(regexp = "^[0-9]{10}" , message = "Mobile Number must be 10 digit")
	@NotBlank(message = "Mobile Number cannot be blank")
	@Column(unique = true)
	private String phoneNo;

	@Size(min = 8, message = "Password must be of minimum 8 characters.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).*$", message = "Password requirements not met")
	@NotBlank(message = "Password cannot be blank")	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@NotBlank(message = "Role cannot be blank!")
	private String role;

	private String address;

	@Past(message = "d-o-b must be in past")
	@NotNull(message = "d-o-b can't be blank")
	private LocalDate dob;
	
	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Blog> blogs = new ArrayList<>();
}
