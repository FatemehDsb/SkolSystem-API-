package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.EnrollmentRequestDTO;
import com.example.SkolSystem_API.dto.EnrollmentResponseDTO;
import com.example.SkolSystem_API.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<EnrollmentResponseDTO> registerStudentOnCourse(@Valid @RequestBody EnrollmentRequestDTO request){

        return service.registerStudentOnCourse( request).map(e -> ResponseEntity.status(200).body(e)).orElse( ResponseEntity.status(418).build());
    }

    @GetMapping("/students")
    public List<EnrollmentResponseDTO> getStudentsInCourse(@RequestParam int courseid){

        return  service.getAllStudentsInCourse(courseid);
    }
}
