package com.ApiCuentaMovimiento.ApiCuentaMovimiento.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cuenta")
    private List<Movimientos> movimientos = new ArrayList<>();

    @Column
    private String numeroCuenta;
    @Column
    private Double saldo;
    @Column
    private String tipoCuenta;
    @Column
    private String estado;
    @Column
    private String cliente;

    // Constructor vacío (necesario para JPA)
    public Cuenta() {
    }

    // Constructor con parámetros
    public Cuenta(String numeroCuenta, String tipoCuenta, Double saldo, String estado, String cliente,
            List<Movimientos> movimiento) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void registrarMovimiento(Movimientos movimiento) {

        // Verificar si hay saldo suficiente
        if (movimiento.getTipoMovimiento().equals("EGRESO") && movimiento.getValor() > saldo) {
            throw new SaldoNoDisponibleException("Saldo no disponible");
        }
        // Actualizar el saldo de la cuenta
        if ("INGRESO".equals(movimiento.getTipoMovimiento())) {
            saldo += movimiento.getValor();
        } else if ("EGRESO".equals(movimiento.getTipoMovimiento())) {
            saldo -= movimiento.getValor();
        }
        // Agregar el movimiento a la lista de movimientos
        movimientos.add(movimiento);
        movimiento.setCuenta(this);
    }
}