package com.placementmanagement.exception;
 
public class JobServiceException extends RuntimeException {
 
    // Constructor with custom message
    public JobServiceException(String message) {
        super(message);
    }
 
    // Constructor with custom message and cause
    public JobServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}