package com.khoalnd.bookstore.entity;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "isbn13")
    private String isbn;
    @Column(name = "language_id")
    private String languageId;
    @Column(name = "num_pages")
    private int numPage;
    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "publisher_id")
    private int publisherId;

    public Book() {
    }

    public Book(int id, String title, String isbn, String languageId, int numPage, Date publicationDate, int publisherId) {
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

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
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
