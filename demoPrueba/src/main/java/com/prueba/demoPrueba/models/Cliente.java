package com.prueba.demoPrueba.models;

//import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    // @NotBlank
    private String contrasena;

    private String estado;

    @OneToOne
    private Persona persona;

    // Constructor vacío (necesario para JPA)
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String contrasena, String estado, Persona persona) {
        this.contrasena = contrasena;
        this.estado = estado;
        this.persona = persona;
    }

    // Getters y setters

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
