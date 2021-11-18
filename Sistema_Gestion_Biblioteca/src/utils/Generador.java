package utils;

import java.time.LocalDate;
import java.util.Scanner;

import domain.libro.CopiaLibro;
import domain.libro.EstadoLibro;
import domain.libro.Genero;
import domain.persona.Autor;
import operations.IOperacion;

public class Generador {

    /**
     * crea un objeto de tipo CopiaLibro en base a un String con sus atributos
     * 
     * @param atributosLibro toString salida de copia libro
     * @return CopiaLibro
     */
    public static CopiaLibro instanciarCopiaLibro(String atributosLibro) {
        String[] atributosLibroArr = atributosLibro.split(",");
        for (String string : atributosLibroArr) {
            System.out.println(string);
        }

        String titulo = atributosLibroArr[0];
        Genero genero = Genero.valueOf(atributosLibroArr[1]);
        Autor autor = instanciarAutor(atributosLibroArr[2]);
        Integer cantidad = Integer.parseInt(atributosLibroArr[3]);
        EstadoLibro estadoLibro = EstadoLibro.valueOf(atributosLibroArr[4]);

        return new CopiaLibro(titulo, genero, autor, cantidad, estadoLibro);
    }

    /**
     * crea un objeto de tipo Autor en basea un string con sus atributos
     * 
     * @param atributosAutor salida toString de los datos del autor
     * @return un autor
     */
    public static Autor instanciarAutor(String atributosAutor) {
        String[] atributosAutorArr = atributosAutor.split(";");
        for (String string : atributosAutorArr) {
            System.out.println(string);
        }

        String nombre = atributosAutorArr[0];
        LocalDate fechaNacimiento = LocalDate.parse(atributosAutorArr[1]);
        LocalDate fechaFallecimiento = null;

        if (!atributosAutorArr[2].equals("null"))
            fechaFallecimiento = LocalDate.parse(atributosAutorArr[2]);

        String paisOrigen = atributosAutorArr[3];

        return new Autor(nombre, fechaNacimiento, fechaFallecimiento, paisOrigen);
    }

    /**
     * crea una copia de libro, para agregar a la base de datos, en base a inputs
     * del ususario
     *
     * @return String salida toString de copia de libro
     */
    public static String crearCopiaLibro(Scanner scanner, IOperacion operacion) {
        int opcion = -1;
        CopiaLibro.Builder builder = new CopiaLibro.Builder();
        while (opcion != 0) {
            mostrarMenuCrearCopiaLibro();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                evaluarOpcion(opcion, operacion, scanner, builder);
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un valor válido");
                opcion = -1;
            }
        }
        System.out.println("Saliendo al menu principal");
        return builder.build().toString();
    }

    private static void mostrarMenuCrearCopiaLibro() {
        System.out.println("\nAGREGAR NUEVO LIBRO");
        System.out.println("===============================");
        System.out.println("Elige una opción:");
        System.out.println("1 - Agregar/Editar Titulo del libro");
        System.out.println("2 - Agregar/Editar Genero del libro");
        System.out.println("3 - Agregar/Editar Autor del libro");
        System.out.println("4 - Agregar/Editar Cantidad de Copias");
        System.out.println("5 - Agregar/Editar Estado del libro");
        System.out.println("0 - MENU PRINCIPAL");
    }

    private static void evaluarOpcion(Integer opcion, IOperacion operacion, Scanner scanner, CopiaLibro.Builder builder) {
        switch (opcion) {
            case 1:
                System.out.println("Agregar/Editar Titulo del libro");
                String titulo = scanner.nextLine();
                builder.conTitulo(titulo);
                break;

            case 2:
                System.out.println("Agregar/Editar Genero del libro. \n" +
                        "POLICIAL, ROMANTICO, CLASICO, THRILLER, POESIA, ENSAYO, NOVELA");
                try {
                    builder.conGenero(Genero.valueOf(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    System.out.println("ingrese uno de los siguientes valores: \n" +
                            "POLICIAL, ROMANTICO, CLASICO, THRILLER, POESIA, ENSAYO, NOVELA");
                }
                break;

            case 3:
                System.out.println("Agregar/Editar Autor del libro");
                System.out.println("Ingrese nombre del Autor");
                String nombre = scanner.nextLine();
                //TODO: BUSCAR SI EXISTE SINO CREAR Y AGREGAR
                Autor.Builder autorBuilder = new Autor.Builder();
                autorBuilder.conNombre(nombre);
                System.out.println("Ingrese fecha de nacimiento del Autor: dd/mm/yyyy");
                String fechaNacimiento = scanner.nextLine();
                autorBuilder.conFechaNacimiento(fechaNacimiento);
                System.out.println("Ingrese fecha de fallecimiento del Autor: dd/mm/yyyy");
                System.out.println("Ingrese 31/12/9999 si el autor esta vivo");
                String fechaFallecimiento = scanner.nextLine();
                autorBuilder.conFechaFallecimiento(fechaFallecimiento);
                System.out.println("Ingrese pais de origen del autor");
                String paisOrigen = scanner.nextLine();
                autorBuilder.conPaisOrigen(paisOrigen);
                builder.conAutor(autorBuilder.build());
                break;

            case 4:
                System.out.println("Agregar/Editar Cantidad de copias del libro. \n");
                try {
                    builder.conCantidad(Integer.parseInt(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    System.out.println("ingrese un entero");
                }
                break;
            case 5:
                System.out.println("Agregar/Editar Estado del libro. \n" +
                        "EN_BIBLIOTECA, PRESTADO, EN_REPARACION, RETRASO");
                try {
                    builder.conEstadoLibro(EstadoLibro.valueOf(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    System.out.println("ingrese uno de los siguientes valores: \n" +
                            "EN_BIBLIOTECA, PRESTADO, EN_REPARACION, RETRASO");
                }
                break;
            default:
                break;
        }
    }

}
