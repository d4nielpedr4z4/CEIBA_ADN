package com.ceiba.configuracion;

import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioCalcularIvaProducto;
import com.ceiba.producto.servicio.ServicioCalcularPrecioVentaProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import com.ceiba.producto.servicio.ServicioValidarProductoExluido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioCalcularIvaProducto servicioCalcularIvaProducto(ServicioValidarProductoExluido servicioValidarProductoExluido) {
        return new ServicioCalcularIvaProducto(servicioValidarProductoExluido);
    }

    @Bean
    public ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto() {
        return new ServicioCalcularPrecioVentaProducto();
    }

    @Bean
    public ServicioValidarProductoExluido servicioValidarProductoExluido() {
        return new ServicioValidarProductoExluido();
    }
	

}
