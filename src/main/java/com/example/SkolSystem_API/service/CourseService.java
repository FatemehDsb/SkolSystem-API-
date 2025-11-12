package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.CourseDTO;
import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.repository.CourseRepository;
import org.springframework.stereotype.Service;

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
/*
        some_Optional<asfjhdvk> .map() .orElse() .build
                .of(askjhaslkjdhaslhd)
*/
        return repository.findAll()
            .stream().map(this::)
        ;
    }

    public CourseDTO toDTO(Course course) {
        return new CourseDTO();
    }
}
