package com.example.SkolSystem_API.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class StudentDTO {

    @NotEmpty
    private String studentName;

    //ålder : minst ett visst värde
    @Min(10)
    private int age;

    //e-post: rätt format
    private String studentEmail;

    public StudentDTO(String studentName, int age, String studentEmail) {
        this.studentName = studentName;
        this.age = age;
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
