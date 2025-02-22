package com.example.greetingapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "greetings") // Optional but recommended
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
