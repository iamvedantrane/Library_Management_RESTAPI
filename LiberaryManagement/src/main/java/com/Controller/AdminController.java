package com.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.Bookdto;
import com.Entity.Book;
import com.Service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return adminService.getAllBooks();
	}

	@GetMapping("/getBook/{bid}")
	public Optional<Book> getBook(@PathVariable Long bid) {
		return adminService.getBook(bid);
	}

	@PostMapping("/addBook")
	public String addBook(@Valid @RequestBody Bookdto book) {
		return adminService.addBook(book);
	}

	@DeleteMapping("/deleteBook/{bid}")
	public String deleteBook(@PathVariable Long bid) {
		adminService.deleteBook(bid);
		return "Book Deleted Successfully..";

	}

	@PostMapping("/borrowBook/{bid}/{uid}")
	public String borrowBook(@PathVariable Long bid, @PathVariable Long uid) {
		return adminService.borrowBook(bid, uid);
	}

	@PostMapping("/return/{bid}")
	public String returnBook(@PathVariable Long bid) {
		return adminService.returnBook(bid);

	}

}
