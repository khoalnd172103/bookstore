package com.khoalnd.bookstore.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class BookExceptionHandler {

    //@ExceptionHandler
    public ResponseEntity<?> handleBookNotFound() {
//        BookErrorResponse error = new BookErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage("Book not found");
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new BookErrorResponse(HttpStatus.NOT_FOUND.value(), "Book not found"), HttpStatus.NOT_FOUND);
    }

    //@ExceptionHandler
    public ResponseEntity<?> handleBookAlreadyExist() {

        return new ResponseEntity<>(new BookErrorResponse(HttpStatus.CONFLICT.value(), "Book already exist"), HttpStatus.CONFLICT);
    }

    public ResponseEntity<?> handleBookBadRequest() {
        return new ResponseEntity<>(new BookErrorResponse(HttpStatus.BAD_REQUEST.value(), "Bad request"), HttpStatus.BAD_REQUEST);
    }
}
