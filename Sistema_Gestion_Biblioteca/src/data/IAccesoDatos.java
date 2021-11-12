package data;

import java.util.List;

import domain.libro.CopiaLibro;

public interface IAccesoDatos {
    void crearBase(String nombreRecurso);

    void borrarBase(String nombreRecurso);

    boolean existe(String nombreRecurso);

    List<CopiaLibro> listaCopiaLibros(String nombreRecurso);

    void escribir(CopiaLibro copiaLibro, Boolean anexar, String nombreRecurso);

    void actualizar(CopiaLibro copiaLibro, String nombreRecurso);

    void borrar(CopiaLibro copiaLibro, String nombreRecurso);

    String buscar(String nombreRecurso, String buscar);

}
