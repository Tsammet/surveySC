package com.surveysc.surveysc.infrastructure.repositories.chapter.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}