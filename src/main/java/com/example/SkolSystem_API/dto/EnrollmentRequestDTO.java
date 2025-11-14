package com.example.SkolSystem_API.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public class EnrollmentRequestDTO {

    @NotNull
    private int studentId;

    @NotNull
    private int courseId;

    private LocalDate dateEnrolled;

    public EnrollmentRequestDTO(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
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

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }
}
