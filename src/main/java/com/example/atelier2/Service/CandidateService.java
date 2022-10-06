package com.example.atelier2.Service;

import com.example.atelier2.Entity.Candidate;
import com.example.atelier2.Repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidatRepository candidatRepository ;
    public Candidate addCandidate (Candidate candidate){
         return candidatRepository.save(candidate) ;
    };
    public Candidate updateCandidate (int id, Candidate newcandidate) {
        if (candidatRepository.findById(id).isPresent()) {
            Candidate existingCandidate = candidatRepository.findById(id).get();
            existingCandidate.setNom(newcandidate.getNom());
            existingCandidate.setPrenom(newcandidate.getPrenom());
            existingCandidate.setEmail(newcandidate.getEmail());
            return candidatRepository.save(existingCandidate);
        } else
            return null;
    }
            public String deleteCandidat (int id) {
                if (candidatRepository.findById(id).isPresent()) {
                    candidatRepository.deleteById(id);
                    return "candidate supprimé";
                } else
                    return "candidate non supprimé";
            }
}
