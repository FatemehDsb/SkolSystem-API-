package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.CourseDTO;
import com.example.SkolSystem_API.exception.CourseNotFoundException;
import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            .map(CourseService::toDTO)
            .toList()
        ;
    }

    public CourseDTO getById(int id) {
        return repository.findById(id)
            .map(CourseService::toDTO)
            .orElseThrow(
                () -> new CourseNotFoundException("No course found matching id: " + id)
            )
        ;
    }

    static CourseDTO toDTO(Course course) {
        CourseDTO dto =  new CourseDTO();
        dto.setTitle(course.getTitle());
        dto.setTeacher(course.getTeacher());
        dto.setMaxStudents(course.getMaxStudents());
        dto.setStudents(
            course.getEnrollments().stream()
                .map(e -> StudentService.toDto(e.getStudent()))
                .collect(Collectors.toSet())
        );
        return dto;
    }

    static Course toEntity(CourseDTO dto) {
        return new Course(
            dto.getTitle(),
            dto.getTeacher(),
            dto.getMaxStudents()
        );
    }

    public void createCourse(@Valid CourseDTO dto) {
        repository.save(CourseService.toEntity(dto));
    }
}
