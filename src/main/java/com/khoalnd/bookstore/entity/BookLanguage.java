package com.khoalnd.bookstore.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "book_language")
@Schema(name = "Language", description = "Language Model Information")
public class BookLanguage {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Language Id", example = "1")
    private int id;

    @Column(name = "language_code")
    @Schema(description = "Language's code")
    private String code;

    @Column(name = "language_name")
    @Schema(description = "Language's name")
    private String name;

    public BookLanguage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookLanguage{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
