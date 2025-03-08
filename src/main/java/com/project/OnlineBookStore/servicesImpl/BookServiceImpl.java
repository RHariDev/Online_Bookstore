package com.project.OnlineBookStore.servicesImpl; 

import com.project.OnlineBookStore.models.Book;
import com.project.OnlineBookStore.repository.BookRepository;
import com.project.OnlineBookStore.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@Override
	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}
	
	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id); 
	}
}
