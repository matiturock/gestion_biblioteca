package data;

import domain.libro.CopiaLibro;

import java.util.List;

public interface IAccesoDatos {
    void crearBase(String nombreRecurso);

    void borrarBase(String nombreRecurso);

    boolean existe(String nombreRecurso);

    List<CopiaLibro> listaCopiaLibros(String nombreRecurso);

    void escribir(CopiaLibro copiaLibro, Boolean anexar, String nombreRecurso);

    void borrar(CopiaLibro copiaLibro, String nombreRecurso);

    String buscar(String nombreRecurso, String buscar);

}
