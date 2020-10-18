-- Trigger para guardar el historial de cambios de la tabla proveedor

CREATE OR REPLACE TRIGGER guardar_historial_proveedor
	AFTER INSERT OR UPDATE OR DELETE
	ON proveedor
	FOR EACH ROW
	DECLARE
		operacion VARCHAR(100);
		usuario varchar(100);
		nombre_tabla VARCHAR(100);
		datos_viejos VARCHAR(100);
		id_tabla NUMBER;
		datos_nuevos VARCHAR(100);
		fecha DATE;
	BEGIN
	    
	    IF INSERTING THEN
	        operacion := 'Insertar';
	    ELSIF UPDATING THEN
	        operacion := 'Actualizar';
	    ELSIF DELETING THEN
	        operacion := 'Eliminar';
	    END IF;
	    
	    SELECT SYSDATE INTO fecha
	    FROM dual;
	    
	    SELECT USER INTO usuario
	    FROM dual;
	    
	    nombre_tabla := 'proveedor';
	    id_tabla := :old.id;
	    datos_viejos := 'ID: '        || :old.id        || chr(10) ||
						'NOMBRE: '    || :old.nombre    || chr(10) ||
						'DIRECCION: ' || :old.direccion || chr(10) ||
						'TELEFONO: '  || :old.telefono  || chr(10);
						 
	    datos_nuevos := 'ID: '        || :new.id        || chr(10) ||
						'NOMBRE: '    || :new.nombre    || chr(10) ||
						'DIRECCION: ' || :new.direccion || chr(10) ||
						'TELEFONO: '  || :new.telefono  || chr(10);
	    
	    
	    INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
	    VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);
	    
	END;
  
-- Trigger para guardar el historial de cambios de la tabla tipo

CREATE OR REPLACE TRIGGER guardar_historial_tipo
	AFTER INSERT OR UPDATE OR DELETE
	ON tipo
	FOR EACH ROW
	DECLARE
		operacion VARCHAR(100);
		usuario varchar(100);
		nombre_tabla VARCHAR(100);
		datos_viejos VARCHAR(100);
		id_tabla NUMBER;
		datos_nuevos VARCHAR(100);
		fecha DATE;
	BEGIN
	    
	    IF INSERTING THEN
	        operacion := 'Insertar';
	    ELSIF UPDATING THEN
	        operacion := 'Actualizar';
	    ELSIF DELETING THEN
	        operacion := 'Eliminar';
	    END IF;
	    
	    SELECT SYSDATE INTO fecha
	    FROM dual;
	    
	    SELECT USER INTO usuario
	    FROM dual;
	    
	    nombre_tabla := 'tipo';
	    id_tabla := :old.id;
	    datos_viejos := 'ID: '     || :old.id      || chr(10) ||
						'NOMBRE: ' || :old.nombre  || chr(10);
						 
	    datos_nuevos := 'ID: '     || :new.id      || chr(10) ||
						'NOMBRE: ' || :new.nombre  || chr(10);
	    INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
	    VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);
	    
	END;

-- Trigger para guardar el historial de cambios de la tabla producto

CREATE OR REPLACE TRIGGER guardar_historial_producto
	AFTER INSERT OR UPDATE OR DELETE
	ON producto
	FOR EACH ROW
	DECLARE
		operacion VARCHAR(100);
		usuario varchar(100);
		nombre_tabla VARCHAR(100);
		datos_viejos VARCHAR(100);
		id_tabla NUMBER;
		datos_nuevos VARCHAR(100);
		fecha DATE;
	BEGIN 
	    IF INSERTING THEN
	        operacion := 'Insertar';
	    ELSIF UPDATING THEN
	        operacion := 'Actualizar';
	    ELSIF DELETING THEN
	        operacion := 'Eliminar';
	    END IF;
	    
	    SELECT SYSDATE INTO fecha
	    FROM dual;
	    
	    SELECT USER INTO usuario
	    FROM dual;
	    
	    nombre_tabla := 'producto';
	    id_tabla     := :old.id;
	    datos_viejos := 'ID: '     || :old.id      || chr(10) ||
						'NOMBRE: ' || :old.nombre  || chr(10) ||
						'MEDIDA: ' || :old.medida  || chr(10) ||
						'ID_TIPO: '|| :old.id_tipo || chr(10);
						 
	    datos_nuevos := 'ID: '     || :new.id      || chr(10) ||
						'NOMBRE: ' || :new.nombre  || chr(10) ||
						'MEDIDA: ' || :new.medida  || chr(10) ||
						'ID_TIPO: '|| :new.id_tipo || chr(10);
						
	    INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
	    VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);
	    
	END;

