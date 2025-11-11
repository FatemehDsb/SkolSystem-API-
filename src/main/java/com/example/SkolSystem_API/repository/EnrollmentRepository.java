package com.example.SkolSystem_API.repository;

import com.example.SkolSystem_API.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Optional<Enrollment> findById(int id){
        return enrollments.stream()
                .filter(e -> e.getEnrollmentId() == id)
                .findFirst();
    }

    public List<Enrollment> findAll(){
        return enrollments;
    }

    public List<Enrollment> findAllInCourse( int courseId){
        return enrollments;
    }

    public void save(Enrollment enrollment){

        int newtId = enrollments.stream().mapToInt(Enrollment::getEnrollmentId).max().orElse(0) + 1;
        enrollment.setEnrollmentId(newtId);
        enrollments.add(enrollment);
    }

    public boolean deleteById(int id){

        return enrollments.removeIf(e -> e.getEnrollmentId() == id);
    }
}