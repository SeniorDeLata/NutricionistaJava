
package nutricionistag23.entidades;

import java.util.ArrayList;
import java.util.List;



public class DietaComida {

    private int id;
    private Comida comida;
    private Dieta dieta;
    private HorariosEnum horario;
    private DiasEnum dia;
    private boolean estado;

    public DietaComida(Comida comida, Dieta dieta, HorariosEnum horario, DiasEnum dia,boolean estado) {
        this.comida = comida;
        this.dieta = dieta;
        this.horario = horario;
        this.dia = dia;
        this.estado=estado;
    }

    public DietaComida(int id, Comida comida, Dieta dieta, HorariosEnum horario, DiasEnum dia, boolean estado) {
        this.id = id;
        this.comida = comida;
        this.dieta = dieta;
        this.horario = horario;
        this.dia = dia;
        this.estado=estado;
    }
    
    public DietaComida() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HorariosEnum getHorario() {
        return horario;
    }

    public void setHorario(HorariosEnum horario) {
        this.horario = horario;
    }

    public DiasEnum getDia() {
        return dia;
    }

    public void setDia(DiasEnum dia) {
        this.dia = dia;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return comida.toString();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    


}
