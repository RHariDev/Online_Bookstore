package com.project.OnlineBookStore.controller; 

import com.project.OnlineBookStore.models.Book;
import com.project.OnlineBookStore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "home"; 
    }
}
