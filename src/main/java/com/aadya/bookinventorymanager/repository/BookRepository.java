package com.aadya.bookinventorymanager.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aadya.bookinventorymanager.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByAuthor(String author);
    List<Book> findByAvailableTrue();

}






