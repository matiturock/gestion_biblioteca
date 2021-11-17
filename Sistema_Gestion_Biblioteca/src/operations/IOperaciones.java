package operations;

public interface IOperaciones {
    String NOMBRE_RECURSO = "libros.txt";

    void iniciarArchivo();

    void agregarLibro(String atributosLibro);

    void listarLibros();

    void buscarPelicula(String tituloLibro);
}
