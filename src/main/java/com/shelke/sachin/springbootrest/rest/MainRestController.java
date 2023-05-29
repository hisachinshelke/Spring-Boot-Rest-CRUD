package com.shelke.sachin.springbootrest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MainRestController {

    //add endpoint for hello world
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Sachin Shelke";
    }
}
