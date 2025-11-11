package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.exception.StudentNotFoundException;
import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.getAllStudents();
    }

    public Student getStudentById(int id){
        return repository.getStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found!"));
    }

}
