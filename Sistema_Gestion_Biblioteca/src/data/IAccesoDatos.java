package data;

import domain.Libro;

import java.util.List;

public interface IAccesoDatos {
    void crearBase(String nombreRecurso);

    void borrarBase(String nombreRecurso);

    boolean existe(String nombreRecurso);

    List<Libro> listaLibros(String nombreRecurso);

    void escribir(Libro libro, Boolean anexar, String nombreRecurso);

    void borrar(Libro libro, String nombreRecurso);

    String buscar(String nombreRecurso, String buscar);

}
