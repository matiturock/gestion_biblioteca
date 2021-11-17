package view;

import java.util.Scanner;

import operations.IOperacion;
import operations.OperacionBiblioteca;
import utils.Generador;

/**
 * Vista de interfaz de consola de cara al usuaario final Conecta las opciones
 * de usuario con las Operaciones
 */

public class AppBiblioteca {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1;

        IOperacion operacion = new OperacionBiblioteca();

        while (opcion != 0) {
            mostrarMenuPrincipal();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                evaluarOpcion(opcion, operacion, scanner);
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un valor válido");
                opcion = -1;
            }
        }

        System.out.println("Saliendo del sistema");
        scanner.close();
    }

    private static void evaluarOpcion(Integer opcion, IOperacion operacion, Scanner scanner) {
        switch (opcion) {
        case 1:
            operacion.iniciarArchivo();
            System.out.println("Catálogo de libros iniciado");
            break;

        case 2:
            System.out.println("Listado de libros");
            operacion.listarLibros();
            break;

        case 3:
            System.out.println("Agregando libro");
            operacion.agregarCopiaLibro(Generador.crearCopiaLibro(scanner, operacion));
            break;
        default:
            break;
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nSISTEMA DE GESTIÓN DE BILIOTECA");
        System.out.println("===============================");
        System.out.println("Elige una opción:");
        System.out.println("1 - Iniciar catálogo de libros");
        System.out.println("2 - Listar libros");
        System.out.println("3 - Agregar libro");
        System.out.println("4 - Listar lectores");
        System.out.println("5 - Agregar lector");
        System.out.println("6 - MENU LECTORES");
        System.out.println("0 - SALIR");
    }

    private static void mostrarMenuLectores() {
        System.out.println("\nSISTEMA DE GESTIÓN DE BILIOTECA");
        System.out.println("===============================");
        System.out.println("Elige una opción:");
        System.out.println("1 - Volver atrás");
        System.out.println("0 - Volver atrás");
    }
}
