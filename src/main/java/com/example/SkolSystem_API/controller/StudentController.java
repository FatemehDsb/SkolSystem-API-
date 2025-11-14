package com.example.SkolSystem_API.controller;

import com.example.SkolSystem_API.dto.StudentDTO;
import com.example.SkolSystem_API.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public List<StudentDTO>getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable int id){
        StudentDTO studentDto = service.getById(id);
        return ResponseEntity.ok(studentDto);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO s){
        StudentDTO dto = service.addStudent(s);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        boolean removed = service.deleteById(id);
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }







}
