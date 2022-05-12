package com.ceiba.producto.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class Producto {


    private static final String SE_DEBE_INGRESAR_UN_VALOR_POSITIVO = "Se debe ingresar un valor positivo";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO = "Se debe ingresar el id del producto";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO = "Se debe ingresar la referencia del producto";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_COMPRA_DEL_PRODUCTO = "Se debe ingresar el precio de compra del producto";
    private static final String SE_DEBE_INGRESAR_EL_PORCENTAJE_DE_GANANCIA = "Se debe ingresar el porcentaje de ganancia del producto";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_UNIDADES_DEL_PRODUCTO = "Se debe ingresar la cantidad disponible del producto";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_PRODUCTO = "Se debe ingresar el tipo de producto";
    private static final String SE_DEBE_INGRESAR_LA_FECHA = "Se debe ingresar la fecha";
    private static final Float IVA = 0.19F;
    private static final Integer EXCLUIDO = 2;


    private Long id;
    private String nombre;
    private String referencia;
    private Float precioCompra;
    private Float ivaCompra;
    private Integer porcentajeGanancia;
    private Float precioVenta;
    private Float ivaVenta;
    private Integer cantidadDisponible;
    private Tipo tipo;
    private LocalDate fechaCreacion;

    public Producto(Long id, String nombre, String referencia, Float precioCompra, Integer porcentajeGanancia, Integer cantidadDisponible, Tipo tipo, LocalDate fecha) {

        validarObligatorio(id, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(referencia, SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO);
        validarObligatorio(precioCompra, SE_DEBE_INGRESAR_EL_PRECIO_DE_COMPRA_DEL_PRODUCTO);
        validarNegativo(precioCompra);
        validarObligatorio(porcentajeGanancia, SE_DEBE_INGRESAR_EL_PORCENTAJE_DE_GANANCIA);
        validarObligatorio(cantidadDisponible, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_UNIDADES_DEL_PRODUCTO);
        validarNegativo(Float.valueOf(cantidadDisponible));
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_DE_PRODUCTO);
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA);

        this.id = id;
        this.nombre = nombre;
        this.referencia = referencia;
        this.precioCompra = precioCompra;
        this.ivaCompra = calcularIVA(precioCompra, tipo.getId());
        this.porcentajeGanancia = porcentajeGanancia;
        this.precioVenta = calcularPrecioVentaProducto(this.precioCompra, porcentajeGanancia);
        this.ivaVenta = calcularIVA(this.precioVenta, tipo.getId());
        this.cantidadDisponible = cantidadDisponible;
        this.tipo = tipo;
        this.fechaCreacion = fecha;
    }

    public Float calcularIVA(Float precioProducto, Integer tipoProducto) {
        boolean excluido = validarProductoExcluido(tipoProducto);
        return excluido ? 0 : (precioProducto * IVA);
    }

    public Float calcularPrecioVentaProducto(Float precioCompraProducto, Integer porcentajeGananacia) {
        return precioCompraProducto / (1 - (porcentajeGananacia / 100F));
    }

    public boolean validarProductoExcluido(Integer tipoProducto) {
        return (Objects.equals(tipoProducto, EXCLUIDO));
    }

    public void validarNegativo(Float precio){
        if (precio < 1) {
            throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_UN_VALOR_POSITIVO);
        }
    }

}
