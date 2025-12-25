package com.aadya.bookinventorymanager.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.aadya.bookinventorymanager.model.Book;
import com.aadya.bookinventorymanager.service.BookService;

//@RestController
public class BookController {

	private BookService service;
	
	
	public BookController(BookService service) {
		super();
		this.service = service;
	}


	@GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @GetMapping("/books/author/{name}")
    public List<Book> getBooksByAuthor(@PathVariable String name) {
        return service.getBooksByAuthor(name);
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        return service.getAvailableBooks();
    }

    @PostMapping("/book")
    public Book insertBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        service.deleteBook(id);
    }
}