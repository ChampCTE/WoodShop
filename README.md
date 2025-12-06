# WoodShops – Sistema de Gestión de Tiendas de Carpintería

Aplicación de consola en **Java** que diseñe para mis estudios  permite gestionar productos, tiendas, clientes y facturas dentro de un entorno simulado de una cadena de tiendas de bricolaje y carpintería.

---

## Descripción General

**WoodShops** es un sistema CRUD orientado a la gestión interna de una red de tiendas. Permite administrar:

* Proveedores
* Tiendas
* Clientes
* Productos (Tableros, Barnices y Artículos)
* Inventario por tienda
* Facturas y detalles de venta
* Resúmenes de ventas

El programa funciona mediante un menú interactivo por consola y utiliza varias clases relacionadas entre sí para simular un sistema real.

---

## Funcionalidades Principales

### 1. Añadir productos a una tienda

Permite seleccionar un **proveedor**, una **tienda**, definir un **producto nuevo** y establecer su precio y stock inicial.

### 2. Listar productos por tipo

Muestra los productos de una tienda filtrando entre:

* Tableros
* Barnices
* Artículos

### 3. Mostrar stock total de un producto

Dado un **código**, el sistema busca el producto en todas las tiendas y muestra:

* Stock
* Precio
* Tienda donde está disponible

### 4. Añadir nuevos clientes

Soporta dos tipos:

* **Cliente Profesional** (con descuento)
* **Cliente WoodFriend** (con código de socio)

También puede registrarse un cliente anónimo (sin almacenamiento).

### 5. Listar clientes

Muestra todos los clientes registrados y sus atributos.

### 6. Añadir una factura

Permite:

* Seleccionar cliente o realizar venta anónima
* Elegir tienda
* Agregar productos con cantidades
* Registrar la fecha y generar un ID

### 7. Mostrar detalles de una factura

Incluye:

* Cliente
* Fecha
* Tienda
* Productos, cantidades y total

### 8. Mostrar resumen de ventas

Agrupa las ventas por tienda y calcula total generado.

---

## Datos precargados

La sección `Datos()` inicializa:

* 3 proveedores
* 4 tiendas
* 2 clientes
* 3 tipos de productos
* Inventario inicial para cada tienda
* 4 facturas de ejemplo

Sirve para probar rápidamente el funcionamiento sin necesidad de ingresar datos manualmente.

---

##  Ejecución del Programa

Compilar y ejecutar desde consola:

```bash
javac aa4_woodshops/*.java
java aa4_woodshops.AA4_WoodShops
```

---

##  Aspectos Destacables del Código

* Uso de **Listas dinámicas** (`ArrayList`)
* Validación robusta de entradas con `InputMismatchException`
* Manejo de fechas con `SimpleDateFormat`
* Lógica modular y separada por funciones
* Uso de herencia y polimorfismo
* Control de inventario por tienda mediante `ProductoEnTienda`

---

## Requisitos

* **Java 17** o superior
* Consola o terminal

---

## Autores

Cèlia Trullà Estruch para la Universidad Oberta de Catalunya y Jesuïtes Educació.

