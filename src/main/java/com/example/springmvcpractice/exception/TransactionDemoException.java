package com.example.springmvcpractice.exception;

import org.springframework.http.HttpStatus;

public class TransactionDemoException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public TransactionDemoException(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }


    public String getMessage() {
        return message;
    }

}
