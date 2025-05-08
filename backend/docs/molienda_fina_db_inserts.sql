INSERT INTO clientes (nombre, apellido, telefono, email, direccion) VALUES
('Juan', 'Pérez', '3511234567', 'juan.perez@mail.com', 'Calle Falsa 123'),
('Ana', 'Gómez', '3517654321', 'ana.gomez@mail.com', 'Av. Siempre Viva 742'),
('Pedro', 'López', '3518765432', 'pedro.lopez@mail.com', 'Diagonal 80 N°200'),
('María', 'Fernández', '3516543210', 'maria.fernandez@mail.com', 'Boulevard 33 #400'),
('Luis', 'Rodríguez', '3515432109', 'luis.rodriguez@mail.com', 'Ruta 9 KM 12'),
('Sofía', 'Martínez', '3514321098', 'sofia.martinez@mail.com', 'Calle 45 N°123'),
('Carlos', 'Díaz', '3513210987', 'carlos.diaz@mail.com', 'Av. Central 456'),
('Valeria', 'Ramírez', '3512109876', 'valeria.ramirez@mail.com', 'Diagonal 90 N°789'),
('Ricardo', 'González', '3511098765', 'ricardo.gonzalez@mail.com', 'Boulevard 12 #345'),
('Carolina', 'Torres', '3510987654', 'carolina.torres@mail.com', 'Ruta 8 KM 15');

INSERT INTO proveedores (nombre_empresa, contacto_nombre, telefono, email) VALUES
('Especias Gourmet', 'Sofía Torres', '3511234567', 'contacto@especiasgourmet.com'),
('Condimentos del Norte', 'Javier Díaz', '3517654322', 'ventas@condimentosnorte.com'),
('Sabores del Mundo', 'Laura Ramírez', '3518765432', 'info@saboresdelmundo.com'),
('Hierbas Naturales', 'Fernando Ruiz', '3516543210', 'ventas@hierbasnaturales.com'),
('Aromas Andinos', 'Clara Mendoza', '3515432109', 'contacto@aromasandinos.com'),
('Delicias Orientales', 'Hugo Sánchez', '3514321098', 'ventas@deliciasorientales.com'),
('Especias Premium', 'Marta López', '3513210987', 'info@especiaspremium.com'),
('Sabores Tradicionales', 'Luis Gómez', '3512109876', 'contacto@saborestradicionales.com'),
('Hierbas del Sur', 'Ricardo Fernández', '3511098765', 'ventas@hierbasdelsur.com'),
('Aromas Naturales', 'Carolina Díaz', '3510987654', 'info@aromasnaturales.com');

INSERT INTO categorias (nombre_categoria, descripcion) VALUES
('Especias', 'Condimentos y especias para cocina'),
('Hierbas', 'Hierbas secas y frescas para uso culinario'),
('Salsas', 'Salsas y aderezos para comidas'),
('Granos', 'Granos y semillas para consumo'),
('Frutos Secos', 'Frutos secos y deshidratados'),
('Aceites', 'Aceites esenciales y de cocina'),
('Bebidas', 'Bebidas naturales y orgánicas'),
('Dulces', 'Dulces y confitería artesanal'),
('Panadería', 'Productos de panadería y repostería'),
('Lácteos', 'Productos lácteos y derivados');

INSERT INTO productos (nombre, descripcion, precio_unitario, stock_actual, stock_minimo, categoria_id) VALUES
('Orégano', 'Hojas secas de orégano', 500.00, 100, 5, 1),
('Provenzal', 'Mezcla de ajo y perejil seco', 550.00, 80, 5, 1),
('Perejil', 'Hojas secas de perejil', 450.00, 120, 5, 1),
('Tomillo', 'Hojas secas de tomillo', 600.00, 90, 5, 1),
('Romero', 'Hojas secas de romero', 700.00, 50, 5, 1),
('Albahaca', 'Hojas secas de albahaca', 400.00, 70, 5, 1),
('Curry', 'Mezcla de especias para curry', 800.00, 60, 5, 1),
('Pimienta Negra', 'Granos de pimienta negra', 900.00, 40, 5, 1),
('Canela', 'Ramas de canela', 300.00, 110, 5, 1),
('Clavo de Olor', 'Granos de clavo de olor', 350.00, 100, 5, 1);

INSERT INTO compras (proveedor_id, producto_id, cantidad, costo_unitario) VALUES
(1, 1, 50, 450.00),
(2, 2, 70, 500.00),
(3, 3, 100, 400.00),
(4, 4, 80, 550.00),
(5, 5, 60, 650.00),
(6, 6, 90, 350.00),
(7, 7, 40, 750.00),
(8, 8, 30, 850.00),
(9, 9, 110, 250.00),
(10, 10, 100, 300.00);

INSERT INTO pedidos (cliente_id, estado) VALUES
(1, 'PENDIENTE'),
(2, 'COMPLETADO'),
(3, 'CANCELADO'),
(4, 'PENDIENTE'),
(5, 'COMPLETADO'),
(6, 'PENDIENTE'),
(7, 'CANCELADO'),
(8, 'PENDIENTE'),
(9, 'COMPLETADO'),
(10, 'PENDIENTE');

INSERT INTO detalles_pedido (pedido_id, producto_id, cantidad, precio_unitario) VALUES
(1, 1, 2, 500.00),
(1, 2, 1, 550.00),
(2, 3, 3, 450.00),
(2, 4, 2, 600.00),
(3, 5, 1, 700.00),
(4, 6, 4, 400.00),
(5, 7, 2, 800.00),
(6, 8, 1, 900.00),
(7, 9, 3, 300.00),
(8, 10, 2, 350.00);