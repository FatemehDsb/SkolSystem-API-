package com.example.SkolSystem_API.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EnrollmentDto {

    @NotEmpty
    @Positive
    private int studentId;

    @NotEmpty
    @Positive
    private int courseId;

    @NotEmpty(message = "Missing ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public EnrollmentDto(int studentId, int courseId, LocalDate date) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
