package com.example.SkolSystem_API.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment(int enrollmentId, Student student, Course course, LocalDate date) {
        this.student = student;
        this.course = course;
        this.id = enrollmentId;
        this.date = date;
    }

    public Enrollment( Student student, Course course, LocalDate date) {
        this.student = student;
        this.course = course;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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