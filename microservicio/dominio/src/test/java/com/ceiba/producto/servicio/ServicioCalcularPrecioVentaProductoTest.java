package com.ceiba.producto.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioCalcularPrecioVentaProductoTest {

    @Test
    @DisplayName("Deberia validar el calculo del precio de venta")
    void deberiaValidarCalculoPrecioVentaProducto() {

        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto = new ServicioCalcularPrecioVentaProducto();

        // act
        Float precioVenta = servicioCalcularPrecioVentaProducto.calcularPrecioVentaProducto(producto.getPrecioCompra(),
                producto.getPorcentajeGanancia());

        // assert
        assertEquals(producto.getPrecioVenta(), precioVenta);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se intenta calcular precio con porcentaje null")
    void deberiaLanzarUnaExepcionCuandoElPorcentajeProductoEsNull() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conPorcentajeGanancia(null).build();
        ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto = new ServicioCalcularPrecioVentaProducto();

        // act - assert
        BasePrueba.assertThrows(() -> servicioCalcularPrecioVentaProducto.calcularPrecioVentaProducto(producto.getPrecioCompra(), producto.getPorcentajeGanancia()), ExcepcionValorObligatorio.class,
                "Se debe ingresar el porcentaje de ganancia del producto");
    }
}
