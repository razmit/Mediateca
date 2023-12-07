-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    tipo_usuario ENUM('Administrador', 'Profesor', 'Alumno') NOT NULL,
    mora DECIMAL(10, 2) DEFAULT 0,
    UNIQUE(correo)
);

-- Crear la tabla de autores
CREATE TABLE IF NOT EXISTS autores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    UNIQUE(nombre)
);

-- Crear la tabla de ejemplares
CREATE TABLE IF NOT EXISTS ejemplares (
    id VARCHAR(50) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    id_autor INT,
    tipo VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    prestados INT DEFAULT 0,
    imagenURL VARCHAR(255),
    CHECK (cantidad >= prestados AND prestados >= 0),
    FOREIGN KEY (id_autor) REFERENCES autores(id)
);

-- Crear la tabla de géneros
CREATE TABLE IF NOT EXISTS generos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE(nombre)
);

-- Crear la tabla de editoriales
CREATE TABLE IF NOT EXISTS editoriales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE(nombre)
);

-- Crear la tabla de idiomas
CREATE TABLE IF NOT EXISTS idiomas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    UNIQUE(nombre)
);

-- Crear la tabla de artistas
CREATE TABLE IF NOT EXISTS artistas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE(nombre)
);

-- Crear la tabla de libros
CREATE TABLE IF NOT EXISTS libros (
    id_ejemplar VARCHAR(50),
    isbn VARCHAR(13),
    id_editorial INT,
    edicion INT,
    fecha_publicacion DATE,
    numero_paginas INT,
	id_idioma INT,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id),
    FOREIGN KEY (id_editorial) REFERENCES editoriales(id),
	FOREIGN KEY (id_idioma) REFERENCES idiomas(id) 
);

-- Crear la tabla de revistas
CREATE TABLE IF NOT EXISTS revistas (
    id_ejemplar VARCHAR(50),
    issn VARCHAR(9),
    numero INT,
    volumen INT,
    periodicidad VARCHAR(50),
    editor VARCHAR(100),
    fecha_publicacion DATE,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id)
);

-- Crear la tabla de CDs
CREATE TABLE IF NOT EXISTS cds (
    id_ejemplar VARCHAR(50),
    duracion INT, -- Duración en minutos
	ano_lanzamiento INT,
    canciones INT,
	id_artista INT, -- Nuevo campo para el artista
    id_genero INT,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id),
    FOREIGN KEY (id_genero) REFERENCES generos(id),
	FOREIGN KEY (id_artista) REFERENCES artistas(id)
);

-- Crear la tabla de universidades
CREATE TABLE IF NOT EXISTS universidades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE(nombre)
);

-- Crear la tabla de tesis
CREATE TABLE IF NOT EXISTS tesis (
    id_ejemplar VARCHAR(50),
    id_universidad INT,
    anio INT,
    grado VARCHAR(50),
	programa_academico VARCHAR(100),
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id),
    FOREIGN KEY (id_universidad) REFERENCES universidades(id)
);

-- Crear la tabla de préstamos
CREATE TABLE IF NOT EXISTS prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_ejemplar VARCHAR(50),
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id),
    CHECK (fecha_prestamo <= fecha_devolucion OR fecha_devolucion IS NULL)
);

SELECT p.id, e.id as idEjemplar ,e.titulo as ejemplarTitulo, p.fecha_prestamo FROM prestamos p JOIN ejemplares e ON p.id_ejemplar = e.id WHERE p.fecha_devolucion IS NULL AND p.id_usuario = 2;

-- Crear la tabla de configuraciones
CREATE TABLE IF NOT EXISTS configuraciones (
    clave VARCHAR(50) PRIMARY KEY,
    valor VARCHAR(255) NOT NULL
);

-- Crear la tabla de devoluciones
CREATE TABLE IF NOT EXISTS devoluciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_prestamo INT,
	id_usuario INT,
    fecha_devolucion DATE NOT NULL,
    estado_devolucion ENUM('En tiempo', 'Atrasado') NOT NULL,
    comentarios VARCHAR(255),
    FOREIGN KEY (id_prestamo) REFERENCES prestamos(id),
	FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

