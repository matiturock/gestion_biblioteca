package domain.persona;

import java.time.LocalDate;

public class Autor extends Persona {
    private LocalDate fechaFallecimiento;
    private String paisOrigen;

    public Autor(String nombre, LocalDate fechaNacimiento, LocalDate fechaFallecimiento, String paisOrigen) {
        super(nombre, fechaNacimiento);
        this.fechaFallecimiento = fechaFallecimiento;
        this.paisOrigen = paisOrigen;
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getNacionalidad() {
        return paisOrigen;
    }

    public void setNacionalidad(String nacionalidad) {
        this.paisOrigen = nacionalidad;
    }

    @Override
    public String toString() {
        return super.getNombre() + ";" + this.getFechaNacimiento() + ";" + this.getFechaFallecimiento() + ";"
                + this.getNacionalidad();
    }

}
