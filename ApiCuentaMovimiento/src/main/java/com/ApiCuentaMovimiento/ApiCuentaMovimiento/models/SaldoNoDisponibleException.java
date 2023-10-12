package com.ApiCuentaMovimiento.ApiCuentaMovimiento.models;

public class SaldoNoDisponibleException extends RuntimeException {
    public SaldoNoDisponibleException(String message) {
        super(message);
    }
}
