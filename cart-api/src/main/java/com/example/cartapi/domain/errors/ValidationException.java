package com.example.cartapi.domain.errors;

/**
 * Exception indicating a validation error.
 */
public class ValidationException extends Exception {
    /**
     * Constructor for ValidationException.
     *
     * @param message The error message.
     */
    public ValidationException(String message) {
        super(message);
    }
}
