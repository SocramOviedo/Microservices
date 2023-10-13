package com.ApiCuentaMovimiento.ApiCuentaMovimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Movimientos;
import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {

    // Buscar movimientos por tipo de movimiento
    List<Movimientos> findByTipoMovimiento(String tipoMovimiento);
}