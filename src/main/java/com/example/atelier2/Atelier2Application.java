package com.example.atelier2;

import com.example.atelier2.Entity.Candidate;
import com.example.atelier2.Repository.CandidatRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Atelier2Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelier2Application.class, args);
    }

    @Bean
    ApplicationRunner init(CandidatRepository repository) {
        return args -> {
            Stream.of("Amine", "salah", "Mohamed" , "shayma").forEach(nom -> {
                repository.save(new Candidate(nom));
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
