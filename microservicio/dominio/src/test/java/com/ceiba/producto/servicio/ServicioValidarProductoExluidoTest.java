package com.ceiba.producto.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioValidarProductoExluidoTest {

    @Test
    @DisplayName("Deberia validar si el producto esta excluido de iva")
    void deberiaValidarSiElProductoEsExcluido() {
        //arrange
        Producto producto = new ProductoTestDataBuilder().conTipo("EXCLUIDO").build();
        ServicioValidarProductoExluido servicioValidarProductoExluido = new ServicioValidarProductoExluido();
        //act
        boolean excluido = servicioValidarProductoExluido.validarProductoExcluido(producto.getTipo());
        //assert
        assertEquals(true, excluido);
    }

    @Test
    @DisplayName("Deberia validar si el producto no esta excluido de iva")
    void deberiaValidarSiElProductoNoEsExcluido() {
        //arrange
        Producto producto = new ProductoTestDataBuilder().conTipo("GRAVADO").build();
        ServicioValidarProductoExluido servicioValidarProductoExluido = new ServicioValidarProductoExluido();
        //act
        boolean excluido = servicioValidarProductoExluido.validarProductoExcluido(producto.getTipo());
        //assert
        assertEquals(false, excluido);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se intenta validar excluido con tipo null")
    void deberiaLanzarUnaExepcionCuandoElTipoProductoEsNull() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conTipo(null).build();
        ServicioValidarProductoExluido servicioValidarProductoExluido = new ServicioValidarProductoExluido();
        // act - assert
        BasePrueba.assertThrows(() -> servicioValidarProductoExluido.validarProductoExcluido(producto.getTipo()), ExcepcionValorObligatorio.class,
                "Se debe ingresar el tipo de producto");
    }
}
