package utils;

import java.time.LocalDate;
import java.util.Scanner;

import domain.libro.CopiaLibro;
import domain.libro.EstadoLibro;
import domain.libro.Genero;
import domain.persona.Autor;
import operations.IOperacion;
import operations.OperacionBiblioteca;

public class Generador {

    /**
     * crea un objeto de tipo CopiaLibro en base a un String con sus atributos
     * 
     * @param String con atributosLibro
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

        var copiaLibro = new CopiaLibro(titulo, genero, autor, cantidad, estadoLibro);
        return copiaLibro;
    }

    /**
     * crea un objeto de tipo Autor en basea un string con sus atributos
     * 
     * @param atributosAutor
     * @return
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

        var autor = new Autor(nombre, fechaNacimiento, fechaFallecimiento, paisOrigen);
        return autor;
    }

    /**
     * crea una copia de libro, para agregar a la base de datos, en base a inputs
     * del ususario
     * 
     * @return
     */
    public static String crearCopiaLibro(Scanner scanner, IOperacion operacion) {
        return null;
    }

}
