-- --------------------------------------------
-- Configuración inicial de la base de datos
-- --------------------------------------------

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS molienda_fina;

-- Eliminar la base de datos (solo para pruebas, cuidado en producción)
DROP DATABASE molienda_fina;

-- Usar la base de datos creada
USE molienda_fina;

-- Mostrar las tablas existentes (para verificar)
SHOW TABLES;

-- --------------------------------------------
-- Tabla: clientes
-- Descripción: Almacena información de los clientes
-- --------------------------------------------
CREATE TABLE clientes (
    cliente_id BIGINT PRIMARY KEY,             -- ID único del cliente
    direccion VARCHAR(255),                   -- Dirección del cliente
    email VARCHAR(255),                       -- Email único del cliente
    apellido VARCHAR(255),                    -- Apellido del cliente
    nombre VARCHAR(255),                      -- Nombre del cliente
    telefono VARCHAR(20),                     -- Teléfono del cliente
    fecha_registro DATETIME                   -- Fecha de registro del cliente
);

-- --------------------------------------------
-- Tabla: proveedores
-- Descripción: Almacena información de los proveedores
-- --------------------------------------------
CREATE TABLE proveedores (
    proveedor_id BIGINT PRIMARY KEY,          -- ID único del proveedor
    nombre_empresa VARCHAR(255),             -- Nombre de la empresa proveedora
    contacto_nombre VARCHAR(255),            -- Nombre del contacto principal
    email VARCHAR(255),                      -- Email del proveedor
    telefono VARCHAR(255)                    -- Teléfono del proveedor
);


-- --------------------------------------------
-- Tabla: categorias
-- Descripción: Almacena las categorías de los productos
-- --------------------------------------------
CREATE TABLE categorias (
    categoria_id BIGINT PRIMARY KEY,          -- ID único de la categoría
    descripcion TEXT,                         -- Descripción de la categoría
    nombre_categoria VARCHAR(255)            -- Nombre único de la categoría
);

-- --------------------------------------------
-- Tabla: productos
-- Descripción: Almacena información de los productos
-- Relación: Cada producto pertenece a una categoría
-- --------------------------------------------
CREATE TABLE productos (
    producto_id BIGINT PRIMARY KEY,           -- ID único del producto
    fecha_creacion DATETIME,                 -- Fecha de creación del producto
    descripcion TEXT,                        -- Descripción del producto
    stock_minimo INT,                        -- Stock mínimo permitido
    nombre VARCHAR(255),                     -- Nombre del producto
    precio_unitario DECIMAL(10,2),           -- Precio unitario del producto
    stock_actual INT,                        -- Stock actual del producto
    categoria_id BIGINT,                     -- Relación con la tabla categorias
    FOREIGN KEY (categoria_id) REFERENCES categorias(categoria_id)
);

-- --------------------------------------------
-- Tabla: pedidos
-- Descripción: Almacena las órdenes realizadas por los clientes
-- Relación: Cada pedido pertenece a un cliente
-- --------------------------------------------
CREATE TABLE pedidos (
    pedido_id BIGINT PRIMARY KEY,            -- ID único del pedido
    fecha_pedido DATETIME,                   -- Fecha en que se realizó el pedido
    estado ENUM('PENDIENTE', 'COMPLETADO', 'CANCELADO'), -- Estado del pedido
    total DECIMAL(38,2),                     -- Total del pedido
    cliente_id BIGINT,                       -- Relación con la tabla clientes
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- --------------------------------------------
-- Tabla: pedidos
-- Descripción: Almacena las órdenes realizadas por los clientes
-- Relación: Cada pedido pertenece a un cliente
-- --------------------------------------------
CREATE TABLE pedidos (
    pedido_id BIGINT PRIMARY KEY,            -- ID único del pedido
    fecha_pedido DATETIME,                   -- Fecha en que se realizó el pedido
    estado ENUM('PENDIENTE', 'COMPLETADO', 'CANCELADO'), -- Estado del pedido
    total DECIMAL(38,2),                     -- Total del pedido
    cliente_id BIGINT,                       -- Relación con la tabla clientes
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- --------------------------------------------
-- Tabla: compras
-- Descripción: Relación entre productos y proveedores
-- --------------------------------------------
CREATE TABLE compras (
    compra_id BIGINT PRIMARY KEY,             -- ID único de la compra
    fecha_compra DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha de la compra
    cantidad INT NOT NULL,                    -- Cantidad comprada
    costo_unitario DECIMAL(38,2) NOT NULL,    -- Costo unitario del producto
    producto_id BIGINT NOT NULL,              -- Relación con la tabla productos
    proveedor_id BIGINT NOT NULL,             -- Relación con la tabla proveedores
    FOREIGN KEY (producto_id) REFERENCES productos(producto_id), -- Clave foránea a productos
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(proveedor_id) -- Clave foránea a proveedores
);

-- Consultas para verificar los datos en las tablas
SELECT * FROM clientes;          -- Ver todos los registros de la tabla clientes
SELECT * FROM pedidos;           -- Ver todos los registros de la tabla pedidos
SELECT * FROM productos;         -- Ver todos los registros de la tabla productos
SELECT * FROM detalles_pedido;   -- Ver todos los registros de la tabla detalles_pedido
SELECT * FROM proveedores;       -- Ver todos los registros de la tabla proveedores
SELECT * FROM compras;           -- Ver todos los registros de la tabla compras
SELECT * FROM categorias;        -- Ver todos los registros de la tabla categorias