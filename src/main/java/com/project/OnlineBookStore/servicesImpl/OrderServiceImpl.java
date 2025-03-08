package com.project.OnlineBookStore.servicesImpl; 

import com.project.OnlineBookStore.models.*;
import com.project.OnlineBookStore.services.OrderService;
import com.project.OnlineBookStore.repository.OrderRepository; 
import com.project.OnlineBookStore.repository.OrderItemRepository;
import com.project.OnlineBookStore.repository.CartRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional; 

import java.util.List;
import java.util.ArrayList; 

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
    private OrderItemRepository orderItemRepository;
	
	@Autowired
    private CartRepository cartRepository;
	
	@Transactional
	@Override
	public Order placeOrder(User user) {
	    List<Cart> cartItems = cartRepository.findByUser(user);

	    if (cartItems.isEmpty()) {
	        return null; // No items in cart, can't place order
	    }

	    double totalPrice = cartItems.stream()
	            .mapToDouble(cart -> cart.getBook().getPrice() * cart.getQuantity())
	            .sum();

	    // Create and save the order FIRST
	    Order order = new Order(user, totalPrice);
	    order = orderRepository.save(order);  // **Ensure order is saved first**

	    // Create OrderItems and explicitly set Order reference
	    List<OrderItem> orderItems = new ArrayList<>();
	    for (Cart cart : cartItems) {
	        OrderItem orderItem = new OrderItem(cart.getBook(), cart.getQuantity(), cart.getBook().getPrice() * cart.getQuantity());
	        orderItem.setOrder(order);  // **Set the order reference**
	        orderItems.add(orderItem);
	    }

	    // Save all OrderItems
	    orderItemRepository.saveAll(orderItems);

	    // Update the Order with orderItems and save it again
	    order.setOrderItems(orderItems);
	    orderRepository.save(order);

	    // Clear the cart after placing the order
	    cartRepository.deleteByUser(user);

	    return order;
	} 
	
	@Override
	public List<Order> getOrdersByUser(User user) {
		return orderRepository.findByUser(user); 
	}
}
