package com.ceiba.producto.servicio;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioCalcularPrecioVentaProducto {

    private static final String SE_DEBE_INGRESAR_EL_PORCENTAJE_DE_GANANCIA = "Se debe ingresar el porcentaje de ganancia del producto";

    public Float calcularPrecioVentaProducto(Float precioCompraProducto, Integer porcentajeGananacia) {
        validarObligatorio(porcentajeGananacia, SE_DEBE_INGRESAR_EL_PORCENTAJE_DE_GANANCIA);
        return precioCompraProducto / (1 - (porcentajeGananacia / 100F));
    }
}
