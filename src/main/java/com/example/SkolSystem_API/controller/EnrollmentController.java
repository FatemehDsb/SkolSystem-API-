package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.EnrollmentDTO;
import com.example.SkolSystem_API.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    // @Valid
    @PostMapping()
    public ResponseEntity<String> registerStudentOnCourse(@RequestBody EnrollmentDTO request){

        boolean result = service.registerStudentOnCourse(request);

        return ResponseEntity.ok(  result ? "Enrollment went fine." : "Enrollment failed.");
    }
}
