package com.example.ejemplog22.service;
import java.util.List;
import java.util.Optional;

import com.example.ejemplog22.model.Persona;
public interface PersonaService {
    public List<Persona> consultarPersonas();
    public Optional<Persona> consultarPersonaPorId(Long id);
    public Persona crearPersona(Persona persona);
    public Persona actualizarPersona(Persona persona);
    public void eliminarPersona(Long id);
    
}
