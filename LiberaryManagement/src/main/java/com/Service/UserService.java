package com.Service;

import java.util.List;

import com.DTO.Userdto;
import com.Entity.Book;
import com.Entity.User;

public interface UserService {

	public List<Book> borrowedBooks(long uid);

	public String registerUser(Userdto user);

	public String updateUser(Userdto user, long uid);

	public String deleteUser(long uid);

	public List<User> getAllUsers();

}
