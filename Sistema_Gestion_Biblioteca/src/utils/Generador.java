package utils;

import java.time.LocalDate;

import domain.libro.CopiaLibro;
import domain.persona.Autor;

public class Generador {

    public static CopiaLibro instanciarCopiaLibro(String atributosLibro) {
        String[] atributosArr = atributosLibro.split(",");
        String nombre = atributosArr[0];
        LocalDate fechaNacimiento = LocalDate.parse(atributosArr[1]);
        LocalDate fechaFallecimiento = LocalDate.parse(atributosArr[2]);
        String nacionalidad = atributosArr[3];
        return null;
    }

    public static Autor instanciarAutor(String string) {
        String[] atributosAutor = string.split("-");
        var autor = new Autor(atributosAutor[0], LocalDate.parse(atributosAutor[1]), LocalDate.parse(atributosAutor[2]),
                atributosAutor[3]);
        return autor;
    }

}
