package com.ceiba.producto.servicio.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.producto.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String referencia;
    private Float precioCompra;
    private Integer porcentajeGanancia;
    private Integer cantidadDisponible;
    private String tipo;
    private LocalDate fecha;

    public ComandoProductoTestDataBuilder() {
        id = 10L;
        nombre = "Audifonos Trust Gaming";
        referencia = "ZIVA";
        precioCompra = 26550F;
        porcentajeGanancia = 10;
        cantidadDisponible = 10;
        tipo = "GRAVADO";
        fecha = LocalDate.now();

    }

    public ComandoProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProductoTestDataBuilder conReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public ComandoProductoTestDataBuilder conPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
        return this;
    }

    public ComandoProductoTestDataBuilder conPorcentajeGanancia(Integer porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
        return this;
    }

    public ComandoProductoTestDataBuilder conCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public ComandoProductoTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ComandoProductoTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id, nombre, referencia, precioCompra, porcentajeGanancia,
                cantidadDisponible, tipo, fecha);
    }
}
