package com.example.SkolSystem_API.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    private int studentId;
    private int courseId;
    private LocalDate date;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Enrollment(int enrollmentId, int studentId, int courseId, LocalDate date) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    public Enrollment( int studentId, int courseId, LocalDate date) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
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
