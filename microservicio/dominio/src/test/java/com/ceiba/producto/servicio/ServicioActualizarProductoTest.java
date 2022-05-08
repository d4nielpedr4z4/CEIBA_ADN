package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarProductoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del producto")
    void deberiaValidarLaExistenciaPreviaDelProducto() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarProducto servicioActualizarProducto = new ServicioActualizarProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarProducto.ejecutar(producto), 
        ExcepcionDuplicidad.class, 
        "El producto no se encuentra registrado");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarProducto servicioActualizarUsuario = new ServicioActualizarProducto(repositorioProducto);
        // act
        servicioActualizarUsuario.ejecutar(producto);
        // assert
        Mockito.verify(repositorioProducto, Mockito.times(1)).actualizar(producto);
    }
}
