package com.project.OnlineBookStore.repository; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.OnlineBookStore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	// Find books by title
    List<Book> findByTitle(String title);
    
    // Find books by author
    List<Book> findByAuthor(String author);
    
    // Find books by genre
    List<Book> findByGenre(String genre);

    // Find books by publisher
    List<Book> findByPublisher(String publisher);

    // Find books where title contains a specific keyword (case-insensitive)
    List<Book> findByTitleContainingIgnoreCase(String keyword); 
}