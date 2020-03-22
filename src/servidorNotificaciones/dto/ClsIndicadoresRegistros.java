/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorNotificaciones.dto;

import java.io.Serializable;

/**
 *
 * @author Lino Alejandro Munoz
 */
public class ClsIndicadoresRegistros implements Serializable{
    private String numHabitacion, nombre, apellidos,  fecha, hora, puntuacion;

    public ClsIndicadoresRegistros(){
    }

    public ClsIndicadoresRegistros(String numHabitacion, String nombre, String apellidos, String fecha, String hora, String puntuacion) {
        this.numHabitacion = numHabitacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.hora = hora;
        this.puntuacion = puntuacion;
    }

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
    
}
