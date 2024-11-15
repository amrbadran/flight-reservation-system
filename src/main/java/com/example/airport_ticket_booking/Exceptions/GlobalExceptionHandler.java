package com.example.airport_ticket_booking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AirportNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAirportNotFoundException(AirportNotFoundException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
