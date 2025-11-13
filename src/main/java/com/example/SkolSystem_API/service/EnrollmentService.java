package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.EnrollmentDTO;
import com.example.SkolSystem_API.model.Enrollment;
import com.example.SkolSystem_API.repository.CourseRepository;
import com.example.SkolSystem_API.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public Optional<EnrollmentDTO> registerStudentOnCourse(EnrollmentDTO request){

//        if (request.getStudentId() <= 0){
//            System.out.println("No student id ");
//            return new EnrollmentDTO();
//        }
//
//        if (request.getCourseId() <= 0){
//            System.out.println("no course id " );
//            return new EnrollmentDTO();
//        }
//
//        if (request.getDate() == null){
//            System.out.println("no date ");
//            return EnrollmentDTO();
//        }

        // Validate:  inte överskrida kursens maxgräns.
//        if ( courseRepository.){
//        }

        // Validate:  inte lägga till samma student flera gånger i samma kurs
//        if ( courseRepository.){
//        }

        Enrollment enrollment = new Enrollment( request.getStudentId(), request.getCourseId(), request.getDate());

        return Optional.of( toEnrolmentDTO(enrollmentRepository.save(enrollment)));
    }

    public List<Enrollment> getAllStudentsInCourse(){

        return List.of();
        //return enrollmentRepository.findAll();
    }

    private EnrollmentDTO toEnrolmentDTO(Enrollment enrollment){

        return new EnrollmentDTO(enrollment.getStudentId(), enrollment.getCourseId(), enrollment.getDate());
    }
}
