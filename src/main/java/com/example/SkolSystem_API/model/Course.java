package com.example.SkolSystem_API.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String teacher;
    private int maxStudents;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    public Course(int id, String title, String teacher, int maxStudents, List<Enrollment> enrollments) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.enrollments = enrollments;
    }

    public Course(String title, String teacher, int maxStudents, List<Enrollment> enrollments) {
        this.title = title;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.enrollments = enrollments;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", maxStudents=" + maxStudents +
                ", enrolledStudents=" + enrollments +
                '}';
    }
}
