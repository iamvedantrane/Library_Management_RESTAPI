package com.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.Userdto;
import com.Entity.Book;
import com.Entity.User;
import com.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/borrowedBooks/{uid}")
	public List<Book> borrowedBooks(@PathVariable long uid) {
		return userService.borrowedBooks(uid);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	

	@PostMapping("/registerUser")
	public String registerUser(@Valid @RequestBody Userdto user) {
		return userService.registerUser(user);
	}

	@PutMapping("/updateUser/{uid}")
	public String updateUser(@Valid @RequestBody Userdto user,@PathVariable long uid) {
		return userService.updateUser(user,uid);
	}

	@DeleteMapping("/deleteUser/{uid}")
	public String deleteUser(@PathVariable long uid) {
		return userService.deleteUser(uid);
	}
}
