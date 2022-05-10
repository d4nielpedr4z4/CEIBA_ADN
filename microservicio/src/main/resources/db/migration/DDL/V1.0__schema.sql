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
 id_tipo int(11) not null,
 primary key (id)
);

create table tipo (
 id int(11) not null,
 nombre varchar(100) not null,
 primary key (id)
);

ALTER TABLE producto
ADD CONSTRAINT tipo_producto_fk
  FOREIGN KEY (id_tipo)
  REFERENCES tipo (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

insert into tipo (id, nombre) values ( 1, 'GRAVADO');
insert into tipo (id, nombre) values ( 2, 'EXCLUIDO');