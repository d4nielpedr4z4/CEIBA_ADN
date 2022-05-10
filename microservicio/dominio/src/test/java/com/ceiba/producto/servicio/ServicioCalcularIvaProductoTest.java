package com.ceiba.producto.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCalcularIvaProductoTest {

    @Test
    @DisplayName("Deberia validar el calculo del iva para producto no excluido")
    void deberiaValidarCalculoIvaProductoNoExcluido() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conTipo(1).build();
        ServicioValidarProductoExluido servicioValidarProductoExluido = Mockito
                .mock(ServicioValidarProductoExluido.class);
        Mockito.when(servicioValidarProductoExluido.validarProductoExcluido(Mockito.anyInt())).thenReturn(false);
        ServicioCalcularIvaProducto servicioCalcularIvaProducto = new ServicioCalcularIvaProducto(
                servicioValidarProductoExluido);
        // act
        Float iva = servicioCalcularIvaProducto.calcularIVA(producto.getPrecioCompra(), producto.getTipo());
        // - assert
        assertEquals(producto.getIvaCompra(), iva);
    }

    @Test
    @DisplayName("Deberia validar el calculo del iva para producto excluido")
    void deberiaValidarCalculoIvaProductoExcluido() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conTipo(2).build();
        ServicioValidarProductoExluido servicioValidarProductoExluido = Mockito
                .mock(ServicioValidarProductoExluido.class);
        Mockito.when(servicioValidarProductoExluido.validarProductoExcluido(Mockito.anyInt())).thenReturn(true);
        ServicioCalcularIvaProducto servicioCalcularIvaProducto = new ServicioCalcularIvaProducto(
                servicioValidarProductoExluido);
        // act
        Float iva = servicioCalcularIvaProducto.calcularIVA(producto.getPrecioCompra(), producto.getTipo());
        // - assert
        assertEquals(0, iva);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se intenta calcular iva con precio null")
    void deberiaLanzarUnaExepcionCuandoElPrecioProductoEsNull() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conPrecioCompra(null).build();
        ServicioValidarProductoExluido servicioValidarProductoExluido = Mockito
                .mock(ServicioValidarProductoExluido.class);
        Mockito.when(servicioValidarProductoExluido.validarProductoExcluido(Mockito.anyInt())).thenReturn(false);
        ServicioCalcularIvaProducto servicioCalcularIvaProducto = new ServicioCalcularIvaProducto(
                servicioValidarProductoExluido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCalcularIvaProducto.calcularIVA(producto.getPrecioCompra(), producto.getTipo()), ExcepcionValorObligatorio.class,
                "Se debe ingresar el precio de compra del producto");
    }
}
