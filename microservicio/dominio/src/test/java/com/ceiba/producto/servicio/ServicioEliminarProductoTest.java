package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarProductoTest {

    @Test
    @DisplayName("Deberia eliminar el producto llamando al repositorio")
    void deberiaEliminarElProductoLlamandoAlRepositorio() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarProducto.ejecutar(10l);
        Mockito.verify(repositorioProducto, Mockito.times(1)).eliminar(10l);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando no existe el Producto")
    void deberiaLanzarUnaExepcionCuandoNoExisteElProducto() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarProducto.ejecutar(producto.getId()), ExcepcionDuplicidad.class,
                "El producto no se encuentra registrado");
    }

}
