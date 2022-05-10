package com.ceiba.producto.servicio;

import java.time.LocalDate;
import java.time.Month;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearProductoTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se intenta crear un producto el fin de semana")
    void deberiaLanzarUnaExepcionCuandoElProductoSeCreaUnFinDeSemana() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conFechaCreacion(LocalDate.of(2022, Month.MAY, 8)).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionValorInvalido.class,
                "No esta permitido crear productos el fin de semana");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Producto")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelProducto() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,
                "El producto ya se encuentra registrado");
    }

    @Test
    @DisplayName("Deberia Crear el producto de manera correcta")
    void deberiaCrearElProductoDeManeraCorrecta() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conFechaCreacion(LocalDate.of(2022, Month.MAY, 5)).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act
        servicioCrearProducto.ejecutar(producto);
        // - assert
        Mockito.verify(repositorioProducto, Mockito.times(1)).crear(producto);
    }
}
