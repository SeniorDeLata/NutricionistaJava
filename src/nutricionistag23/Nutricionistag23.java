

package nutricionistag23;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import nutricionistag23.accesoADatos.ComidaData;
import nutricionistag23.accesoADatos.DietaComidaData;
import nutricionistag23.accesoADatos.DietaData;
import nutricionistag23.accesoADatos.HistorialData;
import nutricionistag23.accesoADatos.PacienteData;
import nutricionistag23.entidades.Comida;
import nutricionistag23.entidades.DiasEnum;
import nutricionistag23.entidades.Dieta;
import nutricionistag23.entidades.DietaComida;
import nutricionistag23.entidades.Historial;
import nutricionistag23.entidades.HorariosEnum;
import nutricionistag23.entidades.Paciente;
import nutricionistag23.vistas.DietaVista;


public class Nutricionistag23 {


    public static void main(String[] args) {
        
        PacienteData pData= new PacienteData();
        ComidaData cData= new ComidaData();
        DietaData dData = new DietaData();
        DietaComidaData dcData = new DietaComidaData();
        HistorialData hData = new HistorialData();
        //pData.guardarPaciente(new Paciente("Marcos", 78912348,"alemania 987", "381-9789789", 75, 90, 1.55));
        /*pData.guardarPaciente(new Paciente("Marcos", 12345688,"Tucuman 654", "381-2351563", 70, 72, 1.65));
        pData.guardarPaciente(new Paciente("Carina", 12345689,"Paris 123", "381-9234561", 80, 55, 1.55));
        System.out.println(pData.buscarPaciente(12345678));*/
        //System.out.println(pData.listaPaciente());
        //Paciente paciente= pData.buscarPaciente(12345678);
        //paciente.setPesoActual(50);
        //pData.modificarPaciente(paciente);
        
        //cData.guardaComida(new Comida("Merluza", "filet de merluza de 400 gr", 200));
        //cData.guardaComida(new Comida("Huevos", " 2 Huevos hervidos 6'", 120));
        //cData.borrarComida(1);
        //cData.modificarComida(new Comida("Merluza", "filet de merluza de 400 gr", 400,2));
        //System.out.println( cData.buscarComida(2));
        //System.out.println(cData.listaComida());
        
        //dData.guardarDieta(new Dieta("Ketopasada", pData.buscarPacienteXId(2), LocalDate.of(2023, 8, 25), 100.5, 95.8, LocalDate.of(2023, 8, 30)));
        //System.out.println(dData.buscarDieta(1));
        //dData.modificarDieta(new Dieta(1, "Keto", pData.buscarPacienteXId(2), LocalDate.of(2023, 8, 25), 99, 95.8, LocalDate.of(2023, 8, 30)));
        //System.out.println(dData.listaDieta());
        //dData.borrarDieta(1);
        //dcData.guardarDietaComida(new DietaComida(cData.buscarComida(1), dData.buscarDieta(2), HorariosEnum.CENA, DiasEnum.LUNES));
        
        //System.out.println(dcData.listarDietaComidaXDia(2,"LUNES"));
        //Historial historial = new Historial(pData.buscarPacienteXId(1), 99, LocalDate.now());
        //hData.guardarHistorial(historial);
        //hData.modificarHistorial(new Historial(1,pData.buscarPacienteXId(1), 98, LocalDate.now()));
        //System.out.println(hData.listaHistorial(1));
        //System.out.println(hData.buscarHistorialXId(1));
                DietaComidaData dcd = new DietaComidaData();
        List<DietaComida> lunes = dcd.listarDietaComidaXDieta(2);
        for(DietaComida comida:lunes){
            System.out.println(comida.getId());
        }
        
    }
    


}
