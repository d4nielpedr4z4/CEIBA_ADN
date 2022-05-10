package com.ceiba.producto.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.Month;

import com.ceiba.producto.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String referencia;
    private Float precioCompra;
    private Float ivaCompra;
    private Integer porcentajeGanancia;
    private Float precioVenta;
    private Float ivaVenta;
    private Integer cantidadDisponible;
    private Integer tipo;
    private LocalDate fecha;

    public ProductoTestDataBuilder() {
        id = 10L;
        nombre = "Audifonos Trust Gaming";
        referencia = "ZIVA";
        precioCompra = 26550F;
        ivaCompra = 5044.5F;
        porcentajeGanancia = 10;
        precioVenta = 29500F;
        ivaVenta = 34753.95F;
        cantidadDisponible = 10;
        tipo = 1;
        fecha = LocalDate.of(2022, Month.MAY, 9);

    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public ProductoTestDataBuilder conPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
        return this;
    }

    public ProductoTestDataBuilder conIvaCompra(Float ivaCompra) {
        this.ivaCompra = ivaCompra;
        return this;
    }

    public ProductoTestDataBuilder conPorcentajeGanancia(Integer porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
        return this;
    }

    public ProductoTestDataBuilder conPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
        return this;
    }

    public ProductoTestDataBuilder conIvaVenta(Float ivaVenta) {
        this.ivaVenta = ivaVenta;
        return this;
    }

    public ProductoTestDataBuilder conCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public ProductoTestDataBuilder conTipo(Integer tipo) {
        this.tipo = tipo;
        return this;
    }

    public ProductoTestDataBuilder conFechaCreacion(LocalDate fechaCreacion) {
        this.fecha = fechaCreacion;
        return this;
    }

    public Producto build() {
        return new Producto(id, nombre, referencia, precioCompra, ivaCompra, porcentajeGanancia, precioVenta, ivaVenta, cantidadDisponible, tipo, fecha);
    }
}
