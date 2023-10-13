package com.ApiCuentaMovimiento.ApiCuentaMovimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ApiCuentaMovimiento.ApiCuentaMovimiento.models.Cuenta;
import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    // Buscar cuentas por tipo de cuenta
    List<Cuenta> findByTipoCuenta(String tipoCuenta);

    // Buscar cuentas por estado
    List<Cuenta> findByEstado(String estado);

    // Buscar cuentas por cliente
    Optional<Cuenta> findById(Cuenta cuenta);
}