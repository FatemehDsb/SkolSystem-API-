package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.StudentDTO;
import com.example.SkolSystem_API.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController ( StudentService service){
        this.service = service;
    }
    //Hämta alla studenter eller filtrera med RequestParam

    @GetMapping
    public List<StudentDTO>getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id){
        StudentDTO studentDto = service.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }






}
