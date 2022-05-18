package com.ceiba.producto.comando.fabrica;

import com.ceiba.producto.modelo.entidad.Tipo;
import org.springframework.stereotype.Component;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getReferencia(),
                comandoProducto.getPrecioCompra(),
                comandoProducto.getPorcentajeGanancia(),
                comandoProducto.getCantidad(),
                new Tipo(comandoProducto.getTipo()),
                comandoProducto.getFecha());
    }

}
