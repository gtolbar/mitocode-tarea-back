-- liquibase formatted sql

-- changeset gustavo:1
-- comment: Se crea tabla persona postgres
CREATE TABLE persona(
	id SERIAL PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL
);

-- changeset gustavo:2
-- comment: Se crea tabla producto
CREATE TABLE producto(
	id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL
);

-- changeset gustavo:3
-- comment: Se crea tabla venta
CREATE TABLE venta(
	id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    id_persona  INT NOT NULL,
    importe DECIMAL NOT NULL,
    FOREIGN KEY(id_persona) REFERENCES persona(id)
);

-- changeset gustavo:4
-- comment: Se crea tabla detalle venta
CREATE TABLE detalle_venta(
	id SERIAL PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    FOREIGN KEY(id_venta) REFERENCES venta(id),
    FOREIGN KEY(id_producto) REFERENCES producto(id)
);