SELECT * FROM devoluciones;

ALTER TABLE devoluciones
ADD COLUMN id_usuario INT;

ALTER TABLE devoluciones
ADD CONSTRAINT fk_devoluciones_usuarios
FOREIGN KEY (id_usuario) REFERENCES usuarios(id);

INSERT INTO devoluciones(id_prestamo, id_usuario, fecha_devolucion, estado_devolucion,comentarios) VALUES(4,2,"2023-07-23", "Atrasado", "Todo bien");
SELECT * FROM pagos;

-- Crear la tabla de pagos
CREATE TABLE IF NOT EXISTS pagos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago DATE NOT NULL,
    id_prestamo INT,
 
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_prestamo) REFERENCES prestamos(id)
);
-- Eliminar la columna id_ejemplar de la tabla pagos
ALTER TABLE pagos
DROP COLUMN id_ejemplar;

ALTER TABLE pagos
DROP FOREIGN KEY pagos_ibfk_3;

-- Permitir que la columna "monto" pueda quedar nula
ALTER TABLE pagos
MODIFY COLUMN monto DECIMAL(10, 2) NULL;

-- Permitir que la columna "fecha_pago" pueda quedar nula
ALTER TABLE pagos
MODIFY COLUMN fecha_pago DATE NULL;



CREATE TABLE IF NOT EXISTS pagos_mora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_devolucion INT,
    monto_mora DECIMAL(10, 2) NOT NULL,
    fecha_pago_mora DATE NOT NULL,
    FOREIGN KEY (id_devolucion) REFERENCES devoluciones(id)
);

-- Añadir columna "estado" a la tabla de ejemplares
ALTER TABLE ejemplares ADD COLUMN estado VARCHAR(8) DEFAULT 'activo';

-- Trigger para aumentar en uno los prestamos de los ejemplares
DELIMITER $$

CREATE TRIGGER incrementar_prestados
AFTER INSERT ON prestamos
FOR EACH ROW
BEGIN
    UPDATE ejemplares
    SET prestados = prestados + 1
    WHERE id = NEW.id_ejemplar;
END$$

DELIMITER ;

-- Trigger para decrementar en uno los prestamos de los ejemplares
DELIMITER $$

CREATE TRIGGER actualizar_prestados
AFTER INSERT ON devoluciones
FOR EACH ROW
BEGIN
    UPDATE prestamos
    SET fecha_devolucion = NEW.fecha_devolucion
    WHERE id = NEW.id_prestamo;

    UPDATE ejemplares
    SET prestados = prestados - 1
    WHERE id = (SELECT id_ejemplar FROM prestamos WHERE id = NEW.id_prestamo);
END$$

DELIMITER ;

-- Trigger para actualizar el id_ejemplar en la tabla de pagos
DELIMITER $$

CREATE TRIGGER actualizar_id_ejemplar_pago
AFTER INSERT ON pagos
FOR EACH ROW
BEGIN
    DECLARE ultima_devolucion_id_ejemplar VARCHAR(50);

    -- Encontrar el id_ejemplar del último registro de devolución para el mismo usuario
    SELECT d.id_ejemplar INTO ultima_devolucion_id_ejemplar
    FROM devoluciones d
    WHERE d.id_usuario = NEW.id_usuario
    ORDER BY d.fecha_devolucion DESC, d.id DESC
    LIMIT 1;

    -- Actualizar el id_ejemplar en la tabla de pagos con el último id_ejemplar de la tabla de devoluciones
    IF ultima_devolucion_id_ejemplar IS NOT NULL THEN
        UPDATE pagos
        SET id_ejemplar = ultima_devolucion_id_ejemplar
        WHERE id = NEW.id;
    END IF;
END$$

DELIMITER ;


SELECT * FROM prestamos;

INSERT INTO prestamos(id_usuario, id_ejemplar, fecha_prestamo) VALUES(2,"LIB001", '2023/07/23');

SELECT e.id, e.titulo, a.nombre AS autor, e.tipo, e.ubicacion FROM ejemplares e JOIN autores a ON e.id_autor = a.id WHERE e.cantidad > e.prestados;
