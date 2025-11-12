package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.CourseDTO;
import com.example.SkolSystem_API.dto.StudentDTO;
import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**<h4>Course Service</h4>
 * The Business Layer is responsible for implementing the application's core logic. It consists of service classes that:
 * <li> Process and validate data.
 * <li> Handle authentication and authorization (integrating Spring Security if needed).
 * <li> Apply transaction management using @Transactional.
 * <li> Interact with the Persistence Layer to store or retrieve data.
 */
@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<CourseDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(this::toDTO)
            .toList()
        ;
    }

    private CourseDTO toDTO(Course course) {
        List<StudentDTO> students = new ArrayList<>();
        for (Student s : course.getEnrolledStudents()) {
            students.add(
                new StudentDTO(
                    s.getName(),
                    s.getAge(),
                    s.getEmail()
                )
            );
        }

        return new CourseDTO(
            course.getTitle(),
            course.getTeacher(),
            course.getMaxStudents(),
            students
        );
    }

    private Course toEntity(CourseDTO dto) {
        List<Student> students = new ArrayList<>();
        for (StudentDTO d: dto.getStudents()) {
            students.add(
                new Student(
                    d.getStudentName(),
                    d.getAge(),
                    d.getStudentEmail()
                )
            );
        }

        return new Course(
            dto.getTitle(),
            dto.getTeacher(),
            dto.getMaxStudents(),
            students
        );
    }
}
