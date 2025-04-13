package org.example.exceptions;

public class UnderAgeException extends RuntimeException {
    public UnderAgeException(String message) {
        super(message);
    }
}
