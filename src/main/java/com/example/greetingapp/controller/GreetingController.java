package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return Map.of("message", greetingService.getGreeting(firstName, lastName));
    }

    @GetMapping("/{id}")
    public Map<String, String> findGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingService.findGreetingById(id);
        return greeting.map(g -> Map.of("message", g.getMessage()))
                .orElse(Map.of("error", "Greeting not found"));
    }

    @PostMapping
    public Greeting saveGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/{id}")
    public Map<String, String> updateGreeting(@PathVariable Long id, @RequestParam String message) {
        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, message);
        return updatedGreeting.map(g -> Map.of("message", g.getMessage()))
                .orElse(Map.of("error", "Greeting not found"));
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        return deleted ? Map.of("message", "Greeting deleted successfully")
                : Map.of("error", "Greeting not found");
    }
}
