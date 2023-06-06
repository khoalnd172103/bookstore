//package com.khoalnd.bookstore.service;
//
//import com.khoalnd.bookstore.dao.BookDAO;
//import com.khoalnd.bookstore.dao.BookRepository;
//import com.khoalnd.bookstore.entity.Book;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BookServiceImpl implements BookService{
//
//    private BookRepository bookRepository;
//
//    public BookServiceImpl(BookRepository theBookRepository) {
//        bookRepository = theBookRepository;
//    }
//
//    @Override
//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
//
//    @Override
//    public Book findById(int id) {
//        Optional<Book> result = bookRepository.findById(id);
//
//        Book book = null;
//        if(result.isPresent()) {
//            book = result.get();
//        } else {
//            throw new RuntimeException("Book id not found - " + id);
//        }
//
//        return book;
//    }
//
//    @Override
//    public Book save(Book book) {
//        return bookRepository.save(book);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        bookRepository.deleteById(id);
//    }
//}
