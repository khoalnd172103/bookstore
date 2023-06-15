package com.khoalnd.bookstore.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book")
@Schema(description = "Book Model Information")
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
    @Column(name = "language_id")
    private int languageId;
    @Schema(description = "Book's number of pages")
    @Column(name = "num_pages")
    private int numPage;
    @Schema(description = "Book's publication date")
    @Column(name = "publication_date")
    private Date publicationDate;
    @Schema(description = "Book's publisher Id")
    @Column(name = "publisher_id")
    private int publisherId;

    public Book() {
    }

    public Book(int id, String title, String isbn, int languageId, int numPage, Date publicationDate, int publisherId) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.languageId = languageId;
        this.numPage = numPage;
        this.publicationDate = publicationDate;
        this.publisherId = publisherId;
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", languageId='" + languageId + '\'' +
                ", numPage=" + numPage +
                ", publicationDate=" + publicationDate +
                ", publisherId=" + publisherId +
                '}';
    }
}
