package com.example.SkolSystem_API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class StudentDTO {

    @NotEmpty
    private String studentName;

    @Min(10)
    private Integer age;

    @Email(message = "Please enter valid email address!")
    @NotEmpty
    private String studentEmail;

    public StudentDTO(String studentName, int age, String studentEmail) {
        this.studentName = studentName;
        this.age = age;
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getAge() {
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
