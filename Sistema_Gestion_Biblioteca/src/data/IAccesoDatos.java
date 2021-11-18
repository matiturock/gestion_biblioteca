package data;

import domain.Libro;

import java.util.List;

public interface IAccesoDatos {
    void crearBase(String nombreRecurso);

    void borrarBase(String nombreRecurso);

    boolean existe(String nombreRecurso);

    List<Libro> listarLibros(String nombreRecurso);

    void escribir(Libro libro, Boolean anexar, String nombreRecurso);

    Libro buscarLibro(String nombreRecurso, String buscar);

}
