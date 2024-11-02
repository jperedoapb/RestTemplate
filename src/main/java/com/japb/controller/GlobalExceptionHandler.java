package com.japb.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> handlePostNotFound(PostNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        // Extraer solo el mensaje relevante// Extraer solo el mensaje relevante
        String message = ex.getMessage().replaceFirst("^\\d{3} ", ""); // Eliminar el código de estado del mensaje
        return new ResponseEntity<>("Error by communicating with external service: " + message,
                HttpStatus.valueOf(ex.getStatusCode().value()));
    }
}
