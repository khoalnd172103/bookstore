package com.khoalnd.bookstore.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book")
@Schema(name = "Book", description = "Book Model Information")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Book Id", example = "1")
    private int id;
    @Column(name = "title")
    @Schema(description = "Book's title")
    private String title;
    @Schema(description = "Book's isbn")
    @Column(name = "isbn13")
    private String isbn;
    @Schema(description = "Book's languageId")
    @ManyToOne
    @JoinColumn(name = "language_id")
    private BookLanguage language;
    @Schema(description = "Book's number of pages")
    @Column(name = "num_pages")
    private int numPage;
    @Schema(description = "Book's publication date")
    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "author")
    @Schema(description = "Book's author")
    private String author;

    public Book() {
    }

    public Book(int id, String title, String isbn, BookLanguage language, int numPage, Date publicationDate, String author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.language = language;
        this.numPage = numPage;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", language=" + language +
                ", numPage=" + numPage +
                ", publicationDate=" + publicationDate +
                ", author='" + author + '\'' +
                '}';
    }
}
