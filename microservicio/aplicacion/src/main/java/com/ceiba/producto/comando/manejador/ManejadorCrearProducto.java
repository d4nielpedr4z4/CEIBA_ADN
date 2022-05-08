package com.ceiba.producto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.fabrica.FabricaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioCalcularIvaProducto;
import com.ceiba.producto.servicio.ServicioCalcularPrecioVentaProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;

import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Long>> {

    private final FabricaProducto fabricaProducto;
    private final ServicioCrearProducto servicioCrearProducto;
    private final ServicioCalcularIvaProducto servicioCalcularIvaProducto;
    private final ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto, ServicioCalcularIvaProducto servicioCalcularIvaProducto, ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioCrearProducto = servicioCrearProducto;
        this.servicioCalcularIvaProducto = servicioCalcularIvaProducto;
        this.servicioCalcularPrecioVentaProducto = servicioCalcularPrecioVentaProducto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoProducto comandoProducto) {
        Float ivaCompra = this.servicioCalcularIvaProducto.calcularIVA(comandoProducto.getPrecioCompra(), comandoProducto.getTipo());
        Float precioVenta = this.servicioCalcularPrecioVentaProducto.calcularPrecioVentaProducto(comandoProducto.getPrecioCompra(), comandoProducto.getPorcentajeGanancia());
        Float ivaVenta = this.servicioCalcularIvaProducto.calcularIVA(precioVenta, comandoProducto.getTipo());
        Producto producto = this.fabricaProducto.crear(comandoProducto, ivaCompra, precioVenta, ivaVenta);
        this.servicioCrearProducto.ejecutar(producto);
        return new ComandoRespuesta<>(producto.getId());
       
    }
}
