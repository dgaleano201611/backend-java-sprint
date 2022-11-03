package com.example.ejemplog22.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplog22.model.Persona;
import com.example.ejemplog22.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService servicio;

    @GetMapping
    public ResponseEntity<?> consultarPersonas(){
        return ResponseEntity.ok(servicio.consultarPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPersonaPorId(@PathVariable Long id){
        Optional<Persona> respuesta = servicio.consultarPersonaPorId(id);
        if (!respuesta.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(respuesta.get());
    }

    @PostMapping
    public ResponseEntity<?> insertaPersona(@RequestBody Persona persona){
        servicio.crearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearPersona(persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPersona(@PathVariable Long id, @RequestBody Persona persona){
        Optional<Persona> respuesta=servicio.consultarPersonaPorId(id);
        if(!respuesta.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarPersona(persona));
    }

    public ResponseEntity<?> eliminarPersona(@PathVariable Long id){
        Optional<Persona> respuesta=servicio.consultarPersonaPorId(id);
        if(!respuesta.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        servicio.eliminarPersona(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put( "mensaje", "Persona Eliminada"));
    }
}
