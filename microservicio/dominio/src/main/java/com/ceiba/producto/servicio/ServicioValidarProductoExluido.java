package com.ceiba.producto.servicio;

import java.util.Objects;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioValidarProductoExluido {

    private static final Integer EXCLUIDO = 2;
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_PRODUCTO = "Se debe ingresar el tipo de producto";
    private static final String SE_DEBE_INGRESAR_UN_TIPO_DE_PRODUCTO_VALIDO = "Debe ingresar un tipo de producto valido";
    

    public boolean validarProductoExcluido(Integer tipoProducto) {
        validarObligatorio(tipoProducto, SE_DEBE_INGRESAR_EL_TIPO_DE_PRODUCTO);
        validarCodigoTipoProducto(tipoProducto);
        return (Objects.equals(tipoProducto, EXCLUIDO));
    }

    public void validarCodigoTipoProducto(Integer tipoProducto){
        if (tipoProducto < 1 || tipoProducto > 2) {
			throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_UN_TIPO_DE_PRODUCTO_VALIDO);
		}
    }

}
