package com.prueba.demoPrueba.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.demoPrueba.models.Persona;

@Service
public class ClientePersonaService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarNuevaPersona(Persona persona) {
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("tipo", "NuevaPersona");
        mensaje.put("datos", persona);

        rabbitTemplate.convertAndSend("mi-exchange", "mi-routing-key", mensaje);
    }
}