package com.example.SkolSystem_API.service;

import com.example.SkolSystem_API.dto.StudentDTO;
import com.example.SkolSystem_API.exception.StudentNotFoundException;
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

    public List<StudentDTO> getAllStudents(){
        return repository.getAllStudents()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private StudentDTO toDto (Student student){
        return new StudentDTO(student.getName(), student.getAge(), student.getEmail());
    }

    public StudentDTO getStudentById(int id){
      Student student =  repository.getStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found!"));
      return toDto(student);
    }

}
