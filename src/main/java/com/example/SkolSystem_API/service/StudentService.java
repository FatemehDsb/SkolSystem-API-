package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.model.Student;
import com.example.SkolSystem_API.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.getAllStudents();
    }

}
