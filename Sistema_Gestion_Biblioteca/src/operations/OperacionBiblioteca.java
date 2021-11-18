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
        var listadoLibros = this.datos.listaLibros(NOMBRE_RECURSO);
        for (Libro libro : listadoLibros) {
            System.out.println(libro);
        }
    }

    @Override
    public void buscarLibro(String tituloLibro) {
        String resultado = null;
        resultado = this.datos.buscar(NOMBRE_RECURSO, tituloLibro);

        if (resultado != null)
            System.out.println(resultado);
        else
            System.out.println("Libro no encontrado");
    }

}
