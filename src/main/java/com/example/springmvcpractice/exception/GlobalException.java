package com.example.springmvcpractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(TransactionDemoException.class)
    public ResponseEntity<String> handlingTransactionException(TransactionDemoException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalException(Exception e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> calculatorException(NumberFormatException e) {
        return ResponseEntity.status(400).body("Enter the correct Numbers");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> argumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> employeeException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource Not Found")
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
