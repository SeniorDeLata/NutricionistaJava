package nutricionistag23.entidades;

import java.util.Objects;

public class Paciente {

    private String nombre;
    private int dni;
    private String domicilio;
    private String telefono;
    private int idPaciente;
    private double pesoActual;
    private double pesoDeseado;
    private double estatura;
    private boolean estado;
    

    public Paciente(String nombre, int dni, String domicilio, String telefono, int idPaciente,boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.idPaciente = idPaciente;
        this.estado=estado;
    }

    public Paciente() {
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono,boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado=estado;
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono, double pesoActual, double pesoDeseado, double estatura, int idPaciente, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.pesoActual = validarDouble(pesoActual);
        this.pesoDeseado = validarDouble(pesoDeseado);
        this.estatura = validarDouble(estatura);
        this.idPaciente = idPaciente;
        this.estado=estado;
        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = validarDouble(pesoActual);
    }

    public double getPesoDeseado() {
        return pesoDeseado;
    }

    public void setPesoDeseado(double pesoDeseado) {
        this.pesoDeseado = validarDouble(pesoDeseado);
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = validarDouble(estatura);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + this.dni;
        hash = 37 * hash + Objects.hashCode(this.domicilio);
        hash = 37 * hash + Objects.hashCode(this.telefono);
        hash = 37 * hash + this.idPaciente;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.pesoActual) ^ (Double.doubleToLongBits(this.pesoActual) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.pesoDeseado) ^ (Double.doubleToLongBits(this.pesoDeseado) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.estatura) ^ (Double.doubleToLongBits(this.estatura) >>> 32));
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
        final Paciente other = (Paciente) obj;
        if (this.dni != other.dni) {
            return false;
        }
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        if (Double.doubleToLongBits(this.pesoActual) != Double.doubleToLongBits(other.pesoActual)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pesoDeseado) != Double.doubleToLongBits(other.pesoDeseado)) {
            return false;
        }
        if (Double.doubleToLongBits(this.estatura) != Double.doubleToLongBits(other.estatura)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.domicilio, other.domicilio)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return nombre;
    }
    private double validarDouble(double peso) {
        peso *=100;
        peso = (int) peso;
        peso /=100;
        return peso;
    }
    
}
