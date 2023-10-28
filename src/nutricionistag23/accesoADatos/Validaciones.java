/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionistag23.accesoADatos;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;

/**
 *
 * @author jonac
 */
public class Validaciones {

    /**
     *
     * @param cadena Cadena de texto de un TextField
     * @param tipo Entero para identificar si se trata de un numero o
     * caracteres, 1= Numeros, 2= Cadena Texto
     * @return Boolean
     */

    public static boolean validacionInmediataCaracteres(String cadena, int tipo) {

        char caracter;
        String cadenaMin;
        boolean log = true;
        int count = 0;
        switch (tipo) {
            case 1:
                for (int i = 0; i < cadena.length(); i++) {
                    caracter = cadena.charAt(i);
                    if (!(caracter > 47 && caracter < 58)) {
                        log = false;
                        break;
                    }
                }
                break;
            case 2:
                cadenaMin = cadena.toLowerCase();
                for (int i = 0; i < cadenaMin.length(); i++) {
                    caracter = cadenaMin.charAt(i);
                    if (!(caracter > 96 && caracter < 123) && caracter != 32) {
                        log = false;
                        break;
                    }
                    if (i == 0 && caracter == 32) {
                        log = false;
                        break;
                    }
                }
                break;
        }
        return log;
    }

    public static boolean validacionTelefono (String cadena){
        char caracter;
        String cadenaMin;
        boolean log = true;
        for (int i = 0; i < cadena.length(); i++) {
                    caracter = cadena.charAt(i);
                    if (!(caracter > 47 && caracter < 58) && caracter != 45) {
                        log = false;
                        break;
                    }
         }
        if(!log){
            JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono valido (XXX-XXXXXXX)");
        }
        return log;
    }
    
    
    //VALIDACIONES DE LA VENTANA PACIENTE
    public static boolean validacionTelefonoGuion(String tel){
        try{
        if(tel.charAt(3)== '-' || tel.charAt(4)=='-'){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "El Número de telefono ingresado es invalido");
            return false;
        }
        }catch(IndexOutOfBoundsException iob){
            JOptionPane.showMessageDialog(null, "El Número de telefono ingresado es invalido");
            return false;
        }
    }
    
    
    public static boolean validacionDNI(String dni) {
        if (dni.length() > 6 && dni.length() < 10) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El DNI ingresado es invalido");
            return false;
        }
    }

    public static boolean validacionNombrePaciente(String nombre) {
        if (nombre.length() > 2 && nombre.length() < 100 && !nombre.contains("  ")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El nombre ingresado es invalido");
            return false;
        }
    }

        public static boolean validacionDomicilio(String domicilio) {
        if (domicilio.length() > 2 && domicilio.length() < 100 && !domicilio.contains("  ")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El domicilio ingresado es invalido");
            return false;
        }
    }
        
    public static boolean validacionPeso (double peso){
        
        if (peso == 0){
            JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a 0");
            return false;
        }
        return true;
        
    }
    
    //VALIDACIONES DE LA VENTANA HISTORIAL
    
    public static boolean validacionInmediataFecha(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().compareTo(LocalDate.now()) <= 0;
    }
    
   //Validaciones Ventana Comida
    public static boolean validacionNombreComida(String nombre) {
        if (nombre.length() > 2 && nombre.length() < 30 && !nombre.contains("  ")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El nombre ingresado es invalido");
            return false;
        }
    }
    public static boolean validacionDetalleComida(String nombre) {
        if (nombre.length() > 2 && nombre.length() < 100 && !nombre.contains("  ")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El detalle ingresado es invalido");
            return false;
        }
    }
    public static boolean validacionCalorias (int caloria){
        
        if (caloria == 0){
            JOptionPane.showMessageDialog(null, "Ingrese un valor entre 0 y 9999");
            return false;
        }
        return true;
        
    }
    public static boolean validacionFechaInicial (LocalDate fecha){
        if(fecha.compareTo(LocalDate.now())<=0){// 0 si son iguales, -1 cuando el segundo es mayor que lo primero, 1 si lo segundo es menor a lo primero
            return true;
        }
        JOptionPane.showMessageDialog(null, "La fecha inicial no puede ser mayor al dia corriente");
        return false;
    }
    
    public static boolean validacionFechaFinal (Date fechaI, Date fechaF){
        if(fechaI.compareTo(fechaF)==-1){// 0 si son iguales, -1 cuando el segundo es mayor que lo primero, 1 si lo segundo es menor a lo primero
            return true;
        }
        JOptionPane.showMessageDialog(null, "La fecha final debe ser posterior a la fecha inicial");
        return false;
    }
         
}
