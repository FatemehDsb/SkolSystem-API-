package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.EnrollmentDTO;
import com.example.SkolSystem_API.model.Enrollment;
import com.example.SkolSystem_API.repository.CourseRepository;
import com.example.SkolSystem_API.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public boolean registerStudentOnCourse(EnrollmentDTO request){

        if (request.getStudentId() <= 0){
            System.out.println("No student id ");

            return false;
        }

        if (request.getCourseId() <= 0){
            System.out.println("no course id " );

            return false;
        }

        if (request.getDate() == null){
            System.out.println("no date ");

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

        int numberOfEnrollments = enrollmentRepository.getLength();

        Enrollment enrollment = new Enrollment( request.getStudentId(), request.getCourseId(), request.getDate());
        enrollmentRepository.save(enrollment);

        if ( (numberOfEnrollments + 1) == enrollmentRepository.getLength()){
            return true;
        } else {
            return false;
        }
    }

    public List<Enrollment> getAllStudentsInCourse(){
// is this a courseService method maybe?
        return enrollmentRepository.findAll();
    }
}
