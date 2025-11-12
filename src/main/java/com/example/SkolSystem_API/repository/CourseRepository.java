package com.example.SkolSystem_API.repository;

import com.example.SkolSystem_API.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**<h4>Course Repository</h4>
 * The Persistence Layer manages database transactions and storage logic. It consists of repository classes using Spring Data JPA, Hibernate or R2DBC for data access. It is responsible for:
 * <li> Mapping Java objects to database records using ORM frameworks.
 * <li> Managing CRUD (Create, Read, Update, Delete) operations.
 * <li> Supporting relational and NoSQL databases.
 */
@Repository
public class CourseRepository {
    private List<Course> courses;

    public CourseRepository(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(int id) {
        return courses
            .stream()
            .filter(c -> c.getId() == id)
            .findFirst();
    }

    public List<Course> findByName(String title) {
        return courses.stream()
            .filter(
                c-> c.getTitle()
                    .toLowerCase()
                    .contains(
                        title.toLowerCase()
                    )
            ).toList();
    }

    public Course save(Course course) {
        int nextId = courses.stream()
            .mapToInt(c -> c.getId())
            .max()
            .orElse(0) + 1;
        course.setId(nextId);
        courses.add(course);
        return course;
    }

    public boolean deleteById(int id) {
        return courses.removeIf(c -> c.getId() == id);
    }
}
