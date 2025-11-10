package com.example.SkolSystem_API.model;

import java.util.List;

public class Course {
    private int id;
    private String title;
    private String teacher;
    private int maxStudents;
    private List<Student> enrolledStudents;

    public Course(int id, String title, String teacher, int maxStudents, List<Student> enrolledStudents) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.enrolledStudents = enrolledStudents;
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
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }
}
