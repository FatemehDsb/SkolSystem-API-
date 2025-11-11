package com.example.SkolSystem_API.exception;

public class StudentNotFoundException extends RuntimeException{
    public  StudentNotFoundException(String message){
        super(message);
    }
}
