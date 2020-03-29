/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paciente;

/**
 *
 * @author guest
 */
public class Paciente {

    private int numHabitacion;
    private String nombres;
    private String apellidos;
    private String fechaNac;

    public Paciente(){}
    public Paciente(int numHabitacion, String nombres, String apellidos, String fechaNac) {
        this.numHabitacion = numHabitacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
   
   
   
    
    
}
