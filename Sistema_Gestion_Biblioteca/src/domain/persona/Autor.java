package domain.persona;

import domain.libro.CopiaLibro;
import domain.libro.EstadoLibro;
import domain.libro.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public static class Builder {

        private LocalDate fechaFallecimiento;
        private String paisOrigen;
        private String nombre;
        private LocalDate fechaNacimiento;

        public Builder conFechaNacimiento(String fechaNacimiento) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
            return this;
        }

        public Builder conFechaFallecimiento(String fechaFallecimiento) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaFallecimiento = LocalDate.parse(fechaFallecimiento, formatter);
            return this;
        }

        public Builder conPaisOrigen(String paisOrigen) {
            this.paisOrigen = paisOrigen;
            return this;
        }

        public Builder conNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Autor build(){
            return new Autor(nombre, fechaNacimiento, fechaFallecimiento, paisOrigen);
        }
    }
}
