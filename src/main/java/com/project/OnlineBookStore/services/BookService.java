package com.project.OnlineBookStore.services; 

import java.util.List;
import java.util.Optional;

import com.project.OnlineBookStore.models.Book;

public interface BookService {
	List<Book> getAllBooks();
	Optional<Book> getBookById(int id);
	Book addBook(Book book);
	void deleteBook(int id); 
}
