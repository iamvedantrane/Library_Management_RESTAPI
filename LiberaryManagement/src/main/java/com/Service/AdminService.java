package com.Service;

import java.util.List;
import java.util.Optional;

import com.DTO.Bookdto;
import com.Entity.Book;

public interface AdminService {

	List<Book> getAllBooks();

	String addBook(Bookdto book);

	Optional<Book> getBook(Long bid);

	String borrowBook(Long bid, Long uid);

	void deleteBook(Long bid);

	String returnBook(Long bid);

}
