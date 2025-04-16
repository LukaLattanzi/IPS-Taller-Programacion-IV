# 🧰 Machete de `curl` - API Spring Boot Molienda Fina

Este documento te permite testear rápidamente las rutas de tu API usando `curl`.

---

## 📦 Productos (`/api/products`)

### ✅ Crear producto
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Pimienta Negra",
    "description": "Ideal para carnes",
    "price": 350.00,
    "stock": 100,
    "minStock": 10,
    "category": { "id": 1 }
  }'
```

### ✅ Obtener todos los productos
```bash
curl -X GET http://localhost:8080/api/products
```

### ✅ Obtener producto por ID
```bash
curl -X GET http://localhost:8080/api/products/1
```

### Buscar por nombre
```bash
curl -X GET "http://localhost:8080/api/products/search?name=Pimienta"
```

### Productos con stock bajo
```bash
curl -X GET http://localhost:8080/api/products/low-stock
```

### ✅ Eliminar producto
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

### ✅ Eliminar todos los productos
```bash
curl -X DELETE http://localhost:8080/api/products
```

### ✅ Actualizar producto
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Pimienta Negra",
    "description": "Ideal para carnes",
    "price": 350.00,
    "stock": 100,
    "minStock": 10,
    "category": { "id": 1 }
  }'
```

##  📦 Categorías (`/api/categories`)

### ✅ Crear categoría
```bash
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Especias",
    "description": "Categoría de especias"
  }'
```

### ✅ Obtener todas las categorías
```bash
curl -X GET http://localhost:8080/api/categories
```

### ✅ Obtener categoría por ID
```bash
curl -X GET http://localhost:8080/api/categories/1
```

### ✅ Buscar por nombre
```bash
curl -X GET "http://localhost:8080/api/categories/search?name=Especias"
```

### ✅ Eliminar categoría
```bash
curl -X DELETE http://localhost:8080/api/categories/1
```

### ✅ Eliminar todas las categorías
```bash
curl -X DELETE http://localhost:8080/api/categories
```

### ✅ Actualizar categoría
```bash
curl -X PUT http://localhost:8080/api/categories/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Especias",
    "description": "Categoría de especias"
  }'
```

