package com.aadya.bookinventorymanager.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aadya.bookinventorymanager.model.Book;
import com.aadya.bookinventorymanager.service.BookService;

@Controller
public class BookControllerMVC {
private BookService service;
	
	
	public BookControllerMVC(BookService service) {
		super();
		this.service = service;
	}
	// View a book by ID
    @GetMapping("/books/{id}")
    public String getBookById(Model model, @PathVariable int id) {
        Book book = service.getBookById(id);
        model.addAttribute("book", book);
        return "book-detail";
    }

    // Show update book page
    @GetMapping("/books/update/{id}")
    public String updatePage(Model model, @PathVariable int id) {
        model.addAttribute("book", service.getBookById(id));
        return "book-form";
    }

    // Delete a book
    @GetMapping("/books/delete/{id}")
    public String removeBook(@PathVariable int id) {
        service.deleteBook(id);
        return "redirect:/books";
    }

    // List all books
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = service.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    // Show add book page
    @GetMapping("/books/add")
    public String addPage(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    // Save (add or update) book
    @PostMapping("/books/save")
    public String insertBook(@ModelAttribute Book book) {
        service.saveBook(book);
        return "redirect:/books";
    }
}




	