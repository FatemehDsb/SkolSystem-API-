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

    @PostMapping()
    public ResponseEntity<EnrollmentDTO> registerStudentOnCourse(@Valid @RequestBody EnrollmentDTO request){

        return service.registerStudentOnCourse(request).map(e -> ResponseEntity.status(200).body(e)).orElse( ResponseEntity.status(418).build());
    }
}
