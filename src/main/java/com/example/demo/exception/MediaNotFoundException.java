package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class MediaNotFoundException extends RuntimeException {
    private final HttpStatus status = HttpStatus.NOT_FOUND;
    private final String message;
//    private final Throwable throwable;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

//    public Throwable getThrowable() {
//        return throwable;
//    }
    public MediaNotFoundException(String name) {

        this.message = "Book "+ name +" does not exist.";
//        this.throwable = throwable;
    }
}


