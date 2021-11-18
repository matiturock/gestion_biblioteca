package view;

import java.util.Scanner;

import operations.IOperacion;
import operations.OperacionBiblioteca;
import utils.Generador;

/**
 * Vista de interfaz de consola de cara al usuario final Conecta las opciones
 * de usuario con las Operaciones
 */

public class AppBiblioteca {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1;

        IOperacion operacion = new OperacionBiblioteca();

        while (opcion != 0) {
            System.out.println("SISTEMA GESTION DE BIBLIOTECA");
            System.out.println("=============================");
            System.out.println("1- Iniciar archivo");
            System.out.println("2- Listar libros");
            System.out.println("3- Agregar libro");
            System.out.println("4- Buscar libro");
            System.out.println("0- Salir");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch(opcion){
                    case 1:
                        operacion.iniciarArchivo();
                        System.out.println("Archivo creado");
                        break;
                    case 2:
                        System.out.println("LISTADO DE LIBROS");
                        operacion.listarLibros();
                        break;
                    case 3:
                        System.out.println("Agregando libro:");
                        String atributosLibro = crearLibroDesdeInputUsuario(scanner);
                        operacion.agregarLibro(atributosLibro);
                        break;
                    case 4:
                        System.out.println("Buscando libro... ");
                        System.out.println("Ingrese el titulo del libro:");
                        String busquedaLibro = scanner.nextLine();
                        operacion.buscarLibro(busquedaLibro);
                        break;
                    case 0:
                        System.out.println("Saliendo del menu de libros");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un valor válido");
                opcion = -1;
            }

        }

        System.out.println("Saliendo del sistema");
        scanner.close();
    }

    private static String crearLibroDesdeInputUsuario(Scanner scanner) {
    }
}
