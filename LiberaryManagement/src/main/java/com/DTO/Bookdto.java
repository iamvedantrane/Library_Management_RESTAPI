package com.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bookdto {
	@NotBlank(message = "Title is mandatory")
	@Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
	private String title;

	@NotBlank(message = "Author is mandatory")
	@Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
	private String author;
}
