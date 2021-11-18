package utils;

import java.util.Scanner;

import domain.Genero;
import domain.Libro;

public class Constructor {

    public static Libro instanciarLibro(String atributosLibro) {
        String[] atributosLibroArr = atributosLibro.split(",");

        String titulo = atributosLibroArr[0];
        Genero genero = Genero.valueOf(atributosLibroArr[1]);
        String autor = atributosLibroArr[2];
        Integer cantidadCopias = Integer.parseInt(atributosLibroArr[3]);

        var libro = new Libro(titulo, genero, autor, cantidadCopias);

        return libro;
    }

    public static Libro crearLibroDesdeInputUsuario(Scanner scanner) {
        System.out.println("Ingresa los datos de libro:");

        System.out.println("Ingresa el título:");
        String titulo = scanner.nextLine();

        System.out.println("Elige el género");
        Genero[] generos = Genero.values();
        Integer indice = 1;

        for (Genero genero : generos) {
            System.out.print(String.format("%d - %s | ", indice, genero.toString()));
            indice++;
        }
        System.out.println();

        Integer seleccionUsuario = Integer.parseInt(scanner.nextLine());
        Genero genero = generos[seleccionUsuario];

        System.out.println("Ingresa el nombre del autor:");
        String autor = scanner.nextLine();

        System.out.println("Ingrese la cantidad de copias:");
        int cantidadCopias = Integer.parseInt(scanner.nextLine());

        Libro libro = new Libro(titulo, genero, autor, cantidadCopias);

        return libro;
    }

}
