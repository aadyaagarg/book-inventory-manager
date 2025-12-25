package com.aadya.bookinventorymanager.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aadya.bookinventorymanager.model.Book;
@RestController
public class FirstRestController {

 @RequestMapping("/hello")
    public String hello() {
        return "Hello Book Inventory Manager";
    }

    @RequestMapping("/book")
    public Book getBook() {
        return new Book(1, "The Alchemist", "Paulo Coelho", "Fiction", true);
    }
}
