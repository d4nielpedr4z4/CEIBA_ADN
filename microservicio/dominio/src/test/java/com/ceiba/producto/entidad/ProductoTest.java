package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {

    @Test
    @DisplayName("Deberia crear correctamente el producto")
    void deberiaCrearCorrectamenteElProducto() {
        // arrange
        // LocalDateTime fechaCreacion = LocalDateTime.now();
        // act
        Producto producto = new ProductoTestDataBuilder().build();
        // assert
        assertEquals(10, producto.getId());
        assertEquals("Audifonos Trust Gaming", producto.getNombre());
        assertEquals("ZIVA", producto.getReferencia());
        assertEquals(26550F, producto.getPrecioCompra());
        assertEquals(5044.5F, producto.getIvaCompra());
        assertEquals(10, producto.getPorcentajeGanancia());
        assertEquals(29500F, producto.getPrecioVenta());
        assertEquals(34753.95F, producto.getIvaVenta());
        assertEquals(1, producto.getTipo());
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
    void deberiaFallarSinIvaCompraDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conIvaCompra(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el iva de compra del producto");
    }

    @Test
    void deberiaFallarSinPrecioVentaDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conPrecioVenta(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio de venta del producto");
    }

    @Test
    void deberiaFallarSinIvaVentaDeProducto() {

        // Arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conIvaVenta(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
            productoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el iva de venta del producto");
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

}
