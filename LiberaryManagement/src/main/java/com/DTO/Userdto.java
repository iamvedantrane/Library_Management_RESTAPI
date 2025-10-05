package com.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Userdto {
	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Mobile number is mandatory")
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
	private String mobile;

	@NotBlank(message = "Address is mandatory")
	@Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
	private String address;
}
