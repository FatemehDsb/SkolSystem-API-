package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.model.Enrollment;
import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.EnrollmentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // @Valid
    public boolean registerStudentOnCourse(){

        // Validate:  inte lägga till samma student flera gånger i samma kurs
        // Validate:  inte överskrida kursens maxgräns.
        return false;
    }

    public List<Enrollment> getAllStudentsInCourse(){
// is this a courseService method maybe?
        return enrollmentRepository.findAll();
    }
}
