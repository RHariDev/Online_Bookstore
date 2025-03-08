package com.project.OnlineBookStore.controller; 

import com.project.OnlineBookStore.models.User;
import com.project.OnlineBookStore.services.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	} 
	
	@PostMapping("/register")
	public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
		User user = new User(username, email, password);
		userService.registerUser(user);
		model.addAttribute("message", "Registration Successful! Please Login.");
		return "login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		Optional<User> user = userService.getUserByEmail(email);
		
		if (user.isPresent() && user.get().getPassword().equals(password)) {
			session.setAttribute("user", user.get());
			return "redirect:/home"; 
		}
		else {
			model.addAttribute("error", "Invalid email or password.");
			return "login"; 
		}
	}
	
	@GetMapping
	public String logOutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/home"; 
	}
}
