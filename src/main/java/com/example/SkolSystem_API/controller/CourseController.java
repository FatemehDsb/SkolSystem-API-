package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.CourseDTO;
import com.example.SkolSystem_API.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**<h4>Course controller</h4>
 * <li> Handles HTTP requests through REST controllers (GET, POST, PUT, DELETE).
 * <li> Manages authentication, request validation and JSON serialization/deserialization.
 * <li> Forwards processed requests to the Business Layer for further logic.
 */
@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getCourses() {
        return ResponseEntity.ok(service.getAll());
    }
}
