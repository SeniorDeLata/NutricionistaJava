/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionistag23.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author paulo
 */
public class Historial {
    private int idHistorial;
    private Paciente paciente;
    private double peso;
    private LocalDate fechaRegistro;
    private boolean estado;

    public Historial() {
    }

    public Historial(int idHistorial, Paciente paciente, double peso, LocalDate fechaRegistro,boolean estado) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.peso = validarPeso(peso);
        this.fechaRegistro = fechaRegistro;
        this.estado=estado;
    }

    public Historial(Paciente paciente, double peso, LocalDate fechaRegistro,boolean estado) {
        this.paciente = paciente;
        this.peso = validarPeso(peso);
        this.fechaRegistro = fechaRegistro;
        this.estado=estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = validarPeso(peso);
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Historial{" + "paciente=" + paciente + ", peso=" + peso + ", fechaRegistro=" + fechaRegistro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idHistorial;
        hash = 17 * hash + Objects.hashCode(this.paciente);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.fechaRegistro);
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
        final Historial other = (Historial) obj;
        if (this.idHistorial != other.idHistorial) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        return true;
    }
    private double validarPeso(double peso) {
        peso *=100;
        peso = (int) peso;
        peso /=100;
        return peso;
    }
    
}
