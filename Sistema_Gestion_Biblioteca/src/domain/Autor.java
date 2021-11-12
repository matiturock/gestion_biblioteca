package domain;

import java.time.LocalDate;

public class Autor extends Persona {
    private Genero genero;
    private LocalDate fechaFallecimiento;
    private String nacionalidad;

    public Autor(String nombre, LocalDate fechaNacimiento, Genero genero, LocalDate fechaFallecimiento,
            String nacionalidad) {
        super(nombre, fechaNacimiento);
        this.genero = genero;
        this.fechaFallecimiento = fechaFallecimiento;
        this.nacionalidad = nacionalidad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor [fechaFallecimiento=" + fechaFallecimiento + ", genero=" + genero + ", nacionalidad="
                + nacionalidad + "]";
    }

}
