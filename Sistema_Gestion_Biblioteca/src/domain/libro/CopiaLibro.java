package domain.libro;

import domain.persona.Autor;

public class CopiaLibro extends Libro {
    private Integer cantidad;
    private EstadoLibro estadoLibro;

    public CopiaLibro(String titulo, Genero genero, Autor autor, Integer cantidad, EstadoLibro estadoLibro) {
        super(titulo, genero, autor);
        this.cantidad = cantidad;
        this.estadoLibro = estadoLibro;
    }

    public Integer getIdCopia() {
        return cantidad;
    }

    public void setIdCopia(Integer idCopia) {
        this.cantidad = idCopia;
    }

    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(EstadoLibro estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    @Override
    public String toString() {
        return super.getTitulo() + "," + super.getGenero() + "," + super.getAutor() + "," + this.getIdCopia() + ","
                + this.getEstadoLibro();
    }

}
