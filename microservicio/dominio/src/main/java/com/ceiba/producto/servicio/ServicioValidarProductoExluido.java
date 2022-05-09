package com.ceiba.producto.servicio;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioValidarProductoExluido {

    private static final String EXCLUIDO = "EXCLUIDO";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_PRODUCTO = "Se debe ingresar el tipo de producto";
    

    public boolean validarProductoExcluido(String tipoProducto) {
        validarObligatorio(tipoProducto, SE_DEBE_INGRESAR_EL_TIPO_DE_PRODUCTO);
        return tipoProducto.equals(EXCLUIDO);
    }
}
