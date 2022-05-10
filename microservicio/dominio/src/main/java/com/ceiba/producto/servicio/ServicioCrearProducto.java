package com.ceiba.producto.servicio;

import java.time.DayOfWeek;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private static final String EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA = "El producto ya se encuentra registrado";
    private static final String NO_ESTA_PERMITIDO_CREAR_PRODUCTOS_EL_FIN_DE_SEMANA = "No esta permitido crear productos el fin de semana";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        validarExistenciaPrevia(producto);
        validarSiEsFinDeSemana(producto);
        this.repositorioProducto.crear(producto);
    }

    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existePorId(producto.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarSiEsFinDeSemana(Producto producto){
        if ((producto.getFechaCreacion().getDayOfWeek() == DayOfWeek.SATURDAY || producto.getFechaCreacion().getDayOfWeek() == DayOfWeek.SUNDAY)) {
			throw new ExcepcionValorInvalido(NO_ESTA_PERMITIDO_CREAR_PRODUCTOS_EL_FIN_DE_SEMANA);
		}
    }
}
