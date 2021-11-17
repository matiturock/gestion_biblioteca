package utils;

import java.time.LocalDate;

import domain.libro.CopiaLibro;
import domain.libro.EstadoLibro;
import domain.libro.Genero;
import domain.persona.Autor;

public class Generador {

    public static CopiaLibro instanciarCopiaLibro(String atributosLibro) {
        String[] atributosLibroArr = atributosLibro.split(",");
        String titulo = atributosLibroArr[0];
        Genero genero = Genero.valueOf(atributosLibroArr[1]);
        Autor autor = instanciarAutor(atributosLibroArr[2]);
        Integer cantidad = Integer.parseInt(atributosLibroArr[3]);
        EstadoLibro estadoLibro = EstadoLibro.valueOf(atributosLibroArr[4]);

        var copiaLibro = new CopiaLibro(titulo, genero, autor, cantidad, estadoLibro);
        return copiaLibro;
    }

    public static Autor instanciarAutor(String atributosAutor) {
        String[] atributosAutorArr = atributosAutor.split(";");
        String nombre = atributosAutorArr[0];
        LocalDate fechaNacimiento = LocalDate.parse(atributosAutorArr[1]);
        LocalDate fechaFallecimiento = LocalDate.parse(atributosAutorArr[2]);
        String paisOrigen = atributosAutorArr[3];

        var autor = new Autor(nombre, fechaNacimiento, fechaFallecimiento, paisOrigen);
        return autor;
    }

}
