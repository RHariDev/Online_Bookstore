package com.project.OnlineBookStore.repository; 

import com.project.OnlineBookStore.models.Cart;
import com.project.OnlineBookStore.models.User;
import com.project.OnlineBookStore.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByUser(User user); 
	Optional<Cart> findByUserAndBook(User user, Book book); 
	void deleteByUser(User user);
}
