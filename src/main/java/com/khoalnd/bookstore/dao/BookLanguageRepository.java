package com.khoalnd.bookstore.dao;

import com.khoalnd.bookstore.entity.BookLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLanguageRepository extends JpaRepository<BookLanguage, Integer> {
}
