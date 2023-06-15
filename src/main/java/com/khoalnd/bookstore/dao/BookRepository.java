package com.khoalnd.bookstore.dao;

import com.khoalnd.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
