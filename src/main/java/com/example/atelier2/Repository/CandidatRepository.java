package com.example.atelier2.Repository;

import com.example.atelier2.Entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface CandidatRepository extends JpaRepository<Candidate,Integer> {
    @Query("select c from Candidate c where c.nom like :nom")
    public Page<Candidate> candidatByNom (@Param("nom") String n, Pageable pageable) ;
}
