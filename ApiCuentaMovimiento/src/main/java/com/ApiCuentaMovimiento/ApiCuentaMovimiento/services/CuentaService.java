package com.ApiCuentaMovimiento.ApiCuentaMovimiento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Cuenta;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.repository.CuentaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> actualizarCuenta(Long id, Cuenta cuenta) {
        if (cuentaRepository.existsById(id)) {
            cuenta.setId(id);
            return Optional.of(cuentaRepository.save(cuenta));
        } else {
            return Optional.empty();
        }
    }

    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    public void estado(String estado) {
        cuentaRepository.findByEstado(estado);
    }
}