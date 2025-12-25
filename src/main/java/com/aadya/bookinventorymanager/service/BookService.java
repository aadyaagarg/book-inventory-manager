package com.aadya.bookinventorymanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aadya.bookinventorymanager.model.Book;
import com.aadya.bookinventorymanager.repository.BookRepository;

@Service
public class BookService {


	private BookRepository repository;

	public BookService(BookRepository repository) {
		super();
		this.repository = repository;


	}

	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	public List<Book> getBooksByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> getAvailableBooks() {
        return repository.findByAvailableTrue();
    }
	public Book saveBook(Book book) {
		return repository.save(book);
	}

    public Book updateBook(int id, Book book) {
        book.setId(id);
        return repository.save(book);
    }

	public void deleteBook(int id) {
		repository.deleteById(id);
		
	}

}
