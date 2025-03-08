package com.project.OnlineBookStore.repository; 

import com.project.OnlineBookStore.models.OrderItem; 

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
}
