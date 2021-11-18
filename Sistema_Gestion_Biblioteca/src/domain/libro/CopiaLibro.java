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

    public static class Builder {

        private Integer cantidad;
        private EstadoLibro estadoLibro;
        private String titulo;
        private Genero genero;
        private Autor autor;

        public Builder conTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder conCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder conEstadoLibro(EstadoLibro estadoLibro) {
            this.estadoLibro = estadoLibro;
            return this;
        }

        public Builder conGenero(Genero genero) {
            this.genero = genero;
            return this;
        }

        public Builder conAutor(Autor autor) {
            this.autor = autor;
            return this;
        }


        public CopiaLibro build(){
            return new CopiaLibro(titulo, genero, autor, cantidad, estadoLibro);
        }
    }
}
