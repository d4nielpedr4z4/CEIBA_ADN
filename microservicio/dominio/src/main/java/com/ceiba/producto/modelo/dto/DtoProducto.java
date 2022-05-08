package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {
    private Long id;
    private String nombre;
    private String referencia;
    private Float precioCompra;
    private Float ivaCompra;
    private Integer porcentajeGanancia;
    private Float precioVenta;
    private Float ivaVenta;
    private Integer cantidadDisponible;
    private String tipo;

}
