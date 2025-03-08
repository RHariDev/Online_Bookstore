package com.project.OnlineBookStore.controller; 

import com.project.OnlineBookStore.models.Book;
import com.project.OnlineBookStore.models.Cart;
import com.project.OnlineBookStore.models.User;
import com.project.OnlineBookStore.services.BookService;
import com.project.OnlineBookStore.services.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService; 
	
	@Autowired
	private BookService bookService; 
	
	@GetMapping("/view")
	public String viewCart(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/login";
		}
		
		List<Cart> cartItems = cartService.getUserCart(user);
		model.addAttribute("cartItems", cartItems);
		return "cart"; 
	}
	
	@PostMapping("/add")
	public String addToCart(@RequestParam("bookId") int bookId, @RequestParam("quantity") int quantity, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/login";
		}
		
		Book book = bookService.getBookById(bookId).orElse(null);
		
		if (book != null) {
			cartService.addToCart(user, book, quantity);
		}
		return "redirect:/cart/view"; 
	}
	
	@PostMapping("/clear")
	public String clearCart(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			cartService.clearCart(user);
		}
		return "redirect:/cart/view"; 
	}
}
