package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.CourseDTO;
import com.example.SkolSystem_API.dto.StudentDTO;
import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.model.Enrollment;
import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public CourseDTO toDTO(Course course) {
        CourseDTO dto =  new CourseDTO();
        dto.setTitle(course.getTitle());
        dto.setTeacher(course.getTeacher());
        dto.setMaxStudents(course.getMaxStudents());

        Set<StudentDTO> studentDTOs = new HashSet<>();
        for (Enrollment e : course.getEnrollments()) {
            if (e.getCourse().getId() != course.getId()) {
                continue;
            }
            Student s = e.getStudent();
            StudentDTO d = new StudentDTO(
                s.getName(),
                s.getAge(),
                s.getEmail()
            );
            studentDTOs.add(d);
        }
        dto.setStudents(studentDTOs);
        return dto;
    }

    public Course toEntity(CourseDTO dto) {
/* I have no idea how to do this...
        List<Enrollment> enrollments;

        return new Course(
            dto.getTitle(),
            dto.getTeacher(),
            dto.getMaxStudents(),
            enrollments
        );
*/
//        repository.findAll().
        return new Course("INVALID", "INVALID", 0, null);
    }
}
