package com.example.vault.exceptions;

public class ApplicationError extends RuntimeException {

    public ApplicationError(String message) {
        super(message);
    }
}
