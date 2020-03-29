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
        /*
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
        
        if (validarAnio("08/12/2020")) {
            System.out.println("Valido");
        }*/
        
        
        
        
        
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
        String mysqlDate = formatter.format(now);
        String dateNow = formatter.format(now);
        System.out.println("Java's Default Date Format: " + dateNow);
        System.out.println("Mysql's Default Date Format: " + mysqlDateString);
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
