-- --------------------------------------------
-- Configuración inicial de la base de datos
-- --------------------------------------------

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS molienda_fina;

-- ⚠️ Eliminar la base de datos (solo para pruebas, cuidado en producción)
DROP DATABASE molienda_fina;

-- Usar la base de datos creada
USE molienda_fina;

-- Mostrar las tablas existentes (para verificar estructura)
SHOW TABLES;

-- --------------------------------------------
-- Tabla: clientes
-- Descripción: Información personal y contacto de los clientes
-- --------------------------------------------
CREATE TABLE clientes (
    cliente_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(255) NOT NULL UNIQUE,
    direccion VARCHAR(255),
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- --------------------------------------------
-- Tabla: proveedores
-- Descripción: Datos de proveedores de productos
-- --------------------------------------------
CREATE TABLE proveedores (
    proveedor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(255) NOT NULL,
    contacto_nombre VARCHAR(255),
    telefono VARCHAR(255),
    email VARCHAR(255)
);

-- --------------------------------------------
-- Tabla: categorias
-- Descripción: Categorías a las que pertenecen los productos
-- --------------------------------------------
CREATE TABLE categorias (
    categoria_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(255) NOT NULL UNIQUE,
    descripcion TEXT
);

-- --------------------------------------------
-- Tabla: productos
-- Descripción: Productos disponibles para la venta
-- Relación: Cada producto pertenece a una categoría
-- --------------------------------------------
CREATE TABLE productos (
    producto_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    stock_actual INT NOT NULL,
    stock_minimo INT NOT NULL DEFAULT 5,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    categoria_id BIGINT,
    CONSTRAINT FK_producto_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(categoria_id)
);

-- --------------------------------------------
-- Tabla: pedidos
-- Descripción: Registro de pedidos de clientes
-- --------------------------------------------
CREATE TABLE pedidos (
    pedido_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('PENDIENTE', 'COMPLETADO', 'CANCELADO') NOT NULL DEFAULT 'PENDIENTE',
    total DECIMAL(38, 2) NOT NULL DEFAULT 0.00,
    CONSTRAINT FK_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- --------------------------------------------
-- Tabla: detalles_pedido
-- Descripción: Línea de detalle de cada producto incluido en un pedido
-- --------------------------------------------
CREATE TABLE detalles_pedido (
    detalle_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    CONSTRAINT FK_detalle_pedido FOREIGN KEY (pedido_id) REFERENCES pedidos(pedido_id),
    CONSTRAINT FK_detalle_producto FOREIGN KEY (producto_id) REFERENCES productos(producto_id)
);

-- --------------------------------------------
-- Tabla: compras
-- Descripción: Registra compras (reposición) de productos a proveedores
-- --------------------------------------------
CREATE TABLE compras (
    compra_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    proveedor_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    cantidad INT NOT NULL,
    costo_unitario DECIMAL(10, 2) NOT NULL,
    fecha_compra DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_compra_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedores(proveedor_id),
    CONSTRAINT FK_compra_producto FOREIGN KEY (producto_id) REFERENCES productos(producto_id)
);

-- --------------------------------------------
-- Consultas para verificar el contenido de las tablas
-- --------------------------------------------
SELECT * FROM clientes;
SELECT * FROM pedidos;
SELECT * FROM productos;
SELECT * FROM detalles_pedido;
SELECT * FROM proveedores;
SELECT * FROM compras;
SELECT * FROM categorias;

-- --------------------------------------------
-- TRIGGERS: Automatización de la lógica de stock y totales
-- --------------------------------------------

-- 🔻 Resta stock cuando se inserta un nuevo detalle de pedido
DELIMITER $$

CREATE TRIGGER restar_stock_detalle_pedido
AFTER INSERT ON detalles_pedido
FOR EACH ROW
BEGIN
    UPDATE productos
    SET stock_actual = stock_actual - NEW.cantidad
    WHERE producto_id = NEW.producto_id;
END$$

DELIMITER ;

-- 🔼 Suma stock cuando se hace una nueva compra (reposiciona)
DELIMITER $$

CREATE TRIGGER sumar_stock_compra
AFTER INSERT ON compras
FOR EACH ROW
BEGIN
    UPDATE productos
    SET stock_actual = stock_actual + NEW.cantidad
    WHERE producto_id = NEW.producto_id;
END$$

DELIMITER ;

-- 🚫 Valida que no se pueda insertar un pedido si no hay stock suficiente
DELIMITER $$

CREATE TRIGGER verificar_stock_suficiente
BEFORE INSERT ON detalles_pedido
FOR EACH ROW
BEGIN
    DECLARE stock_actual INT;
    SELECT p.stock_actual INTO stock_actual FROM productos p WHERE p.producto_id = NEW.producto_id;

    IF stock_actual < NEW.cantidad THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Stock insuficiente para realizar el pedido';
    END IF;
END$$

DELIMITER ;

-- --------------------------------------------
-- Índices para mejorar el rendimiento de consultas
-- --------------------------------------------
CREATE INDEX idx_detalle_pedido ON detalles_pedido(pedido_id);
CREATE INDEX idx_detalle_producto ON detalles_pedido(producto_id);

-- --------------------------------------------
-- 🔄 Trigger para actualizar automáticamente el total del pedido
-- --------------------------------------------
DELIMITER $$

CREATE TRIGGER actualizar_total_pedido
AFTER INSERT ON detalles_pedido
FOR EACH ROW
BEGIN
    UPDATE pedidos
    SET total = IFNULL(total, 0) + (NEW.cantidad * NEW.precio_unitario)
    WHERE pedido_id = NEW.pedido_id;
END$$

DELIMITER ;