package operations;

import data.AccesoDatosArchivo;
import data.IAccesoDatos;
import domain.Libro;
import utils.Constructor;

/**
 * capa intermedia entre data y view
 */
public class OperacionBiblioteca implements IOperacion {
    private final IAccesoDatos datos;

    public OperacionBiblioteca() {
        this.datos = new AccesoDatosArchivo();
    }

    @Override
    public void iniciarArchivo() {
        if (this.datos.existe(NOMBRE_RECURSO)) {
            datos.borrarBase(NOMBRE_RECURSO);
            datos.crearBase(NOMBRE_RECURSO);
        } else
            datos.crearBase(NOMBRE_RECURSO);
    }

    @Override
    public void agregarLibro(String atributosLibro) {
        Libro libro = Constructor.instanciarLibro(atributosLibro);
        boolean anexar = false;

        anexar = this.datos.existe(NOMBRE_RECURSO);
        datos.escribir(libro, anexar, NOMBRE_RECURSO);

    }

    @Override
    public void listarLibros() {
        var libros = this.datos.listarLibros(NOMBRE_RECURSO);
        for (Libro libro : libros) {
            libro.mostrarInformacion();
        }
    }

    @Override
    public void buscarLibro(String tituloLibro) {
        Libro resultadoLibro = null;
        resultadoLibro = this.datos.buscarLibro(NOMBRE_RECURSO, tituloLibro);

        if (resultadoLibro != null) {
            System.out.println("Libro encontrado");
            resultadoLibro.mostrarInformacion();
        } else
            System.out.println("Libro no encontrado");
    }

}
