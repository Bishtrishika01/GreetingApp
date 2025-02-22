package com.example.greetingapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"Hello, GET!\"}";
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Hello, POST!\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello, PUT!\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Hello, DELETE!\"}";
    }
}
