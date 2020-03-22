/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorNotificaciones.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lino Alejandro Munoz
 */
public class ClsNotificacionDTO implements Serializable {

    /*Esta clase debe contener todo el cuerpo de la las notificaciones, todo en un objeto*/
    private int numeroHabitacion;
    private float edad;
    private String nombres, apellidos, estrato, mensajeAlMedico;
    private String fecha, hora;
    private ArrayList<ClsIndicadoresAlerta> listaIndicadoresAlerta = new ArrayList<>();
    private ArrayList<ClsIndicadoresRegistros> listaIndicadoresRegistros = new ArrayList<>();

    public ClsNotificacionDTO() {
    }

    public ClsNotificacionDTO(int numeroHabitacion, float edad, String nombres, String apellidos, String estrato, String mensajeAlMedico, String fecha, String hora) {
        this.numeroHabitacion = numeroHabitacion;
        this.edad = edad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estrato = estrato;
        this.mensajeAlMedico = mensajeAlMedico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }
    
    
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(float edad) {
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMensajeAlMedico() {
        return mensajeAlMedico;
    }

    public void setMensajeAlMedico(String mensajeAlMedico) {
        this.mensajeAlMedico = mensajeAlMedico;
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

    public ArrayList<ClsIndicadoresAlerta> getListaIndicadoresAlerta() {
        return listaIndicadoresAlerta;
    }

    public void setListaIndicadoresAlertaUnoaUno(ClsIndicadoresAlerta listaIndicadoresAlerta) {
        this.listaIndicadoresAlerta.add(listaIndicadoresAlerta);
    }

    public ArrayList<ClsIndicadoresRegistros> getListaIndicadoresRegistros() {
        return listaIndicadoresRegistros;
    }

    public void setListaIndicadoresRegistrosUnoAUno(ClsIndicadoresRegistros listaIndicadoresRegistros) {
        this.listaIndicadoresRegistros.add(listaIndicadoresRegistros);
    }

    public void setListaIndicadoresAlerta(ArrayList<ClsIndicadoresAlerta> listaIndicadoresAlerta) {
        this.listaIndicadoresAlerta = listaIndicadoresAlerta;
    }

    public void setListaIndicadoresRegistros(ArrayList<ClsIndicadoresRegistros> listaIndicadoresRegistros) {
        this.listaIndicadoresRegistros = listaIndicadoresRegistros;
    }
    
    
    
    
}
