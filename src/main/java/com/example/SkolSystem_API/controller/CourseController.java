package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**<h4>Course controller</h4>
 * <li> Handles HTTP requests through REST controllers (GET, POST, PUT, DELETE).
 * <li> Manages authentication, request validation and JSON serialization/deserialization.
 * <li> Forwards processed requests to the Business Layer for further logic.
 */
@RestController
@RequestMapping("api/course")
public class CourseController {
    private CourseService service;

    @GetMapping
    public ResponseEntity<Course> getCourses() {
        return ResponseEntity.status(200).build();
    }
}
