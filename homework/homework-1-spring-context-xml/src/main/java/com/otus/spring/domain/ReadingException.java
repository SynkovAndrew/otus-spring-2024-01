package com.otus.spring.domain;

public class ReadingException extends RuntimeException {

    public ReadingException(String message) {
        super(message);
    }

    public ReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}