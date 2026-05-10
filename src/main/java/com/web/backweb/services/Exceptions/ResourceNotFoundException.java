package com.web.backweb.services.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object Id) {
        super("Resource not found. Id: " + Id);
    }
}
