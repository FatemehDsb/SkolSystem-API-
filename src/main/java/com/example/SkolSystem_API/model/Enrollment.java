package com.example.SkolSystem_API.model;

import java.time.LocalDate;

public class Enrollment {

    //private int enrollmentId;

    private int studentId;
    private int courseId;
    private LocalDate date;

    public Enrollment(int studentId, int courseId, LocalDate date) {
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
