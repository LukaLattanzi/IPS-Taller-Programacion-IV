# 🛒 Molienda Fina - Sistema de Gestión para Negocios

Este proyecto es una base para la gestión de un negocio, desarrollado con **Spring Boot**. Incluye funcionalidades para manejar productos, categorías, clientes, proveedores, compras, pedidos y detalles de pedidos. Además, está diseñado para facilitar pruebas y desarrollo mediante comandos `curl` y una conexión a una base de datos MySQL.

---

## 📋 Tabla de Contenidos

1. [Descripción General](#descripción-general)  
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)  
3. [Estructura del Proyecto](#estructura-del-proyecto)  
4. [Configuración del Proyecto](#configuración-del-proyecto)  
5. [Base de Datos](#base-de-datos)  
6. [Controladores y Endpoints](#controladores-y-endpoints)  
7. [Comandos `curl`](#comandos-curl)  
8. [Dashboard](#dashboard)  
9. [Pruebas](#pruebas)  
10. [Contribuciones](#contribuciones)  

---

## 📖 Descripción General

El sistema **Molienda Fina** es una base para gestionar los elementos principales de un negocio. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre las siguientes entidades:

- **Productos**: Gestión de inventario.  
- **Categorías**: Clasificación de productos.  
- **Clientes**: Información de los clientes.  
- **Proveedores**: Gestión de proveedores.  
- **Compras**: Registro de compras realizadas a proveedores.  
- **Pedidos**: Gestión de pedidos realizados por clientes.  
- **Detalles de Pedido**: Información detallada de cada pedido.  

El proyecto incluye un **dashboard** para visualizar y probar todas las entidades, y está diseñado para integrarse con una base de datos MySQL.

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**: Lenguaje principal del proyecto.  
- **Spring Boot**: Framework para el desarrollo rápido de aplicaciones.  
    - **Spring Data JPA**: Para la interacción con la base de datos.  
    - **Spring Web**: Para la creación de APIs REST.  
    - **Thymeleaf**: Motor de plantillas para el frontend.  
- **MySQL**: Base de datos relacional.  
- **Bootstrap 5**: Para el diseño del frontend.  
- **Lombok**: Para reducir el código boilerplate.  
- **Maven**: Herramienta de gestión de dependencias y construcción.  

---

## 📂 Estructura del Proyecto

```plaintext
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/    # Controladores REST
│   │   │   ├── model/         # Entidades JPA
│   │   │   ├── repository/    # Repositorios JPA
│   │   │   └── DemoApplication.java
│   │   ├── resources/
│   │       ├── templates/     # Plantillas Thymeleaf (dashboard.html)
│   │       └── application.properties
│   ├── test/                  # Pruebas unitarias
├── docs/                      # Documentación y scripts
│   ├── machete_curl.md        # Comandos curl para probar la API
│   ├── molienda_fina_db.sql   # Estructura de la base de datos
│   └── README.md              # Este archivo
├── pom.xml                    # Configuración de Maven
└── target/                    # Archivos generados por Maven
```

---

## ⚙️ Configuración del Proyecto

1. **Clonar el repositorio**  
     ```bash
     git clone <URL_DEL_REPOSITORIO>
     cd demo
     ```

2. **Configurar la base de datos**  
     - Crea una base de datos MySQL llamada `molienda_fina`.  
     - Configura las credenciales en el archivo `application.properties`.  

3. **Ejecutar el proyecto**  
     - Usa Maven para compilar y ejecutar:  
         ```bash
         mvn spring-boot:run
         ```  
     - Accede al dashboard en: [http://localhost:8080/dashboard](http://localhost:8080/dashboard).  

---

## 🗄️ Base de Datos

La estructura de la base de datos se encuentra en el archivo `molienda_fina_db.sql`. Incluye las siguientes tablas:

- `clientes`  
- `proveedores`  
- `categorias`  
- `productos`  
- `compras`  
- `pedidos`  
- `detalles_pedido`  

Para cargar la estructura, ejecuta el archivo `.sql` en tu cliente MySQL.

---

## 🌐 Controladores y Endpoints

El proyecto incluye controladores REST para cada entidad. Aquí están los principales:

### Categorías (`/api/categories`)  
- `GET /api/categories`: Obtener todas las categorías.  
- `POST /api/categories`: Crear una nueva categoría.  

### Productos (`/api/products`)  
- `GET /api/products`: Obtener todos los productos.  
- `POST /api/products`: Crear un nuevo producto.  

### Clientes (`/api/clients`)  
- `GET /api/clients`: Obtener todos los clientes.  
- `POST /api/clients`: Crear un nuevo cliente.  

### Proveedores (`/api/suppliers`)  
- `GET /api/suppliers`: Obtener todos los proveedores.  
- `POST /api/suppliers`: Crear un nuevo proveedor.  

### Compras (`/api/purchases`)  
- `GET /api/purchases`: Obtener todas las compras.  
- `POST /api/purchases`: Registrar una nueva compra.  

### Pedidos (`/api/orders`)  
- `GET /api/orders`: Obtener todos los pedidos.  
- `POST /api/orders`: Crear un nuevo pedido.  

### Detalles de Pedido (`/api/order-details`)  
- `GET /api/order-details`: Obtener todos los detalles de pedidos.  
- `POST /api/order-details`: Crear un nuevo detalle de pedido.  

---

## 🧰 Comandos `curl`

El archivo `machete_curl.md` contiene ejemplos de comandos `curl` para probar cada endpoint de la API. Por ejemplo:

### Crear un producto  
```bash
curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{"name": "Producto A", "price": 100.0, "categoryId": 1}'
```

---

## 📊 Dashboard

El dashboard es una interfaz web para visualizar y probar todas las entidades del sistema. Está disponible en: [http://localhost:8080/dashboard](http://localhost:8080/dashboard).

### Funcionalidades:  
- Visualización de productos, categorías, clientes, proveedores, compras, pedidos y detalles de pedidos.  
- Navegación mediante pestañas.  
- Diseño responsivo con Bootstrap.  

---

## 🧪 Pruebas

El proyecto incluye pruebas básicas en el archivo `DemoApplicationTests.java`. Para ejecutarlas:  
```bash
mvn test
```

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.  
2. Crea una rama para tu funcionalidad:  
     ```bash
     git checkout -b feature/nueva-funcionalidad
     ```  
3. Realiza un pull request.  

---

## 📜 Licencia

Este proyecto está bajo la licencia MIT.