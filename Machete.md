# 🧰 Machete de `curl` - API Spring Boot Molienda Fina

Este documento te permite testear rápidamente las rutas de tu API usando `curl`.

## 📦 Categorías (`/api/categories`)

### Obtener todas las categorías
```bash
curl -X GET http://localhost:8080/api/categories
```

### Obtener categoria por ID 
```bash
curl -X GET http://localhost:8080/api/categories/{id}
```

### Crear una categoría
```bash
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{
    "name": "{nombre_categoria}",
    "description": "{descripcion}"
  }'
```

### Eliminar una categoría por ID
```bash
curl -X DELETE http://localhost:8080/api/categories/{id}
```

### Actualizar una categoría
```bash
curl -X PUT http://localhost:8080/api/categories/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "name": "{nuevo_nombre_categoria}",
    "description": "{nueva_descripcion}"
  }'
```

### Eliminar todas las categorías
```bash
curl -X DELETE http://localhost:8080/api/categories
```

## 📦 Productos (`/api/products`)

### Obtener todos los productos
```bash
curl -X GET http://localhost:8080/api/products
```
### Obtener un producto por nombre
```bash
curl -X GET "http://localhost:8080/api/products?search={nombre_producto}"
```

### Crear un producto
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "{nombre_producto}",
    "description": "{descripcion}",
    "price": {precio},
    "stock": {stock},
    "minStock": {minStock},
    "category": { "id": {categoria_id} }
  }'
```

### Obtener productos con stock bajo
```bash
curl -X GET http://localhost:8080/api/products/low-stock
```

### Obtener producto por ID
```bash
curl -X GET http://localhost:8080/api/products/{id}
```

### Actualizar un producto
```bash
curl -X PUT http://localhost:8080/api/products/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "name": "{nuevo_nombre_producto}",
    "description": "{nueva_descripcion}",
    "price": {nuevo_precio},
    "stock": {nuevo_stock},
    "minStock": {nuevo_minStock},
    "category": { "id": {categoria_id} }
  }'
```

### Elimina un producto por ID
```bash
curl -X DELETE http://localhost:8080/api/products/{id}
```

### Elimina todos los productos
```bash
curl -X DELETE http://localhost:8080/api/products
```

### 📦 Clientes (`/api/clients`)

### Obtener todos los clientes
```bash
curl -X GET http://localhost:8080/api/clients
```

### Crear un cliente
```bash
curl -X POST http://localhost:8080/api/clients \
  -H "Content-Type: application/json" \
  -d '{
    "name": "{nombre_cliente}",
    "lastName": "{apellido_cliente}",
    "phone": "{telefono_cliente}",
    "email": "{email_cliente}",
    "address": "{direccion_cliente}"
  }'
```

### Obtener cliente por ID
```bash
curl -X GET http://localhost:8080/api/clients/{id}
```

### Actualizar un cliente
```bash
curl -X PUT http://localhost:8080/api/clients/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "name": "{nuevo_nombre_cliente}",
    "lastName": "{nuevo_apellido_cliente}",
    "phone": "{nuevo_telefono_cliente}",
    "email": "{nuevo_email_cliente}",
    "address": "{nueva_direccion_cliente}"
  }'
```

### Eliminar un cliente por ID
```bash
curl -X DELETE http://localhost:8080/api/clients/{id}
```

### Eliminar todos los clientes
```bash
curl -X DELETE http://localhost:8080/api/clients
```

### 📦 Pedidos (`/api/orders`)

### Obtener todos los pedidos
```bash
curl -X GET http://localhost:8080/api/orders
```

### Obtener un pedido por ID
```bash
curl -X GET http://localhost:8080/api/orders/{id}
```

### Crear un pedido
```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "client": { "id": {id_cliente} },
    "status": "{estado_orden}",
    "total": {total_orden}
  }'
```

### Actualizar un pedido
```bash
curl -X PUT http://localhost:8080/api/orders/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "client": { "id": {nuevo_id_cliente} },
    "status": "{nuevo_estado_orden}",
    "total": {nuevo_total_orden}
  }'
```

### Eliminar un pedido por ID
```bash
curl -X DELETE http://localhost:8080/api/orders/{id}
```

### Eliminar todos los pedidos
```bash
curl -X DELETE http://localhost:8080/api/orders
```


## 📦 Detalles de pedidos (`/api/order-details`)

### Obtener todos los detalles de pedidos
```bash
curl -X GET http://localhost:8080/api/order-details
```

### Obtener un detalle de pedido por ID
```bash
curl -X GET http://localhost:8080/api/order-details/{id}
```

### Crear un detalle de pedido
```bash
curl -X POST http://localhost:8080/api/order-details \
  -H "Content-Type: application/json" \
  -d '{
    "order": { "id": {id_pedido} },
    "product": { "id": {id_producto} },
    "quantity": {cantidad},
    "unitPrice": {precio_unitario}
  }'
```

### Eliminar un detalle de pedido por ID
```bash
curl -X DELETE http://localhost:8080/api/order-details/{id}
```

### Eliminar todos los detalles de pedidos
```bash
curl -X DELETE http://localhost:8080/api/order-details
```

## 📦 Proveedores (`/api/suppliers`)

### Obtener todos los proveedores
```bash
curl -X GET http://localhost:8080/api/suppliers
```

### Obtener proveedor por ID
```bash
curl -X GET http://localhost:8080/api/suppliers/{id}
```

### Crear un proveedor
```bash
curl -X POST http://localhost:8080/api/suppliers \
  -H "Content-Type: application/json" \
  -d '{
    "companyName": "{nombre_empresa}",
    "contactName": "{nombre_contacto}",
    "phone": "{telefono}",
    "email": "{email}"
  }'
```

### Actualizar un proveedor
```bash
curl -X PUT http://localhost:8080/api/suppliers/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "companyName": "{nuevo_nombre_empresa}",
    "contactName": "{nuevo_nombre_contacto}",
    "phone": "{nuevo_telefono}",
    "email": "{nuevo_email}"
  }'
```

### Eliminar un proveedor por ID
```bash
curl -X DELETE http://localhost:8080/api/suppliers/{id}
```

### Eliminar todos los proveedores
```bash
curl -X DELETE http://localhost:8080/api/suppliers
```

## 📦 Compras (`/api/purchases`)

### Obtener todas las compras
```bash
curl -X GET http://localhost:8080/api/purchases
```

### Obtener compra por ID
```bash
curl -X GET http://localhost:8080/api/purchases/{id}
```

### Crear una compra
```bash
curl -X POST http://localhost:8080/api/purchases \
  -H "Content-Type: application/json" \
  -d '{
    "supplier": { "id": {id_proveedor} },
    "product": { "id": {id_producto} },
    "quantity": {cantidad},
    "unitCost": {costo_unitario}
  }'
```

### Obtener compras por proveedor
```bash
curl -X GET "http://localhost:8080/api/purchases?supplierId={id_proveedor}"
```

### Obtener compras por producto
```bash
curl -X GET "http://localhost:8080/api/purchases?productId={id_producto}"
```

### Eliminar una compra por ID
```bash
curl -X DELETE http://localhost:8080/api/purchases/{id}
```

### Eliminar todas las compras
```bash
curl -X DELETE http://localhost:8080/api/purchases
```