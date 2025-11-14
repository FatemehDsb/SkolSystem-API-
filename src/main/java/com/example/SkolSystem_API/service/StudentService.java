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

    public List<StudentDTO> getAll(){
        return repository.findAll()
                .stream()
                .map(StudentService::toDto)
                .toList();
    }

    static StudentDTO toDto (Student student){
        return new StudentDTO(student.getName(), student.getAge(), student.getEmail());
    }

    static Student toEntity ( StudentDTO studentdto){
        return new Student(studentdto.getStudentName(), studentdto.getAge(), studentdto.getStudentEmail());
    }

    public StudentDTO getById(int id){
      Student student =  repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found!"));
      return toDto(student);
    }

    public StudentDTO addStudent(StudentDTO s){
        //convert to entity to be saved in database
        Student student = repository.save(toEntity(s));
        //convert to dto to send back to client
        return toDto(student);
    }

}
