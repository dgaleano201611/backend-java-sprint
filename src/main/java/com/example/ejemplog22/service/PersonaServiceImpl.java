package com.example.ejemplog22.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejemplog22.model.Persona;
import com.example.ejemplog22.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository repositorio;

    @Override
    public Optional<Persona> consultarPersonaPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Persona> consultarPersonas() {
        return repositorio.findAll();
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return repositorio.insert(persona);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return repositorio.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        repositorio.deleteById(id);
        
    }

    
    
    
}
