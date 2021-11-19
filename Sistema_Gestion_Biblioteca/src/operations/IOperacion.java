package operations;

public interface IOperacion {
    String NOMBRE_RECURSO = "libros.txt";

    void iniciarArchivo();

    void agregarLibro(String atributosLibro);

    void listarLibros();

    void buscarLibro(String tituloLibro);

    void prestarLibro(String titulo);
}
