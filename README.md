# Sistema de Gestión de Productos y Pedidos

Proyecto desarrollado en Java utilizando Programación Orientada a Objetos (POO) para el curso de BackEnd Java de TalentoTech.

El sistema permite gestionar productos y pedidos mediante un menú interactivo en consola, incluyendo validaciones, manejo de excepciones y herencia.

---

# Índice

1. Descripción del Proyecto
2. Funcionalidades
3. Tecnologías Utilizadas
4. Estructura del Proyecto
5. Clases Principales
6. Conceptos Aplicados
7. Validaciones Implementadas
8. Herencia
9. Excepción Personalizada
10. Cómo Ejecutar el Proyecto
11. Ejemplo de Uso
12. Autor

---

# Descripción del Proyecto

Este sistema permite:

- Gestionar productos.
- Crear pedidos con múltiples productos.
- Validar stock disponible.
- Actualizar stock automáticamente.
- Manejar errores mediante excepciones.
- Aplicar herencia entre clases.

El proyecto fue desarrollado siguiendo conceptos de Programación Orientada a Objetos utilizando Java.

---

# Funcionalidades

## Gestión de Productos

- Agregar productos
- Listar productos
- Buscar productos por ID
- Actualizar productos
- Eliminar productos
- Validar IDs duplicados
- Validar datos inválidos

## Gestión de Pedidos

- Crear pedidos
- Agregar múltiples productos a un pedido
- Calcular subtotales
- Calcular total del pedido
- Descontar stock automáticamente
- Listar pedidos registrados

---

# Tecnologías Utilizadas

- Java
- Programación Orientada a Objetos (POO)
- ArrayList
- Scanner
- Manejo de Excepciones
- Herencia
- Encapsulamiento

---

# Estructura del Proyecto

```text
src
├── exception
│   └── StockInsuficienteException.java
│
├── main
│   ├── Main.java
│   └── Menu.java
│
├── model
│   ├── Producto.java
│   ├── Bebida.java
│   ├── Comida.java
│   ├── Pedido.java
│   └── LineaPedido.java
│
└── service
    ├── ProductoService.java
    └── PedidoService.java
```

---

# Clases Principales

## Producto

Clase base que representa un producto del sistema.

### Atributos

- id
- nombre
- precio
- stock

---

## Bebida

Hereda de Producto.

### Atributos adicionales

- litros
- alcoholica

---

## Comida

Hereda de Producto.

### Atributos adicionales

- calorias
- vegetariana

---

## LineaPedido

Representa una línea dentro de un pedido.

### Contiene

- producto
- cantidad
- subtotal

---

## Pedido

Representa un pedido completo.

### Contiene

- id
- lista de líneas de pedido
- cálculo del total

---

## ProductoService

Gestiona operaciones CRUD de productos:

- agregar
- listar
- buscar
- actualizar
- eliminar
- validar productos

---

## PedidoService

Gestiona:

- creación de pedidos
- validación de stock
- descuento de stock
- listado de pedidos

---

# Conceptos Aplicados

Durante el desarrollo se aplicaron los siguientes conceptos:

- Clases y Objetos
- Encapsulamiento
- Constructores
- Herencia
- Polimorfismo básico
- ArrayList
- Relaciones entre clases
- Manejo de excepciones
- Validaciones
- Métodos reutilizables
- Separación por capas

---

# Validaciones Implementadas

El sistema valida:

- IDs mayores a cero
- IDs no repetidos
- Nombre no vacío
- Precio mayor a cero
- Stock no negativo
- Cantidad mayor a cero
- Stock suficiente al crear pedidos

---

# Herencia

El proyecto implementa herencia mediante:

```text
Producto
├── Bebida
└── Comida
```

Las clases Bebida y Comida reutilizan atributos y métodos de Producto utilizando `extends`.

---

# Excepción Personalizada

Se implementó la excepción:

```text
StockInsuficienteException
```

La misma se utiliza cuando un pedido solicita más unidades de un producto que las disponibles en stock.

---

# Cómo Ejecutar el Proyecto

1. Abrir el proyecto en NetBeans o cualquier IDE compatible con Java.
2. Ejecutar la clase:

```text
Main.java
```

3. Utilizar el menú interactivo desde consola.

---

# Ejemplo de Uso

```text
===== MENU PRINCIPAL =====
1. Agregar producto
2. Listar productos
3. Buscar producto por ID
4. Actualizar producto
5. Eliminar producto
6. Crear pedido
7. Listar pedidos
0. Salir
```

---

# Autor

Proyecto desarrollado por Matías Scalella.