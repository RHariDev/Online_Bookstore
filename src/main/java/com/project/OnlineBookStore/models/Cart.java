package com.project.OnlineBookStore.models; 

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@Column(nullable = false)
	private int quantity;
	
//	@Column(nullable = false)
//	private Double price;
	
	public Cart() {}
	
	public Cart(User user, Book book, int quantity) {
		this.user = user;
		this.book = book;
		this.quantity = quantity;
//		this.price = price;
	}
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
//    public Double getPrice() {
//    	return price;
//    }
//    
//    public void setPrice(Double price) {
//    	this.price = price; 
//    }
}
