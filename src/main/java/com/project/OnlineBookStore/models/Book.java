package com.project.OnlineBookStore.models; 

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "author", length = 255)
    private String author;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "sub_genre", length = 100)
    private String subGenre;

    @Column(name = "height")
    private Integer height;

    @Column(name = "publisher", length = 100)
    private String publisher;
    
    @Column(name = "price", nullable = false)
    private Double price;

    public Book() {}

    public Book(String title, String author, String genre, String subGenre, Integer height, String publisher, Double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subGenre = subGenre;
        this.height = height;
        this.publisher = publisher;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public Double getPrice() {
    	return price;
    }
    
    public void setPrice(Double price) {
    	this.price = price;    
    } 
}
