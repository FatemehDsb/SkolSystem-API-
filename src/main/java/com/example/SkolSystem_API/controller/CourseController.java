package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.CourseDTO;
import com.example.SkolSystem_API.service.CourseService;
import jakarta.validation.Valid;
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

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@Valid @RequestBody CourseDTO dto) {
        service.createCourse(dto);
        return ResponseEntity.ok("Course created successfully!");
    }
}
