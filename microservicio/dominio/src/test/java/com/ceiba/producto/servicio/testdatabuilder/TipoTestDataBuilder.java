package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Tipo;

public class TipoTestDataBuilder {

    private Integer id;

    public TipoTestDataBuilder() {
        this.id = 1;
    }

    public TipoTestDataBuilder conId(Integer id) {
        this.id = id;
        return this;
    }

    public Tipo build() {
        return new Tipo(id);
    }
}
