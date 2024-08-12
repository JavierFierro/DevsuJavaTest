CREATE DATABASE db_devsu_test
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
CREATE TABLE IF NOT EXISTS public.cliente (
  cliente_id SERIAL PRIMARY KEY,
  edad VARCHAR(50),
  genero VARCHAR(20),
  nombre VARCHAR(255),
  contrasena VARCHAR(255),
  estado BOOLEAN,
  direccion VARCHAR(255) ,
  identificacion VARCHAR(50),
  telefono VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS public.cuenta
(
    id SERIAL character varying(255) NOT NULL PRIMARY KEY,
    numero_cuenta character varying(255) NOT NULL,
    estado boolean,
    saldo_inicial numeric(10,2),
    tipo character varying(255),
    cliente_id integer
)

CREATE TABLE IF NOT EXISTS public.movimiento
(
    id SERIAL character varying(255) NOT NULL PRIMARY KEY,
    fecha character varying(255),
    numero_cuenta character varying(255),
    saldo numeric(10,2),
    tipo_movimiento character varying(255),
    valor numeric(10,2),
)

INSERT INTO public.cliente(
	edad, genero, nombre, contrasena, estado, direccion, identificacion, telefono)
	VALUES 
('22'    ,'Masculino'    ,'Jose Lema'    		,'1234'		,true    ,'Otavalo sn y principal'    ,'092123456'   ,'098254785'),
('22'    ,'Femenino'     ,'Marianela Montalvo'  ,'5678'		,true    ,'Amazonas y NNUU'    		  ,'092123369'   ,'097548965'),
('22'    ,'Masculino'    ,'Juan Osorio'    		,'1245'		,true    ,'13 junio y Equinoccial'    ,'09217894'    ,'098874587');

INSERT INTO public.cuenta(
	numero_cuenta, estado, saldo_inicial, tipo, cliente_id)
	VALUES 
('585545'	,true	,1000.00	,'Corriente'		,6),
('496825'	,true	,540.00		,'Ahorros'			,7),
('495878'	,true	,0.00		,'Ahorros'			,8),
('225487'	,true	,100.00		,'Corriente'		,7),
('478758'	,true	,2000.00	,'Ahorros'  		,6);

INSERT INTO public.movimiento(
	movimiento_id, fecha, numero_cuenta, saldo, tipo_movimiento, valor)
	VALUES
('245e40e0-bc0a-48a5-b8aa-160cd2bd4078', '02/06/2023 20:34:20', '478758',	1425.00	,'retiro',	    -575.00),
('586f8bd9-ae78-448b-be7c-8526146c059f', '02/09/2023 20:34:20', '496825',	0.00	,'retiro',	    -540.00),
('bdd5fa10-5f82-47fb-bced-ac4c3d6da934', '02/08/2023 20:34:20', '495878',	150.00	,'deposito',	150.00),
('c4b0e576-eae3-41f3-8b91-46640cd53637', '02/07/2023 20:34:20', '225487',	700.00	,'deposito',	600.00);


