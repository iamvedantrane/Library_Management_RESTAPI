package com.ServiceIMPL;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.Userdto;
import com.Entity.Book;
import com.Entity.User;
import com.Repository.AdminRepo;
import com.Repository.UserRepo;
import com.Service.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private AdminRepo adminrepo;

	@Override
	public List<Book> borrowedBooks(long uid) {
		User user = userrepo.findById(uid).orElse(null);

		if (user != null) {
			return adminrepo.findByBorrowedBy(user);
		}
		return Collections.emptyList();
	}

	@Override
	public String registerUser(Userdto user) {
		User u = new User();

		u.setName(user.getName());
		u.setMobile(user.getMobile());
		u.setEmail(user.getEmail());
		u.setAddress(user.getAddress());

		userrepo.save(u);
		return "User Register Successfully....";
	}

	@Override
	public String updateUser(Userdto user, long uid) {

		Optional<User> existingUserOpt = userrepo.findById(uid);

		if (!existingUserOpt.isPresent()) {
			return "User not found with id " + uid;
		}
		User existingUser = existingUserOpt.get();

		existingUser.setName(user.getName());
		existingUser.setMobile(user.getMobile());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());

		userrepo.save(existingUser);

		return "User updated successfully!";
	}

	@Override
	public String deleteUser(long uid) {
		userrepo.deleteById(uid);
		return "User Deleted Successfully....";
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userrepo.findAll();
		if (users.isEmpty()) {
			System.out.println("No users found!");
		}
		return users;
	}

}
