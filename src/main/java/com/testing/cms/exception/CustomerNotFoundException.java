package com.testing.cms.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
