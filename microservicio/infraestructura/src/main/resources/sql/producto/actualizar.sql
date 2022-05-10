update producto
set nombre = :nombre,
	referencia = :referencia,
	precio_compra = :precioCompra,
	iva_compra = :ivaCompra,
	porcentaje_ganancia = :porcentajeGanancia,
	precio_venta = :precioVenta,
	iva_venta = :ivaVenta,
	cantidad_disponible = :cantidadDisponible,
	id_tipo = :tipo
where id = :id