/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author guest
 */
public class test {
    public static void main(String[] args){
        
        String fechaNacimiento = "08/12/2021";
        String[] fechaIngresada = fechaNacimiento.split("/");
        int dia = Integer.parseInt(fechaIngresada[0]);
        int mes = Integer.parseInt(fechaIngresada[1]);
        int anio = Integer.parseInt(fechaIngresada[2]);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String[] fechaActual = dtf.format(now).toString().split("/");
        int diaActual = Integer.parseInt(fechaActual[0]);
        int mesActual = Integer.parseInt(fechaActual[1]);
        int anioActual = Integer.parseInt(fechaActual[2]);
        
        int edad = (anioActual - anio);
        if (mesActual - mes <= 0) {
            edad--;
        }
        
        System.out.println(edad);  
        
        if (validarAnio("08/12/2021")) {
            System.out.println("Valido");
        }else{
            System.out.println("Inválido");
        }
        
    }
    
    
    public static boolean validarAnio(String fecha){
        String[] fechaIngresada = fecha.split("/");
        int anio = Integer.parseInt(fechaIngresada[2]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String[] fechaActual = dtf.format(now).toString().split("/");
        int anioActual = Integer.parseInt(fechaActual[2]);
        
        System.out.println(anioActual);
        
        return anioActual>anio;
    }
}
