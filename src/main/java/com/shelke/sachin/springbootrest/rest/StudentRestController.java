package com.shelke.sachin.springbootrest.rest;

import com.shelke.sachin.springbootrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return theStudents.get(studentId);
    }

}
