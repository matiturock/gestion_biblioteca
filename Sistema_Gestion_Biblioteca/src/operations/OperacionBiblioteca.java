package operations;

import java.util.List;

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
        List<Libro> libros = this.datos.listarLibros(NOMBRE_RECURSO);

        if (libros.size() != 0) {
            for (Libro libro : libros) {
                libro.mostrarInformacion();
            }
        } else {
            System.out.println("No hay libros registrados en el archivo");
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

    @Override
    public void prestarLibro(String titulo) {
        boolean encontrado = false;
        List<Libro> libros = this.datos.listarLibros(NOMBRE_RECURSO);
        for (Libro libro: libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                if (libro.getCantidadEnBiblioteca()>1){
                    System.out.println("Libro prestado");
                    libro.setCantidadEnBiblioteca(libro.getCantidadEnBiblioteca()-1);
                    libro.setCantidadPrestados(libro.getCantidadPrestados()+1);
                    libro.mostrarInformacion();
                    this.datos.borrarBase(NOMBRE_RECURSO);
                    this.datos.crearBase(NOMBRE_RECURSO);
                    for (Libro lib:libros) {
                        datos.escribir(lib, true, NOMBRE_RECURSO);
                    }
                    break;
                } else {
                    System.out.println("No hay para prestar");
                }
            }
        }
        if (!encontrado){
            System.out.println("No se encontro el libro");
        }
    }

}
