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

-- Crear la tabla de ejemplares
CREATE TABLE IF NOT EXISTS ejemplares (
    id VARCHAR(50) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    tipo VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    prestados INT DEFAULT 0,
    CHECK (cantidad >= prestados AND prestados >= 0)
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

-- Crear la tabla de libros
CREATE TABLE IF NOT EXISTS libros (
    id_ejemplar VARCHAR(50),
    isbn VARCHAR(13),
    id_editorial INT,
    edicion INT,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id),
    FOREIGN KEY (id_editorial) REFERENCES editoriales(id)
);

-- Crear la tabla de revistas
CREATE TABLE IF NOT EXISTS revistas (
    id_ejemplar VARCHAR(50),
    issn VARCHAR(9),
    numero INT,
    volumen INT,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id)
);

-- Crear la tabla de CDs
CREATE TABLE IF NOT EXISTS cds (
    id_ejemplar VARCHAR(50),
    duracion INT, -- Duración en minutos
    id_genero INT,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id),
    FOREIGN KEY (id_genero) REFERENCES generos(id)
);

-- Crear la tabla de tesis
CREATE TABLE IF NOT EXISTS tesis (
    id_ejemplar VARCHAR(50),
    universidad VARCHAR(100),
    anio INT,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id)
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

-- Crear la tabla de configuraciones
CREATE TABLE IF NOT EXISTS configuraciones (
    clave VARCHAR(50) PRIMARY KEY,
    valor VARCHAR(255) NOT NULL
);


-- Crear la tabla de devoluciones
CREATE TABLE IF NOT EXISTS devoluciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_prestamo INT,
    fecha_devolucion DATE NOT NULL,
    estado_devolucion ENUM('En tiempo', 'Atrasado') NOT NULL,
    comentarios VARCHAR(255),
    FOREIGN KEY (id_prestamo) REFERENCES prestamos(id)
);

CREATE TABLE IF NOT EXISTS pagos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago DATE NOT NULL,
    id_prestamo INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_prestamo) REFERENCES prestamos(id)
);
	
ALTER TABLE pagos
ADD COLUMN id_prestamo INT,
ADD CONSTRAINT fk_prestamos
FOREIGN KEY (id_prestamo) REFERENCES prestamos(id);


SELECT * FROM devoluciones;	
SELECT * FROM prestamos;
SELECT * FROM ejemplares;	
SELECT * FROM libros;	
SELECT * FROM usuarios;	
SELECT * FROM configuraciones;
SELECT * FROM pagos;
SELECT * FROM editoriales;
SELECT e.id, e.titulo, e.autor, e.tipo, e.ubicacion, e.cantidad, e.prestados, l.isbn, l.id_editorial, l.edicion FROM ejemplares e INNER JOIN libros l ON e.id = l.id_ejemplar WHERE estado = "activo";
INSERT INTO configuraciones(clave, valor) VALUES ("Mora", "0.50");
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


DROP TRIGGER IF EXISTS actualizar_id_ejemplar_pago;


