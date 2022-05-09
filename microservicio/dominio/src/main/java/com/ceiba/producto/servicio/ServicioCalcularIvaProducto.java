package com.ceiba.producto.servicio;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioCalcularIvaProducto {

    private static final Float IVA = 0.19F;
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_COMPRA_DEL_PRODUCTO = "Se debe ingresar el precio de compra del producto";
    private ServicioValidarProductoExluido servicioValidarProductoExluido;

    public ServicioCalcularIvaProducto(ServicioValidarProductoExluido servicioValidarProductoExluido) {
        this.servicioValidarProductoExluido = servicioValidarProductoExluido;
    }

    public Float calcularIVA(Float precioProducto, String tipoProducto) {
        validarObligatorio(precioProducto, SE_DEBE_INGRESAR_EL_PRECIO_DE_COMPRA_DEL_PRODUCTO);
        boolean excluido = this.servicioValidarProductoExluido.validarProductoExcluido(tipoProducto);
        return excluido ? 0 : (precioProducto * IVA);
    }
}
