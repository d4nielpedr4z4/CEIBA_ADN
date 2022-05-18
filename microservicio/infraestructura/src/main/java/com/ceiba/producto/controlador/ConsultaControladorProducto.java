package com.ceiba.producto.controlador;

import java.util.List;

import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.producto.consulta.ManejadorObtenerPorId;
import com.ceiba.producto.modelo.dto.DtoProducto;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/productos")
@Api(tags={"Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorObtenerPorId manejadorObtenerPorId;

    public ConsultaControladorProducto(ManejadorListarProductos manejadorListarProductos, ManejadorObtenerPorId manejadorObtenerPorId) {
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorObtenerPorId = manejadorObtenerPorId;
    }

    @GetMapping
    @ApiOperation("Listar Productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProductos.ejecutar();
    }

    @GetMapping(value="/producto/{id}")
    @ApiOperation("Obtener por id")
    public List<DtoProducto> obtenerPorId(@PathVariable Long id) {
        return this.manejadorObtenerPorId.ejecutar(id);
    }

}
