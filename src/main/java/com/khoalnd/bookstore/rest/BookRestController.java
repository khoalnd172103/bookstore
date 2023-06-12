package com.khoalnd.bookstore.rest;

import com.khoalnd.bookstore.dao.BookRepository;
import com.khoalnd.bookstore.entity.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "book", description = "Read all books you want")
public class BookRestController {
    // "/books" endpoint return a list of books

    private BookRepository bookRepository;
    public BookRestController(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }


    @GetMapping("/books")
    @Operation(
            summary = "Get all books",
            description = "Retrieve all books in the book store",
            tags = { "books", "get" })
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{bookId}")
    @Operation(summary = "Get a book by ID", description = "Retrieve a book from the book store by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the book"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public Book getBook(@PathVariable int bookId) {
        Optional<Book> result = bookRepository.findById(bookId);

        Book book = null;

        if(result.isPresent()) {
            book = result.get();
        }

        return book;
    }

    @Operation(summary = "Update a book", description = "Update book information")
    @PostMapping("/books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update the book")
    })
    public Book addBook(@RequestBody Book newBook) {
        Book book = bookRepository.save(newBook);

        return book;
    }

    @Operation(summary = "Add a book", description = "Add new book to the book store")
    @PutMapping("/books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully add new book")
    })
    public Book updateBook(@RequestBody Book theBook) {
        Book book = bookRepository.save(theBook);

        return book;
    }

    @Operation(summary = "Delete a book", description = "Delete book from the book store")
    @DeleteMapping("/books/{bookId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete the book"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public Book deleteBook(@PathVariable int bookId) {
        Optional<Book> result = bookRepository.findById(bookId);

        Book book = null;

        if(result.isPresent()) {
            book = result.get();
        }

        bookRepository.deleteById(bookId);

        return book;
    }
}
