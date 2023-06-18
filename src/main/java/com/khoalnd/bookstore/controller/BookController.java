package com.khoalnd.bookstore.controller;

import com.khoalnd.bookstore.dao.BookLanguageRepository;
import com.khoalnd.bookstore.dao.BookRepository;
import com.khoalnd.bookstore.entity.Book;
import com.khoalnd.bookstore.entity.BookLanguage;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    private BookLanguageRepository bookLanguageRepository;

    public BookController(BookRepository theBookRepository, BookLanguageRepository theBookLanguageRepository) {
        bookRepository = theBookRepository;
        bookLanguageRepository = theBookLanguageRepository;
    }
    @GetMapping("/list")
    public String listBook(Model model) {
        List<Book> list = bookRepository.findAll();

        model.addAttribute("books", list);

        return "books/book-list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int bookId, Model model) {
        Optional<Book> book = bookRepository.findById(bookId);
        List<BookLanguage> languages = bookLanguageRepository.findAll();

        model.addAttribute("book", book);
        model.addAttribute("languages", languages);

        return "books/book-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Book book = new Book();
        List<BookLanguage> languages = bookLanguageRepository.findAll();

        model.addAttribute("book", book);
        model.addAttribute("languages", languages);

        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book, @RequestParam("selectedLanguage") BookLanguage selectedLanguage) {
        book.setLanguage(selectedLanguage);

        bookRepository.save(book);

        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int bookId) {
        bookRepository.deleteById(bookId);

        return "redirect:/books/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
