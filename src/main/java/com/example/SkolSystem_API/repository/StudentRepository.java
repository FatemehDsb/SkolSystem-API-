package com.example.SkolSystem_API.repository;

import com.example.SkolSystem_API.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
