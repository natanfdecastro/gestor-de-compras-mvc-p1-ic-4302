

CREATE TABLE no_normalizada (
    proveedor VARCHAR (200),
    tipo VARCHAR (200),
    producto VARCHAR (200),
    compra VARCHAR (200),
    compra_producto VARCHAR(200),
    historial VARCHAR(200)
);


INSERT INTO no_normalizada (proveedor,tipo) 
VALUES ('El Chino - macacona nances - +50687741233, Mas x Menos - Frente al hospi - +50687741111','videojuegos,electrodomesticos')


CREATE OR REPLACE PROCEDURE importar_datos AS

	type arreglo is array(10) of VARCHAR(300);
	datos_proveedor arreglo;
	datos_tipo arreglo;
	datos_producto arreglo;
	datos_compra arreglo;
	datos_compra_producto arreglo;
	indice number;
	
	CURSOR c1 is 
		(Select * from no_normalizada);
	
    CURSOR split1(datos IN VARCHAR) is
		
    (SELECT trim(regexp_substr(datos, '[^,]+', 1, LEVEL)) dato
                    FROM dual
                         CONNECT BY LEVEL <= regexp_count(datos, ',')+1);
    
    CURSOR split2(datos IN VARCHAR) is
		
    (SELECT trim(regexp_substr(datos, '[^-]+', 1, LEVEL)) dato
                    FROM dual
                         CONNECT BY LEVEL <= regexp_count(datos, '-')+1);
		
    BEGIN
		
		for i in c1 loop
		    -- normaliza proveedor
			if i.proveedor is not NULL then 
			    DBMS_OUTPUT.PUT_LINE(trim(i.proveedor));
			    for tabla IN split1(i.proveedor)
                LOOP
                    DBMS_OUTPUT.PUT_LINE(tabla.dato);
                    indice := 1;
                    datos_proveedor := arreglo();
                    datos_proveedor.extend(4);
                    for columna in split2(tabla.dato)
                    LOOP
                         DBMS_OUTPUT.PUT_LINE(columna.dato);
                         datos_proveedor(indice) := trim(columna.dato);
                         indice := indice+1;
                    END LOOP;
                END LOOP;
                INSERT INTO proveedor(nombre,direccion,telefono)
                values(datos_proveedor(1),datos_proveedor(2),datos_proveedor(3));
		    end if;
		    -- normaliza el tipo
		    if i.tipo is not NULL then 
			    DBMS_OUTPUT.PUT_LINE(trim(i.tipo));
			    for tabla IN split1(i.tipo)
                LOOP
                    DBMS_OUTPUT.PUT_LINE(tabla.dato);
                    INSERT INTO tipo(nombre)
                    values(tabla.dato);
                END LOOP;
                
		    end if;
		    -- normaliza productos
		    if i.producto is not NULL then 
			    DBMS_OUTPUT.PUT_LINE(trim(i.producto));
			    for tabla IN split1(i.producto)
                LOOP
                    DBMS_OUTPUT.PUT_LINE(tabla.dato);
                    indice := 1;
                    datos_producto := arreglo();
                    datos_producto.extend(4);
                    for columna in split2(tabla.dato)
                    LOOP
                         DBMS_OUTPUT.PUT_LINE(columna.dato);
                         datos_producto(indice) := trim(columna.dato);
                         indice := indice+1;
                    END LOOP;
                END LOOP;
                INSERT INTO producto(nombre,medida,id_tipo)
                values(datos_producto(1),datos_producto(2),datos_producto(3));
		    end if;
		    
		    -- normaliza compra
		    if i.compra is not NULL then 
			    DBMS_OUTPUT.PUT_LINE(trim(i.compra));
			    for tabla IN split1(i.compra)
                LOOP
                    DBMS_OUTPUT.PUT_LINE(tabla.dato);
                    indice := 1;
                    datos_compra := arreglo();
                    datos_compra.extend(4);
                    for columna in split2(tabla.dato)
                    LOOP
                         DBMS_OUTPUT.PUT_LINE(columna.dato);
                         datos_compra(indice) := trim(columna.dato);
                         indice := indice+1;
                    END LOOP;
                END LOOP;
                INSERT INTO compra(fecha,id_proveedor)
                values(datos_compra(1),datos_compra(2));
		    end if;
		    
		    -- normaliza compra_producto
		    if i.compra_producto is not NULL then 
			    DBMS_OUTPUT.PUT_LINE(trim(i.compra_producto));
			    for tabla IN split1(i.compra_producto)
                LOOP
                    DBMS_OUTPUT.PUT_LINE(tabla.dato);
                    indice := 1;
                    datos_compra_producto := arreglo();
                    datos_compra_producto.extend(7);
                    for columna in split2(tabla.dato)
                    LOOP
                         DBMS_OUTPUT.PUT_LINE(columna.dato);
                         datos_compra_producto(indice) := trim(columna.dato);
                         indice := indice+1;
                    END LOOP;
                END LOOP;
                INSERT INTO compra_producto(id_compra,id_producto,cantidad,precio)
                values(datos_compra_producto(1),datos_compra_producto(2),datos_compra_producto(3),datos_compra_producto(4));
		    end if;
		    
		end loop;
    END;

exec importar_datos
select * from no_normalizada;
