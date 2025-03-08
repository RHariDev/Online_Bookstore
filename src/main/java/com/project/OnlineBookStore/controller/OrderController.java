package com.project.OnlineBookStore.controller; 

import com.project.OnlineBookStore.models.Order;
import com.project.OnlineBookStore.models.User;
import com.project.OnlineBookStore.services.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/place")
	public String placeOrder(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/login";
		}
		
		Order order = orderService.placeOrder(user);
		if (order != null) {
			model.addAttribute("order", order);
			return "orderConfirmation";
		}
		else {
			model.addAttribute("error", "Failed to place the order.");
			return "cart";
		}
	}
	
	@GetMapping("/orders")
	public String viewOrders(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/login";
		}
		
		List<Order> orders = orderService.getOrdersByUser(user);
		model.addAttribute("orders", orders);
		return "orderHistory";     
	}
}
