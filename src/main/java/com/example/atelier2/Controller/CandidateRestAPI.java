package com.example.atelier2.Controller;

import com.example.atelier2.Entity.Candidate;
import com.example.atelier2.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/candidats")
public class CandidateRestAPI {
    private String title ="Bonjour Candidate Microservice";
    @RequestMapping("/hello")
    public  String sayHello(){
        System.out.println(title);
        return title;
    }
     @Autowired
    CandidateService candidateService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidate> createCandidat (@RequestBody Candidate candidat) {

        return new ResponseEntity<>(candidateService.addCandidate(candidat), HttpStatus.OK);
    }
    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidate> updateCandidet (@PathVariable(value ="id") int id , @RequestBody Candidate candidate ) {
        return new ResponseEntity<>(candidateService.updateCandidate(id, candidate), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidet (@PathVariable(value ="id") int id) {
        return new ResponseEntity<>(candidateService.deleteCandidat(id), HttpStatus.OK);
    }
}
