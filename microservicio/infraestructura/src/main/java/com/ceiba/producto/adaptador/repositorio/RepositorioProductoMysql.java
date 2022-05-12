package com.ceiba.producto.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="producto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="producto", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="producto", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="producto", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void crear(Producto producto) {
        MapSqlParameterSource namedParameters = crearParametros(producto);
        this.customNamedParameterJdbcTemplate.crear(namedParameters, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String ref) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("referencia", ref);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Producto producto) {
        MapSqlParameterSource namedParameters = crearParametros(producto);
        this.customNamedParameterJdbcTemplate.actualizar(namedParameters, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    public MapSqlParameterSource crearParametros(Producto producto){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", producto.getId());
        namedParameters.addValue("nombre", producto.getNombre());
        namedParameters.addValue("referencia", producto.getReferencia() );
        namedParameters.addValue("precioCompra", producto.getPrecioCompra() );
        namedParameters.addValue("ivaCompra", producto.getIvaCompra() );
        namedParameters.addValue("porcentajeGanancia", producto.getPorcentajeGanancia() );
        namedParameters.addValue("precioVenta", producto.getPrecioVenta() );
        namedParameters.addValue("ivaVenta", producto.getIvaVenta() );
        namedParameters.addValue("cantidadDisponible", producto.getCantidadDisponible() );
        namedParameters.addValue("tipo", producto.getTipo().getId() );

        return  namedParameters;
    }
}
