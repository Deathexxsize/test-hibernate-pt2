package org.example.exceptions;

public class NameTooShortException extends RuntimeException {
    public NameTooShortException(String message) {
        super(message);
    }
}
