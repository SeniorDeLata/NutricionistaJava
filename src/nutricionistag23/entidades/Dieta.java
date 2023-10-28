
package nutricionistag23.entidades;

import java.time.LocalDate;
import java.util.Objects;



public class Dieta {
    
    private int idDieta;
    private String nombre;
    private Paciente paciente;
    private LocalDate fechaInicial;
    private double pesoInicial;
    private double pesoFinal;
    private LocalDate fechaFinal;
    private boolean estado;

    public Dieta(int idDieta, String nombre, Paciente paciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estado=estado;
    }

    public Dieta() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idDieta;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.paciente);
        hash = 71 * hash + Objects.hashCode(this.fechaInicial);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pesoInicial) ^ (Double.doubleToLongBits(this.pesoInicial) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pesoFinal) ^ (Double.doubleToLongBits(this.pesoFinal) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.fechaFinal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dieta other = (Dieta) obj;
        if (this.idDieta != other.idDieta) {
            return false;
        }
        if (Double.doubleToLongBits(this.pesoInicial) != Double.doubleToLongBits(other.pesoInicial)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pesoFinal) != Double.doubleToLongBits(other.pesoFinal)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicial, other.fechaInicial)) {
            return false;
        }
        if (!Objects.equals(this.fechaFinal, other.fechaFinal)) {
            return false;
        }
        return true;
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal,boolean estado) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estado=estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    



}
