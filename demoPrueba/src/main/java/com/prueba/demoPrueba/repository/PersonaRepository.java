package com.prueba.demoPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.demoPrueba.models.Persona;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Buscar personas por nombre
    List<Persona> findByNombre(String nombre);

    // Buscar personas por género
    List<Persona> findByGenero(String genero);

    // Buscar personas por edad
    List<Persona> findByEdad(int edad);

    // Buscar personas por dirección
    List<Persona> findByDireccion(String direccion);

    // Buscar persona por identificación
    Optional<Persona> findByIdentificacion(String identificacion);
}