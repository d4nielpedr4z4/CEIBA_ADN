package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoTest {

    @Test
    @DisplayName("Deberia crear correctamente el producto")
    void deberiaCrearCorrectamenteElProducto() {
        // arrange
        // LocalDateTime fechaCreacion = LocalDateTime.now();
        // act
        Producto producto = new ProductoTestDataBuilder().build();
        // assert
        Assertions.assertEquals(10, producto.getId());
        Assertions.assertEquals("Audifonos Trust Gaming", producto.getNombre());
        Assertions.assertEquals("ZIVA", producto.getReferencia());
        Assertions.assertEquals(26550F, producto.getPrecioCompra());
        Assertions.assertEquals(5044.5F, producto.getIvaCompra());
        Assertions.assertEquals(10, producto.getPorcentajeGanancia());
        Assertions.assertEquals(29500F, producto.getPrecioVenta());
        Assertions.assertEquals(5605F, producto.getIvaVenta());
        Assertions.assertEquals(1, producto.getTipo().getId());
    }

    @Test
    void deberiaFallarSinIdDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conId(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del producto");
    }

    @Test
    void deberiaFallarSinNombreDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conNombre(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del producto");
    }

    @Test
    void deberiaFallarSinReferenciaDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conReferencia(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar la referencia del producto");
    }

    @Test
    void deberiaFallarSinPrecioCompraDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conPrecioCompra(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio de compra del producto");
    }

    @Test
    void deberiaFallarConPrecioDeCompraNegativo() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conPrecioCompra(-5000f);
        // act-assert
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un valor positivo");
    }

    @Test
    void deberiaFallarConCantidadDisponibleNegativo() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conCantidadDisponible(-1000);
        // act-assert
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un valor positivo");
    }

    @Test
    void deberiaFallarSinCantidadDisponibleDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conCantidadDisponible(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad disponible del producto");
    }

    @Test
    void deberiaFallarSinFecha() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conFechaCreacion(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha");
    }

    @Test
    @DisplayName("Deberia validar el calculo del iva para producto no excluido")
    void deberiaValidarCalculoIvaProductoNoExcluido() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conTipo(1).build();
        // act
        Float iva = producto.calcularIVA(producto.getPrecioCompra(), producto.getTipo().getId());
        // - assert
        Assertions.assertEquals(producto.getIvaCompra(), iva);
    }

    @Test
    @DisplayName("Deberia validar el calculo del iva para producto excluido")
    void deberiaValidarCalculoIvaProductoExcluido() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conTipo(2).build();
        // act
        Float iva = producto.calcularIVA(producto.getPrecioCompra(), producto.getTipo().getId());
        // - assert
        Assertions.assertEquals(0, iva);
    }

    @Test
    @DisplayName("Deberia validar el calculo del precio de venta")
    void deberiaValidarCalculoPrecioVentaProducto() {

        // arrange
        Producto producto = new ProductoTestDataBuilder().build();

        // act
        Float precioVenta = producto.calcularPrecioVentaProducto(producto.getPrecioCompra(), producto.getPorcentajeGanancia());

        // assert
        Assertions.assertEquals(producto.getPrecioVenta(), precioVenta);
    }

}
