package operations;

import data.AccesoDatosArchivo;
import data.IAccesoDatos;
import domain.libro.CopiaLibro;
import utils.Generador;

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
    public void agregarCopiaLibro(String atributosLibro) {
        CopiaLibro copiaLibro = Generador.instanciarCopiaLibro(atributosLibro);
        boolean anexar = false;

        anexar = this.datos.existe(NOMBRE_RECURSO);
        datos.escribir(copiaLibro, anexar, NOMBRE_RECURSO);

    }

    @Override
    public void listarLibros() {
        var listadoLibros = this.datos.listaCopiaLibros(NOMBRE_RECURSO);
        for (CopiaLibro libro : listadoLibros) {
            System.out.println(libro);
        }
    }

    @Override
    public void buscarPelicula(String tituloLibro) {
        String resultado = null;
        resultado = this.datos.buscar(NOMBRE_RECURSO, tituloLibro);

        if (resultado != null)
            System.out.println(resultado);
        else
            System.out.println("Libro no encontrado");
    }

}