-- Trigger para guardar el historial de cambios de la tabla compra

CREATE OR REPLACE TRIGGER guardar_historial_compra
	AFTER INSERT OR UPDATE OR DELETE
	ON compra
	FOR EACH ROW
	DECLARE
		operacion VARCHAR(100);
		usuario varchar(100);
		nombre_tabla VARCHAR(100);
		datos_viejos VARCHAR(100);
		id_tabla NUMBER;
		datos_nuevos VARCHAR(100);
		fecha DATE;
	BEGIN 
	    IF INSERTING THEN
	        operacion := 'Insertar';
	    ELSIF UPDATING THEN
	        operacion := 'Actualizar';
	    ELSIF DELETING THEN
	        operacion := 'Eliminar';
	    END IF;
	    
	    SELECT SYSDATE INTO fecha
	    FROM dual;
	    
	    SELECT USER INTO usuario
	    FROM dual;
	    
	    nombre_tabla := 'producto';
	    id_tabla     := :old.id;
	    datos_viejos := 'ID: '     		 || :old.id            || chr(10) ||
						'FECHA: ' 		 || :old.fecha  	   || chr(10) ||
						'ID_PROVEEDOR: ' || :old.id_proveedor  || chr(10);
						
	    datos_nuevos := 'ID: '     		 || :new.id            || chr(10) ||
						'FECHA: '  		 || :new.fecha         || chr(10) ||
						'ID_PROVEEDOR: ' || :new.id_proveedor  || chr(10);
						
	    INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
	    VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);
	    
	END;
 
-- Trigger para guardar el historial de cambios de la tabla compra_producto

 CREATE OR REPLACE TRIGGER guardar_historial_compra_producto
	AFTER INSERT OR UPDATE OR DELETE
	ON compra_producto
	FOR EACH ROW
	DECLARE
		operacion VARCHAR(100);
		usuario varchar(100);
		nombre_tabla VARCHAR(100);
		datos_viejos VARCHAR(100);
		id_tabla NUMBER;
		datos_nuevos VARCHAR(100);
		fecha DATE;
	BEGIN 
	    IF INSERTING THEN
	        operacion := 'Insertar';
	    ELSIF UPDATING THEN
	        operacion := 'Actualizar';
	    ELSIF DELETING THEN
	        operacion := 'Eliminar';
	    END IF;
	    
	    SELECT SYSDATE INTO fecha
	    FROM dual;
	    
	    SELECT USER INTO usuario
	    FROM dual;
	    
	    nombre_tabla := 'producto';
	    id_tabla     := :old.id;
	    datos_viejos := 'ID: '     		|| :old.id          || chr(10) ||
						'ID_COMPRA: ' 	|| :old.id_compra  	|| chr(10) ||
						'ID_PRODUCTO: ' || :old.id_producto || chr(10) ||
						'CANTIDAD: '    || :old.cantidad    || chr(10) ||
						'PRECIO: '      || :old.precio   || chr(10);
						
	    datos_nuevos := 'ID: '     		|| :new.id          || chr(10) ||
						'ID_COMPRA: ' 	|| :new.id_compra   || chr(10) ||
						'ID_PRODUCTO: ' || :new.id_producto || chr(10) ||
						'CANTIDAD: '    || :new.cantidad    || chr(10) ||
						'PRECIO: '      || :new.precio   || chr(10);
						
	    INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
	    VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);
	    
	END;
