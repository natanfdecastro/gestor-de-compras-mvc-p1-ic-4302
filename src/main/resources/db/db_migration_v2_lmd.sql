INSERT INTO proveedor (nombre, direccion, telefono)
VALUES ('Mega Super', 'Adobes, Calle 7', '+506 8442-7935');

-- Tipos de Producto
-- https://en.wikipedia.org/wiki/Fast-moving_consumer_goods --

-- tipo numero 1
INSERT INTO tipo (nombre)
VALUES ('carnes');

-- tipo numero 2
INSERT INTO tipo (nombre)
VALUES ('frutas y vegetales');

-- tipo numero 3
INSERT INTO tipo (nombre)
VALUES ('aceites y grasas');

-- tipo numero 4
INSERT INTO tipo (nombre)
VALUES ('lácteos');

-- tipo numero 5
INSERT INTO tipo (nombre)
VALUES ('granos');

-- tipo numero 6
INSERT INTO tipo (nombre)
VALUES ('alimento animal');

-- tipo numero 7
INSERT INTO tipo (nombre)
VALUES ('productos de panadería');

-- tipo numero 8
INSERT INTO tipo (nombre)
VALUES ('pastas');

-- tipo numero 9
INSERT INTO tipo (nombre)
VALUES ('farmacia');

-- tipo numero 10
INSERT INTO tipo (nombre)
VALUES ('licores');

-- tipo numero 11
INSERT INTO tipo (nombre)
VALUES ('bebidas');

-- tipo numero 12
INSERT INTO tipo (nombre)
VALUES ('oficina');

-- tipo numero 13
INSERT INTO tipo (nombre)
VALUES ('limpieza');

-- tipo numero 14
INSERT INTO tipo (nombre)
VALUES ('cuidado personal');

-- tipo numero 15
INSERT INTO tipo (nombre)
VALUES ('materiales de hogar');

----

--Compra

INSERT INTO compra (fecha,id_proveedor)
VALUES('07/09/2020',1);

-- Producto

INSERT INTO producto (nombre, medida, id_tipo)
VALUES ('Cloro', 'litros', 13);

INSERT INTO producto (nombre, medida, id_tipo)
VALUES ('Arroz', 'kilogramos', 5);

-- Precio

INSERT INTO precio(importe,fecha_inicial,fecha_final,id_producto)
VALUES(1250,'01-JAN-17','01-FEB-17',1);

INSERT INTO precio(importe,fecha_inicial,fecha_final,id_producto)
VALUES(1750,'01-JAN-17','01-FEB-17',2);

-- Compra producto

INSERT INTO compra_producto(id_compra,id_producto,cantidad)
VALUES(1,1,1);

INSERT INTO compra_producto(id_compra,id_producto,cantidad)
VALUES(1,2,2);