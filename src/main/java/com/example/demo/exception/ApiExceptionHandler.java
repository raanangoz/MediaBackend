package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
@ControllerAdvice

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MediaNotFoundException.class})
    public ResponseEntity<Object> handleMediaNotFoundException(MediaNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> handleSQLConstaintViolation(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity<Object>("SQL constraint violated",HttpStatus.CONFLICT);
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleGeneralException(Exception e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.CONFLICT);
    }
}


