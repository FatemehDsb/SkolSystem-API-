package com.example.SkolSystem_API.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class EnrollmentDto {

    @NotEmpty
    private int studentId;

    @NotEmpty
    private int courseId;

    @NotEmpty
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
