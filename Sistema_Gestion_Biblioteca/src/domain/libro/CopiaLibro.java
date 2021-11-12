package domain.libro;

import domain.Genero;
import domain.persona.Autor;

public class CopiaLibro extends Libro {
    private Integer idCopia;
    private EstadoLibro estadoLibro;

    public CopiaLibro(String titulo, Genero genero, Autor autor, Integer idCopia, EstadoLibro estadoLibro) {
        super(titulo, genero, autor);
        this.idCopia = idCopia;
        this.estadoLibro = estadoLibro;
    }

    public Integer getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(Integer idCopia) {
        this.idCopia = idCopia;
    }

    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(EstadoLibro estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    @Override
    public String toString() {
        return "CopiaLibro [estadoLibro=" + estadoLibro + ", idCopia=" + idCopia + "]";
    }

}
