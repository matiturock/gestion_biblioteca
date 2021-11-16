package domain.persona;

import java.time.LocalDate;

public class Autor extends Persona {
    private LocalDate fechaFallecimiento;
    private String nacionalidad;

    public Autor(String nombre, LocalDate fechaNacimiento, LocalDate fechaFallecimiento, String nacionalidad) {
        super(nombre, fechaNacimiento);
        this.fechaFallecimiento = fechaFallecimiento;
        this.nacionalidad = nacionalidad;
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
        return super.getNombre() + "-" + this.getFechaNacimiento() + "-" + this.getFechaFallecimiento();
    }

}
