package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    /**
     * Permite listar productos
     * @return los productos
     */
    List<DtoProducto> listar();

    /**
     * Permite obtner un producto por id
     * @return un producto
     */
    List<DtoProducto> obtenerPorId(Long id);
}
