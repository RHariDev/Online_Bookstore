package com.project.OnlineBookStore.services; 

import com.project.OnlineBookStore.models.Order;
import com.project.OnlineBookStore.models.User;

import java.util.List;

public interface OrderService {
	Order placeOrder(User user);
	List<Order> getOrdersByUser(User user);     
}
