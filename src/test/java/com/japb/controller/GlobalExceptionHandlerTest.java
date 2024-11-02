package com.japb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandlePostNotFound() {
        // Arrange
        String expectedMessage = "Post not found";
        PostNotFoundException exception = new PostNotFoundException(expectedMessage);

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handlePostNotFound(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testHandleHttpClientErrorException() {
        // Arrange
        String errorMessage = "404 Not Found";
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, errorMessage);

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handleHttpClientErrorException(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Error by communicating with external service: " + errorMessage, response.getBody());
    }
}