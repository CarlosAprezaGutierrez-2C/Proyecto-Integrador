# Sistema de Inventario de Productos

Aplicacion de escritorio en JavaFX para administrar el inventario de una tienda local.
Guarda los datos en un archivo CSV sin necesidad de internet ni base de datos.

---

## Descripcion

El sistema permite:
- Agregar productos nuevos
- Ver todos los productos en una tabla
- Editar un producto existente
- Eliminar productos (con confirmacion)
- Buscar productos por nombre o codigo en tiempo real
- Ordenar la lista por nombre, precio o stock

Cada producto tiene: codigo, nombre, precio, stock y categoria.

---

## Como ejecutar

Necesitas tener instalado **Java 21** y **Maven**.

1. Abre una terminal en la carpeta del proyecto
2. Ejecuta:

```
mvn javafx:run
```

---

## Archivo de datos

Los productos se guardan en el archivo:

```
data/productos.csv
```

El formato de cada linea es:

```
codigo,nombre,precio,stock,categoria
```

Ejemplo:
```
LECH001,Leche Entera 1L,22.50,80,Lácteos
PAN002,Pan Blanco Grande,18.00,50,Panadería
```

Si el archivo no existe, el programa lo crea automaticamente al iniciar.

---

## Estructura del proyecto

```
src/
  main/
    java/
      com/example/demolistviewfile/
        HelloApplication.java      <- clase principal
        Models/
          Producto.java            <- clase modelo
        repositories/
          ProductRepository.java   <- lee y escribe el archivo
        services/
          ProductService.java      <- logica del negocio
        controllers/
          AppController.java       <- pantalla principal
          FormController.java      <- formulario de alta/edicion
    resources/
      views/
        app-view.fxml              <- vista principal
        form-view.fxml             <- vista del formulario
data/
  productos.csv                    <- archivo de datos
```

---

## Validaciones

- Ningun campo puede estar vacio
- El nombre necesita al menos 3 caracteres
- El precio debe ser mayor a 0
- El stock no puede ser negativo
- El codigo no se puede repetir

---

## Tecnologias

- Java 21
- JavaFX 21.0.6
- Maven
