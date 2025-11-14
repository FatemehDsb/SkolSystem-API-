package com.example.SkolSystem_API.dto;

import com.example.SkolSystem_API.model.Course;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

public class CourseDTO {
    @NotBlank(message = "A course title must be specified!")
    private String title;

    @NotBlank(message = "A course must have a teacher!")
    private String teacher;

    @Min(value = 1, message = "The maximum number of students in a course must be at least one!")
    private int maxStudents;

    private Set<StudentDTO> students;

    public CourseDTO() {

    }

    public CourseDTO(String title, String teacher, int maxStudents) {
        this.title = title;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.students = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }
    public Set<StudentDTO> getStudents() {
        return students;
    }
    public void setStudents(Set<StudentDTO> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", maxStudents=" + maxStudents +
                ", students=" + students +
                '}';
    }
}
