package com.example.SkolSystem_API.dto;

import jakarta.validation.constraints.*;

import java.util.List;

public class CourseDTO {
    @NotBlank(message = "A course title must be specified!")
    private String title;

    @NotBlank(message = "A course must have a teacher!")
    private String teacher;

    @Min(value = 1, message = "The maximum number of students in a course must be at least one!")
    private int maxStudents;

    @NotEmpty(message = "A course must have students!")
    private List<StudentDTO> students;

    public CourseDTO() {

    }

    public CourseDTO(String title, String teacher, int maxStudents,List<StudentDTO> students) {
        this.title = title;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.students = students;
    }
}
