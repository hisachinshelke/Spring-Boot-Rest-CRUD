package com.shelke.sachin.springbootrest.rest;

import com.shelke.sachin.springbootrest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for /students - returns list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Sachin", "Shelke"));
        theStudents.add(new Student("Kranti", "Shelke"));
        theStudents.add(new Student("John", "Foo"));

        return theStudents;
    }
}
