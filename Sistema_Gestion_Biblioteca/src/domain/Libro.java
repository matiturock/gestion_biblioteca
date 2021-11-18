package domain;

public class Libro {
    private String titulo;
    private Genero genero;
    private String autor;
    private int cantidadEnBiblioteca;
    private int cantidadPrestados;
    private int totalCopias;

    public Libro(String titulo, Genero genero, String autor, int cantidadEnBiblioteca, int cantidadPrestados,
            int totalCopias) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
        this.cantidadPrestados = cantidadPrestados;
        this.totalCopias = totalCopias;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadEnBiblioteca() {
        return this.cantidadEnBiblioteca;
    }

    public void setCantidadEnBiblioteca(int cantidadEnBiblioteca) {
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
    }

    public int getCantidadPrestados() {
        return this.cantidadPrestados;
    }

    public void setCantidadPrestados(int cantidadPrestados) {
        this.cantidadPrestados = cantidadPrestados;
    }

    public int getTotalCopias() {
        return this.totalCopias;
    }

    public void setTotalCopias(int totalCopias) {
        this.totalCopias = totalCopias;
    }

    public void mostrarInformacion() {
        System.out.println("TITULO:     " + this.getTitulo());
        System.out.println("- Genero:   " + this.getGenero());
        System.out.println("- Autor:    " + this.getAutor());
        System.out.println("- Copias totales:       " + this.getTotalCopias());
        System.out.println("  * En biblioteca:      " + this.getCantidadEnBiblioteca());
        System.out.println("  * Prestado:           " + this.getCantidadEnBiblioteca());
    }
}
