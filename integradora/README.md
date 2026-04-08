# Sistema de Inventario Básico (JavaFX)

## Descripción del Sistema
Este proyecto es una aplicación de escritorio sencilla para gestionar el inventario de una tiendita local. Está desarrollado en JavaFX aplicando los principios de la Programación Orientada a Objetos (POO). 
Permite llevar un control de los productos (Alta, Baja, Modificación y Consulta - CRUD) sin necesidad de una base de datos compleja ni conexión a internet, ya que guarda toda la información en un archivo de texto local. Cuenta también con funciones de búsqueda en tiempo real y ordenamiento de columnas (A-Z).

## Cómo Ejecutar
1. Abre el proyecto en un entorno de desarrollo compatible con Maven (como IntelliJ IDEA, Eclipse o NetBeans).
2. Asegúrate de tener configurado el JDK 21+ o la versión correspondiente a JavaFX instalada en tu sistema.
3. Ejecuta la clase principal llamada `Launcher.java` (o `HelloApplication.java`), ubicada en el paquete `com.example.integradora`.
4. (Opcional) Si usas línea de comandos, puedes compilar y ejecutar con Maven: `mvn clean javafx:run`.

## Persistencia de Datos
Toda la información se maneja a través de archivos de texto estructurados en formato CSV.
- **Ubicación:** Los datos se guardan o se crean automáticamente dentro de una carpeta llamada `data` en la raíz del proyecto.
- **Archivo:** `productos.csv`
- **Formato:** Cada fila del archivo representa un producto, separado por comas: `Código,Nombre,Precio,Stock,Categoría`.
(Por ejemplo: `PAN002,Pan Blanco Grande,18.00,50,Panadería`).

