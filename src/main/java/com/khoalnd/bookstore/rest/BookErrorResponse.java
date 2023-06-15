package com.khoalnd.bookstore.rest;

import io.swagger.v3.oas.annotations.media.Schema;

public class BookErrorResponse {
    @Schema(description = "HTTP Status error code", example = "400")
    private int status;

    @Schema(description = "Error message", example = "Book not found")
    private String message;

    public BookErrorResponse() {
    }

    public BookErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
