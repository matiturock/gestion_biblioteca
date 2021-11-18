# Sistema de Gestión de Biblioteca

El presente es un Trabajo Final Integrador en el marco de la materia **Laboratorio de Programación 2**, de la carrera Tecnicatura Universitaria en Programación, de la UTN sede Resistencia, año 2021.

## Qué hace la app?

La aplicación está pensada para ser usada por una bibliotecaria mediante comandos en consola.
La base de datos donde se depositan los datos de los libros es un archivo.txt, con registros (renglones) separando los valores por comas.
La app permite:

- Listar libros
- Cargar libros
- Cargar lectores
- Prestra libros y listar libros prestados
- Identificar cuando un libro está en mora

## Estructura

### **data**

Se encarga de manejar la creación, lectura y escritura del arhivo que contiene los registros de los libros.

### **domain**

Dominio del problema. Contiene los paquetes:

- libro: para CopiaLibro
- persona: para Autor y Lector

### **operations**

Operaciones que puede realizar la bibliotecaria. Conecta la capa **data** con la **view** para lograr un bajo acoplamiento y alta cohesión.

### **test**

Se usa para probar funcionalidades a ser implmentandas en la app.

### **utils**

Se guardan las clases generadoras de objetos (como ser Autor o CopiaLibro) o formateadoras de Strings.

### **view**

Vista interfaz de cara al usuario final. Se conecta a la capa **operations**.

# Menús

## Menu Principal

1. Crea el archivo.
2. Despliega lista de libros.

## Menu Libro

## Menu Lector

## Integrantes del grupo

- Insfran Maximiliano
- Piedra Paula
- Ramírez Jésica
- Almirón R. Matías

