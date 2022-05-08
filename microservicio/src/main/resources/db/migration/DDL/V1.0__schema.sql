create table producto (
 id int(11) not null,
 nombre varchar(100) not null,
 referencia varchar(100) not null,
 precio_compra float not null,
 iva_compra float not null,
 porcentaje_ganancia int(11) not null,
 precio_venta float not null,
 iva_venta float not null,
 cantidad_disponible int(11) not null,
 tipo varchar(100) not null,
 primary key (id)
);