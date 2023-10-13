package com.ApiCuentaMovimiento.ApiCuentaMovimiento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Cuenta;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Movimientos;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.repository.MovimientosRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientosService {

    @Autowired
    private MovimientosRepository movimientoRepository;

    public List<Movimientos> obtenerTodosLosMovimientos() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimientos> obtenerMovimientoPorId(Long id) {
        return movimientoRepository.findById(id);
    }

    public Movimientos crearMovimiento(Movimientos movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Optional<Movimientos> actualizarMovimiento(Long id, Movimientos movimiento) {
        if (movimientoRepository.existsById(id)) {
            movimiento.setId(id);
            return Optional.of(movimientoRepository.save(movimiento));
        } else {
            return Optional.empty();
        }
    }

    public void eliminarMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }

    public void registrarMovimiento(Cuenta cuenta, Movimientos movimiento) {
        cuenta.registrarMovimiento(movimiento);
        movimientoRepository.save(movimiento);
    }
}
