package com.khoalnd.bookstore.rest;

import com.khoalnd.bookstore.dao.BookRepository;
import com.khoalnd.bookstore.entity.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "book", description = "Everything about your book")
public class BookRestController {
    // "/books" endpoint return a list of books

    @Autowired
    private BookRepository bookRepository;
//    public BookRestController(BookRepository theBookRepository) {
//        bookRepository = theBookRepository;
//    }


    @GetMapping("/books")
    @Operation(
            summary = "Get all books",
            description = "Retrieve all books in the book store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all books",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
    })
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{bookId}")
    @Operation(summary = "Get a book by ID", description = "Retrieve a book from the book store by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the book",
                    content = { @Content(mediaType = "application/json",
                                         schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = { @Content (schema = @Schema(implementation = BookErrorResponse.class))})
    })
    public ResponseEntity getBook(@PathVariable int bookId) {
        Optional<Book> result = bookRepository.findById(bookId);

        Book book = null;

        if(result.isPresent()) {
            book = result.get();
            return ResponseEntity.ok(book);
        }else {
            return new BookExceptionHandler().handleBookNotFound();
        }
    }

    @Operation(summary = "Add a book", description = "Add new book to the book store")
    @PostMapping("/books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully add the book",
                    content = { @Content(mediaType = "application/json"
                            )}),
            @ApiResponse(responseCode = "405", description = "Invalid input",
                    content = { @Content (schema = @Schema(implementation = BookErrorResponse.class))})
    })
    public ResponseEntity addBook(@RequestBody Book theBook) {
        Book book = bookRepository.save(theBook);

        if (book != null) {
            return ResponseEntity.ok(book);
        }else {
            return new BookExceptionHandler().handleBookBadRequest();
        }
    }


    @Operation(summary = "Update a book", description = "Update book information")
    @PutMapping("/books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update new book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = { @Content (schema = @Schema(implementation = BookErrorResponse.class))})
    })
    public ResponseEntity updateBook(@RequestBody Book newBook) {
        Optional<Book> result = bookRepository.findById(newBook.getId());

        if (result.isPresent()) {
            bookRepository.save(newBook);
            return ResponseEntity.ok(newBook);
        } else {
            return new BookExceptionHandler().handleBookNotFound();
        }
    }


    @Operation(summary = "Delete a book", description = "Delete book from the book store")
    @DeleteMapping("/books/{bookId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = { @Content (schema = @Schema(implementation = BookErrorResponse.class))})
    })
    public ResponseEntity deleteBook(@PathVariable int bookId) {
        Optional<Book> result = bookRepository.findById(bookId);

        Book book = null;

        if(result.isPresent()) {
            book = result.get();
            bookRepository.deleteById(bookId);
            return ResponseEntity.ok(book);
        }else {
            return new BookExceptionHandler().handleBookNotFound();
        }
    }
}
