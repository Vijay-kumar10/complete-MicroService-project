package com.hotelservice.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException() {
        super("Resource not found in database !!");
    }
}
