package com.project.OnlineBookStore.services;

import com.project.OnlineBookStore.models.Book;
import com.project.OnlineBookStore.models.User;
import com.project.OnlineBookStore.models.Cart;

import java.util.List;

public interface CartService {
	void addToCart(User user, Book book, int quantity); 
	List<Cart> getUserCart(User user);
	void clearCart(User user); 
}
