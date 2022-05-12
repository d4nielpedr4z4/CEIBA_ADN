package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Tipo;
import com.ceiba.producto.servicio.testdatabuilder.TipoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TipoTest {


    @Test
    void deberiaFallarSinIdDeTipo() {

        // Arrange
        TipoTestDataBuilder tipoTestDataBuilder = new TipoTestDataBuilder().conId(null);
        // act-assert
        BasePrueba.assertThrows(() -> {
                    tipoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id de tipo de producto");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando el id_tipo de producto es negativo o mayor a dos")
    void deberiaLanzarUnaExepcionCuandoElTipoProductoEsInvalido() {
        // arrange
        TipoTestDataBuilder tipoTestDataBuilder = new TipoTestDataBuilder().conId(-50);
        // act - assert
        BasePrueba.assertThrows(() -> {
                    tipoTestDataBuilder.build();
                }
                , ExcepcionValorInvalido.class,
                "Debe ingresar un tipo de producto valido");
    }
}
