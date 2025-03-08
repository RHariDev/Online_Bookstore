package com.project.OnlineBookStore.repository; 

import com.project.OnlineBookStore.models.Order;
import com.project.OnlineBookStore.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUser(User user); 
}
 