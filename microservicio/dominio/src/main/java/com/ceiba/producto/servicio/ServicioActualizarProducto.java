package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarProducto {

    private static final String EL_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA = "El producto no se encuentra registrado";

    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        validarExistenciaPrevia(producto);
        this.repositorioProducto.actualizar(producto);
    }

    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existePorId(producto.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
