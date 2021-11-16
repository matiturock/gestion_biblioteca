package domain.persona;

import java.time.LocalDate;

import domain.libro.CopiaLibro;

public class Lector extends Persona {
    private EstadoLector EstadoLector;

    public Lector(String nombre, LocalDate fechaNacimiento, domain.persona.EstadoLector estadoLector) {
        super(nombre, fechaNacimiento);
        EstadoLector = estadoLector;
    }

    public EstadoLector getEstadoLector() {
        return EstadoLector;
    }

    public void setEstadoLector(EstadoLector estadoLector) {
        EstadoLector = estadoLector;
    }

    @Override
    public String toString() {
        return "Lector [EstadoLector=" + EstadoLector + "]";
    }

    public void reservarLibro(CopiaLibro libro) {

    }

    public void devolverLibro(CopiaLibro libro) {

    }

}
