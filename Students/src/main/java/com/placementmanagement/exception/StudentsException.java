package com.placementmanagement.exception;

public class StudentsException extends RuntimeException {

    // Constructor with custom message
    public StudentsException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public StudentsException(String message, Throwable cause) {
        super(message, cause);
    }
}