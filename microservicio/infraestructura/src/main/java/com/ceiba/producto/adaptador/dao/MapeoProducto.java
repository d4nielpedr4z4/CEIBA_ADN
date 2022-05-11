package com.ceiba.producto.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.dto.DtoTipo;

import org.springframework.jdbc.core.RowMapper;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id_producto");
        String nombre = resultSet.getString("nombre");
        String referencia = resultSet.getString("referencia");
        Float precioCompra = resultSet.getFloat("precio_compra");
        Float ivaCompra = resultSet.getFloat("iva_compra");
        Integer porcentajeGanancia = resultSet.getInt("porcentaje_ganancia");
        Float precioVenta = resultSet.getFloat("precio_venta");
        Float ivaVenta = resultSet.getFloat("iva_venta");
        Integer cantidadDisponible = resultSet.getInt("cantidad_disponible");
        Long idTipo = resultSet.getLong("id_tipo");
        String nombreTipo = resultSet.getString("nombre_tipo");

        return new DtoProducto(id, nombre, referencia, precioCompra, ivaCompra, porcentajeGanancia, precioVenta,
                ivaVenta, cantidadDisponible, new DtoTipo(idTipo, nombreTipo));
    }

}
