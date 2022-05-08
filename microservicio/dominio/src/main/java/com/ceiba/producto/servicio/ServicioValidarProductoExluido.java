package com.ceiba.producto.servicio;

public class ServicioValidarProductoExluido {

    private final String EXCLUIDO = "EXCLUIDO";

    public boolean validarProductoExcluido(String tipoProducto) {
        return tipoProducto.equals(EXCLUIDO);
    }
}
