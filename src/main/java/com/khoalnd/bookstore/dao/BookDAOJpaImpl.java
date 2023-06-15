//package com.khoalnd.bookstore.dao;
//
//import com.khoalnd.bookstore.entity.Book;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class BookDAOJpaImpl implements BookDAO{
//
//    //Define field for entitymanager
//    private EntityManager entityManager;
//
//    //Set up constructor injection
//    @Autowired
//    public BookDAOJpaImpl(EntityManager theEntityManager) {
//        entityManager = theEntityManager;
//    }
//
//    @Override
//    public List<Book> findAll() {
//
//        TypedQuery<Book> theQuery = entityManager.createQuery("From Book", Book.class);
//
//        List<Book> books = theQuery.getResultList();
//
//        return books;
//    }
//
//    @Override
//    public Book findById(int id) {
//        Book book = entityManager.find(Book.class, id);
//
//        return book;
//    }
//
//    @Override
//    public Book save(Book book) {
//        Book newBook = entityManager.merge(book);
//
//        return newBook;
//    }
//
//    @Override
//    public void deleteById(int id) {
//        Book book = entityManager.find(Book.class, id);
//
//        entityManager.remove(book);
//    }
//}
