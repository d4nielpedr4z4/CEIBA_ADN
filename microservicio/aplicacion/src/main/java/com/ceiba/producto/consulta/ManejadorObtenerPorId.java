package com.ceiba.producto.consulta;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerPorId {

    private final DaoProducto daoProducto;

    public ManejadorObtenerPorId(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar(Long idProducto){ return this.daoProducto.obtenerPorId(idProducto); }
}
