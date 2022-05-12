package com.ceiba.producto.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Tipo {

    private static final String SE_DEBE_INGRESAR_EL_ID_DE_TIPO_DE_PRODUCTO = "Se debe ingresar el id de tipo de producto";
    private static final String SE_DEBE_INGRESAR_UN_TIPO_DE_PRODUCTO_VALIDO = "Debe ingresar un tipo de producto valido";


    private Integer id;

    public Tipo(Integer id){
        validarObligatorio(id, SE_DEBE_INGRESAR_EL_ID_DE_TIPO_DE_PRODUCTO);
        validarCodigoTipoProducto(id);
        this.id = id;
    }

    public void validarCodigoTipoProducto(Integer id){
        if (id < 1 || id > 2) {
            throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_UN_TIPO_DE_PRODUCTO_VALIDO);
        }
    }

}
