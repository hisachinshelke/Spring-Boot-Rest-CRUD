package com.shelke.sachin.springbootrest.rest;

import com.shelke.sachin.springbootrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student data - only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Sachin", "Shelke"));
        theStudents.add(new Student("Kranti", "Shelke"));
        theStudents.add(new Student("John", "Foo"));
    }


    //define endpoint for /students - returns list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint for /students/{studentId} - return student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //just indexing the list - for now to keep it simple

        //check the studentId against the list size
        if (studentId > theStudents.size() || (studentId < 0)) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler  //exception response and type of exception it can handle
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        //create a studentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //response error body and status code
    }

}
