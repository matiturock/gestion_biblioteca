package operations;

public interface IOperacion {
    String NOMBRE_RECURSO = "libros.txt";

    void iniciarArchivo();

    void agregarCopiaLibro(String atributosLibro);

    void listarLibros();

    void buscarPelicula(String tituloLibro);
}
