CREATE OR  REPLACE FUNCTION clasificar_productos (

    fecha1 DATE,
    fecha2 DATE
)

return VARCHAR2

AS
	lista_total VARCHAR2(32767);
    lista_producto VARCHAR2(32767);
    lista_proveedores VARCHAR2(32767);
    lista_precio VARCHAR2(32767);
    
Cursor C1 IS
    
	select proveedor.nombre as proveedor,
	producto.nombre as producto,
	compra_producto.precio as Precio
    INTO lista_producto,lista_proveedores,lista_precio
	FROM compra
	INNER JOIN compra_producto 
	ON compra.id = compra_producto.id_compra and compra.fecha BETWEEN '01-JAN-2020' AND  '01-OCT-2020'
	INNER JOIN proveedor
	ON compra.id_proveedor = proveedor.id
	INNER JOIN producto
	ON producto.id = compra_producto.id_producto
	order by producto asc, precio asc;

BEGIN

    For i IN C1 LOOP
		lista_total := lista_total || i.producto || ' ' || i.precio || ' En ' || i.proveedor || chr(10);

	END LOOP;
    RETURN lista_total;

END clasificar_productos;

select clasificar_productos('01-JAN-2020','01-OCT-2020') from dual;
