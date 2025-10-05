package com.ServiceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.Bookdto;
import com.Entity.Book;
import com.Entity.User;
import com.Repository.AdminRepo;
import com.Repository.UserRepo;
import com.Service.AdminService;

@Service
public class AdminServiceIMPL implements AdminService {

	@Autowired
	private AdminRepo adminrepo;

	@Autowired
	private UserRepo userrepo;

	@Override
	public List<Book> getAllBooks() {
		return adminrepo.findAll();

	}

	@Override
	public String addBook(Bookdto book) {
		Book b = new Book();
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());

		adminrepo.save(b);

		return "Book added Successfully..";
	}

	@Override
	public Optional<Book> getBook(Long bid) {
		return adminrepo.findById(bid);
	}

	@Override
	public String borrowBook(Long bid, Long uid) {
		Optional<Book> bookOpt = adminrepo.findById(bid);
		Optional<User> userOpt = userrepo.findById(uid);

		if (bookOpt.isPresent() && userOpt.isPresent()) {
			Book book = bookOpt.get();
			User user = userOpt.get();

			if (!book.isBorrowed()) {
				book.setBorrowed(true);
				book.setBorrowedBy(user);
				String today = java.time.LocalDate.now().toString();
				book.setTakenDate(today);

				String due = java.time.LocalDate.now().plusDays(14).toString();
				book.setDueDate(due);
				adminrepo.save(book);
				return "Book borrowed successfully by User ID: " + uid + ". Due on: " + due;
			} else {
				return "Book is already borrowed by another user.";
			}
		}
		return "Book or User not found.";
	}

	@Override
	public String returnBook(Long bid) {
		Optional<Book> bookOpt = adminrepo.findById(bid);

		if (bookOpt.isPresent()) {
			Book book = bookOpt.get();
			if (book.isBorrowed()) {
				book.setBorrowed(false);
				book.setBorrowedBy(null);
				book.setTakenDate(null);
				book.setDueDate(null);
				adminrepo.save(book);
				return "Book returned successfully.";
			} else {
				return "This book was not borrowed.";
			}
		}
		return "Book not found with ID: " + bid;
	}

	@Override
	public void deleteBook(Long bid) {
		adminrepo.deleteById(bid);

	}

}
