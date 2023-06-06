//package com.khoalnd.bookstore.rest;
//
//import com.khoalnd.bookstore.entity.Book;
//import com.khoalnd.bookstore.service.BookService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class BookRestController {
//    // "/books" endpoint return a list of books
//
//    private BookService bookService;
//    public BookRestController(BookService theBookService) {
//        bookService = theBookService;
//    }
//
//    @GetMapping("/books")
//    public List<Book> findAll() {
//        return bookService.findAll();
//    }
//
//    @GetMapping("/books/{bookId}")
//    public Book getBook(@PathVariable int bookId) {
//        Book book = bookService.findById(bookId);
//
//        if(book == null) {
//            throw new RuntimeException(("Book id not found - ") + bookId);
//        }
//
//        return book;
//    }
//
//    @PostMapping("/books")
//    public Book addBook(@RequestBody Book newBook) {
//        Book book = bookService.save(newBook);
//
//        return book;
//    }
//
//    @PutMapping("/books")
//    public Book updateBook(@RequestBody Book theBook) {
//        Book book = bookService.save(theBook);
//
//        return book;
//    }
//
//    @DeleteMapping("/books/{bookId}")
//    public String deleteBook(@PathVariable int bookId) {
//        Book book = bookService.findById(bookId);
//
//        if(book == null) {
//            throw new RuntimeException("Book id not found - " + bookId);
//        }
//
//        bookService.deleteById(bookId);
//
//        return "Deleted book id - " + bookId;
//    }
//}
