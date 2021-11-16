package operations;

import data.AccesoDatosArchivo;
import data.IAccesoDatos;
import domain.libro.CopiaLibro;
import utils.Generador;

public class OperacionesBiblioteca implements IOperacionesBiblioteca {
    private final IAccesoDatos datos;

    public OperacionesBiblioteca() {
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
        CopiaLibro copiaLibro = Generador.instanciarCopiaLibro(atributosLibro);
        boolean anexar = false;

        anexar = this.datos.existe(NOMBRE_RECURSO);
        datos.escribir(copiaLibro, anexar, NOMBRE_RECURSO);

    }

    @Override
    public void listarLibros() {
        // TODO Auto-generated method stub

    }

    @Override
    public void buscarPelicula(String tituloLibro) {
        // TODO Auto-generated method stub

    }

}
