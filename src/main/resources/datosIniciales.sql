--TIPOS DE INDETIFICADORES
insert into tipos_de_identificadores (tipo_documento) values ('DNI');
insert into tipos_de_identificadores (tipo_documento) values ('PASAPORTE');
insert into tipos_de_identificadores (tipo_documento) values ('LC');
insert into tipos_de_identificadores (tipo_documento) values ('LE');
insert into tipos_de_identificadores (tipo_documento) values ('EXTRANJERO');

--TIPOS DE EMPLEADOS
insert into tipo_empleado(cargo) values ('SECRETARIA');
insert into tipo_empleado(cargo) values ('INVESTIGADOR');
insert into tipo_empleado(cargo) values ('ENCARGADO');

--EMPLEADOS
INSERT INTO EMPLEADOS (apellido,nombre,numero_identificador,id_tipo_empleado,id_tipo_identificador) values ('Aguero','Pablo','12345678',1,1);
INSERT INTO EMPLEADOS (apellido,nombre,numero_identificador,id_tipo_empleado,id_tipo_identificador) values ('Altamirano','Martin','12345679',2,2);
INSERT INTO EMPLEADOS (apellido,nombre,numero_identificador,id_tipo_empleado,id_tipo_identificador) values ('Maison','Natalia','12345680',2,3);