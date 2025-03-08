package com.project.OnlineBookStore.models; 

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList; 

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", nullable = false)
    private Date orderDate;
    
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "status", nullable = false)
    private String status; // Example: "Pending", "Completed", "Cancelled"

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
        this.orderDate = new Date();
        this.status = "Pending";
        this.totalPrice = 0.0;
    }

    public Order(User user, Double totalPrice) {
        this.user = user;
        this.orderDate = new Date();
        this.totalPrice = totalPrice;
        this.status = "Pending";
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }
    
    public void setOrderItems(List<OrderItem> orderItems) {
    	this.orderItems = orderItems; 
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Double getTotalPrice() {
    	return totalPrice;
    }
    
    public void setTotalPrice(Double totalPrice) {
    	this.totalPrice = totalPrice; 
    }
}
