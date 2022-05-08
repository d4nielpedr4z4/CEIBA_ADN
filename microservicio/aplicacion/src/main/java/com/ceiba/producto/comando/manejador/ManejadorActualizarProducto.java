package com.ceiba.producto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.fabrica.FabricaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioCalcularIvaProducto;
import com.ceiba.producto.servicio.ServicioCalcularPrecioVentaProducto;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProducto implements ManejadorComando<ComandoProducto> {

    private final FabricaProducto fabricaProducto;
    private final ServicioActualizarProducto servicioActualizarProducto;
    private final ServicioCalcularIvaProducto servicioCalcularIvaProducto;
    private final ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto;

    public ManejadorActualizarProducto(FabricaProducto fabricaProducto,
            ServicioActualizarProducto servicioActualizarProducto,
            ServicioCalcularIvaProducto servicioCalcularIvaProducto,
            ServicioCalcularPrecioVentaProducto servicioCalcularPrecioVentaProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioActualizarProducto = servicioActualizarProducto;
        this.servicioCalcularIvaProducto = servicioCalcularIvaProducto;
        this.servicioCalcularPrecioVentaProducto = servicioCalcularPrecioVentaProducto;
    }

    public void ejecutar(ComandoProducto comandoProducto) {
        Float ivaCompra = this.servicioCalcularIvaProducto.calcularIVA(comandoProducto.getPrecioCompra(),
                comandoProducto.getTipo());
        Float precioVenta = this.servicioCalcularPrecioVentaProducto.calcularPrecioVentaProducto(
                comandoProducto.getPrecioCompra(), comandoProducto.getPorcentajeGanancia());
        Float ivaVenta = this.servicioCalcularIvaProducto.calcularIVA(precioVenta, comandoProducto.getTipo());
        Producto producto = this.fabricaProducto.crear(comandoProducto, ivaCompra, precioVenta, ivaVenta);
        this.servicioActualizarProducto.ejecutar(producto);
    }
}
