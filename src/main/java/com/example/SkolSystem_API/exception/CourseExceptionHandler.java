package com.example.SkolSystem_API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CourseExceptionHandler{
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Map<String, String>> potatismosMedKorv(CourseNotFoundException e) {
        Map<String, String> error = new HashMap<>();
        error.put("Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
