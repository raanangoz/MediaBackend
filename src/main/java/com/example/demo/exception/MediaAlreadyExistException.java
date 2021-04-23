package com.example.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;

public class MediaAlreadyExistException extends Throwable {

    private final HttpStatus status = HttpStatus.CONFLICT;
    private final String message;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public MediaAlreadyExistException(String name) {

        this.message = "Book "+ name +" Already exists.";

    }
}


