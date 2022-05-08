package com.ceiba.producto.consulta;

import java.util.List;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;

import org.springframework.stereotype.Component;



@Component
public class ManejadorListarProductos {

    private final DaoProducto daoProducto;

    public ManejadorListarProductos(DaoProducto daoProducto){
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar(){ return this.daoProducto.listar(); }
}
