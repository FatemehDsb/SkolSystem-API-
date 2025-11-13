package com.example.SkolSystem_API.dto;

import com.example.SkolSystem_API.model.Course;
import com.example.SkolSystem_API.model.Student;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EnrollmentDTO {

    @NotEmpty
    @Positive
    private Student student;

    @NotEmpty
    @Positive
    private Course course;

    @NotEmpty(message = "Missing ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public EnrollmentDTO(Student student, Course course, LocalDate date) {
        this.student = student;
        this.course = course;
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
