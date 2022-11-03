package com.example.ejemplog22.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplog22.model.Persona;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Long> {
    
}
