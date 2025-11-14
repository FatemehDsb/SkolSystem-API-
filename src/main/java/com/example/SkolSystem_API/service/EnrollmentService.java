package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.EnrollmentRequestDTO;
import com.example.SkolSystem_API.dto.EnrollmentResponseDTO;
import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.model.Enrollment;
import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.CourseRepository;
import com.example.SkolSystem_API.repository.EnrollmentRepository;
import com.example.SkolSystem_API.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Optional<EnrollmentResponseDTO> registerStudentOnCourse(EnrollmentRequestDTO request){

        System.out.println("TO HERE");
        if (request.getStudentId() < 1){
            return Optional.empty();
        }

        if (request.getCourseId() < 1){
            return Optional.empty();
        }

        if (request.getDateEnrolled() == null){
            return Optional.empty();
        }

        Student student = studentRepository.getById(request.getStudentId());

        Course course = courseRepository.getById(request.getCourseId());

//        // Validate: Max participants in course
//        Long studentCount = enrollmentRepository
//                .findAll()
//                .stream()
//                .filter(e -> e.getCourse().getId() == request.getCourse().getId())
//                .count();
//
//        if ( request.getCourse().getMaxStudents() <= studentCount ){
//            return Optional.empty();
//        }
//
//        // Validate: block duplicate enrollments
//        boolean isAllreadyEnrolled = enrollmentRepository.existsById((long) request.getStudent().getId());
//
//        if ( isAllreadyEnrolled ){
//            return Optional.empty();
//        }

        Enrollment enrollment = toEnrollmentEntity(student, course, request.getDateEnrolled());
        //enrollmentRepository.save(enrollment);

        return Optional.of(toEnrolmentDTO(enrollmentRepository.save(enrollment)));
    }

    public List<EnrollmentResponseDTO> getAllStudentsInCourse(int courseId){

        List<Enrollment> enrollments = enrollmentRepository.findAll()
                .stream()
                .filter(e -> e.getCourse().getId() == courseId)
                .toList();

        return enrollments.stream().map(this::toEnrolmentDTO).toList();
    }

    private EnrollmentResponseDTO toEnrolmentDTO(Enrollment enrollment){

        return new EnrollmentResponseDTO(
                enrollment.getStudent(),
                enrollment.getCourse(),
                enrollment.getDate()
        );
    }

    private Enrollment toEnrollmentEntity(Student student, Course course, LocalDate enrolledDate){

        return new Enrollment( student, course, enrolledDate);
    }
}
