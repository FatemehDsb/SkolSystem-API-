package com.example.SkolSystem_API.repository;

import com.example.SkolSystem_API.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository(){
        students.add(new Student(1, "Alice Johnson", 21, "alice.johnson@example.com"));
        students.add(new Student(2, "Michael Smith", 23, "michael.smith@example.com"));
        students.add(new Student(3, "Emma Williams", 20, "emma.williams@example.com"));
        students.add(new Student(4, "James Brown", 22, "james.brown@example.com"));
        students.add(new Student(5, "Olivia Davis", 19, "olivia.davis@example.com"));
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Optional<Student> getStudentById(int id){
        return students.stream()
                .filter( p -> p.getId() == id)
                .findFirst();
    }
}
