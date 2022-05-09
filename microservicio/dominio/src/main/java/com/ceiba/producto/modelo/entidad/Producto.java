package com.ceiba.producto.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO = "Se debe ingresar el id del producto";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO = "Se debe ingresar la referencia del producto";
    private static final String SE_DEBE_INGRESAR_EL_IVA_DE_COMPRA_DEL_PRODUCTO = "Se debe ingresar el iva de compra del producto";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_VENTA_DEL_PRODUCTO = "Se debe ingresar el precio de venta del producto";
    private static final String SE_DEBE_INGRESAR_EL_IVA_DE_VENTA_DEL_PRODUCTO = "Se debe ingresar el iva de venta del producto";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_UNIDADES_DEL_PRODUCTO = "Se debe ingresar la cantidad disponible del producto";
    private static final String SE_DEBE_INGRESAR_LA_FECHA = "Se debe ingresar la fecha";


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
    private LocalDate fechaCreacion;

    public Producto(Long id, String nombre, String referencia, Float precioCompra, Float ivaCompra,
            Integer porcentajeGanancia, Float precioVenta, Float ivaVenta, Integer cantidadDisponible, String tipo, LocalDate fecha) {

        validarObligatorio(id, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(referencia, SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO);
        validarObligatorio(ivaCompra, SE_DEBE_INGRESAR_EL_IVA_DE_COMPRA_DEL_PRODUCTO);
        validarObligatorio(precioVenta, SE_DEBE_INGRESAR_EL_PRECIO_DE_VENTA_DEL_PRODUCTO);
        validarObligatorio(ivaVenta, SE_DEBE_INGRESAR_EL_IVA_DE_VENTA_DEL_PRODUCTO);
        validarObligatorio(cantidadDisponible, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_UNIDADES_DEL_PRODUCTO);
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA);

        this.id = id;
        this.nombre = nombre;
        this.referencia = referencia;
        this.precioCompra = precioCompra;
        this.ivaCompra = ivaCompra;
        this.porcentajeGanancia = porcentajeGanancia;
        this.precioVenta = precioVenta;
        this.ivaVenta = ivaVenta;
        this.cantidadDisponible = cantidadDisponible;
        this.tipo = tipo;
        this.fechaCreacion = fecha;
    }

}
