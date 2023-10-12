package com.prueba.demoPrueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.demoPrueba.models.Persona;
import com.prueba.demoPrueba.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> actualizarPersona(Long id, Persona persona) {
        if (personaRepository.existsById(id)) {
            persona.setId(id);
            return Optional.of(personaRepository.save(persona));
        } else {
            return Optional.empty();
        }
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}