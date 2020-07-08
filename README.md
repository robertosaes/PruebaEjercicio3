Servicio REST para el CRUD de una entidad empresa

Modo de ejecución:
    Ejecutar el proyecto en STS, el archivo de configuracion ses application.yml ahí estan los datos de conexion de la base de datos y el puerto

Creacion de tabla:
    CREATE TABLE EMPRESA (
    ID INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(50) NOT NULL,
    NIT VARCHAR(10),
    FECHA_FUNDACION DATE,
    DIRECCION VARCHAR(100)
);

Servicios REST:

POST: http://localhost:8088/empresa
Json:

{
    "nombre": "BYTE3",
    "nit": "7890123-7",
    "fechaFundacion": "2015-12-01",
    "direccion": "Mixco"
}

GET: http://localhost:8088/empresa (Todas las empresas)

GET: http://localhost:8088/empresa/{id}

PUT: http://localhost:8088/empresa/{id}

DELETE: http://localhost:8088/empresa/{id}
