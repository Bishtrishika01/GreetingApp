package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello " + firstName + "!";
        } else if (lastName != null) {
            return "Hello " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }

    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));
    }


    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<Greeting> updateGreeting(Long id, String message) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        });
    }

    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
