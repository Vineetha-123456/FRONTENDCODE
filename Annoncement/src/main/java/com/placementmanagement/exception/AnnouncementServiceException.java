package com.placementmanagement.exception;
 
public class AnnouncementServiceException extends RuntimeException {
 
    // Constructor with custom message
    public AnnouncementServiceException(String message) {
        super(message);
    }
 
    // Constructor with custom message and cause
    public AnnouncementServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}