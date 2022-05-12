package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioProducto {
    /**
     * Permite crear un producto
     * @param producto
     * @return el id generado
     */
    void crear(Producto producto);

    /**
     * Permite actualizar un producto
     * @param producto
     */
    void actualizar(Producto producto);

    /**
     * Permite eliminar un producto
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un producto con una referencia
     * @param referencia
     * @return si existe o no
     */
    boolean existe(String referencia);

    /**
     * Permite validar si existe un producto con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
