package com.project.OnlineBookStore.servicesImpl;

import com.project.OnlineBookStore.repository.CartRepository;
import com.project.OnlineBookStore.services.CartService;
import com.project.OnlineBookStore.models.Book;
import com.project.OnlineBookStore.models.Cart;
import com.project.OnlineBookStore.models.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Transactional
	public void addToCart(User user, Book book, int quantity) {
		Cart cartItem = cartRepository.findByUserAndBook(user, book).orElse(null);
		
		if (cartItem != null) {
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
		}
		else {
			cartItem = new Cart(user, book, quantity);
		}
		cartRepository.save(cartItem); 
	}
	
	public List<Cart> getUserCart(User user) {
		return cartRepository.findByUser(user);
	}
	
	@Transactional
	public void clearCart(User user) {
		cartRepository.deleteByUser(user);
	}
}
