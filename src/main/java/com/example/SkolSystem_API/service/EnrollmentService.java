package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.EnrollmentDto;
import com.example.SkolSystem_API.model.Enrollment;
import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.CourseRepository;
import com.example.SkolSystem_API.repository.EnrollmentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public boolean registerStudentOnCourse(EnrollmentDto request){

        if (request.getStudentId() <= 0){
            return false;
        }

        if (request.getCourseId() <= 0){
            return false;
        }

        if (request.getDate() == null){
            return false;
        }

        // Validate:  inte överskrida kursens maxgräns.
//        if ( courseRepository.){
//
//        }

        // Validate:  inte lägga till samma student flera gånger i samma kurs
//        if ( courseRepository.){
//
//        }


        Enrollment enrollment = new Enrollment( request.getStudentId(), request.getCourseId(), request.getDate());

        enrollmentRepository.save(enrollment);
        return false;
    }

    public List<Enrollment> getAllStudentsInCourse(){
// is this a courseService method maybe?
        return enrollmentRepository.findAll();
    }
}
