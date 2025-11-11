package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.EnrollmentDTO;
import com.example.SkolSystem_API.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping()
    public boolean registerStudentOnCourse( @Valid @RequestBody EnrollmentDTO request){
        service.registerStudentOnCourse(request);
        return false;
    }
}
