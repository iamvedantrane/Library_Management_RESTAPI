package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Book;
import com.Entity.User;

public interface AdminRepo extends JpaRepository<Book, Long> {

	List<Book> findByBorrowedBy(User user);

}
