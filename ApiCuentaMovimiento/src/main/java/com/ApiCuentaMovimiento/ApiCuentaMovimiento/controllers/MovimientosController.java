package com.ApiCuentaMovimiento.ApiCuentaMovimiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Cuenta;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Movimientos;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.SaldoNoDisponibleException;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.repository.MovimientosRepository;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.services.CuentaService;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.services.MovimientosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private MovimientosRepository movimientoRepository;
    @Autowired
    private MovimientosService movimientosService;

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Movimientos> obtenerTodosLosMovimientos() {
        return movimientoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimientos> obtenerMovimientoPorId(@PathVariable Long id) {
        Movimientos movimiento = movimientoRepository.findById(id).orElse(null);
        if (movimiento != null) {
            return new ResponseEntity<>(movimiento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Movimientos> crearMovimiento(@RequestBody Movimientos movimientos) {
        Movimientos nuevoMovimiento = movimientoRepository.save(movimientos);
        return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimientos> actualizarMovimiento(@PathVariable Long id,
            @RequestBody Movimientos movimientos) {
        if (!movimientoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movimientos.setId(id);
        Movimientos movimientoActualizado = movimientoRepository.save(movimientos);
        return new ResponseEntity<>(movimientoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        if (!movimientoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movimientoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(SaldoNoDisponibleException.class)
    public ResponseEntity<String> handleSaldoNoDisponibleException(SaldoNoDisponibleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarMovimiento(@RequestBody Movimientos movimiento) {
        // Obtener la cuenta asociada al movimiento por su ID
        Long cuentaId = movimiento.getCuenta().getId();
        Optional<Cuenta> cuentaOptional = cuentaService.obtenerCuentaPorId(cuentaId);
        Cuenta cuenta = cuentaOptional.orElse(null);

        if (cuenta == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La cuenta no existe");
        }

        if (movimiento.getTipoMovimiento().equals("EGRESO") && movimiento.getValor() > cuenta.getSaldo()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente");
        }

        // Luego, registra el movimiento en la cuenta
        movimientosService.registrarMovimiento(cuenta, movimiento);
        // Mensaje
        return ResponseEntity.ok("Movimiento registrado con éxito");

    }
}