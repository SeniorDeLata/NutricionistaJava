package nutricionistag23.entidades;

import java.util.Objects;

public class Comida {

    private String nombre;
    private String detalle;
    private int cantCalorias;
    private int idComida;
    private boolean estado;

    public Comida() {
    }

    public Comida(String nombre, String detalle, int cantCalorias,boolean estado) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.estado=estado;
    }

    public Comida(String nombre, String detalle, int cantCalorias, int idComida,boolean estado) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.idComida = idComida;
        this.estado=estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.detalle);
        hash = 17 * hash + this.cantCalorias;
        hash = 17 * hash + this.idComida;
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
        final Comida other = (Comida) obj;
        if (this.cantCalorias != other.cantCalorias) {
            return false;
        }
        if (this.idComida != other.idComida) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.detalle, other.detalle)) {
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    @Override
    public String toString() {
        return nombre; 
    }

    
    
    
    
}
