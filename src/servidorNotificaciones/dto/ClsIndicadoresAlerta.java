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
public class ClsIndicadoresAlerta implements Serializable{
    private String nombreIndicador;
    private String valor;

    public ClsIndicadoresAlerta(String nombreIndicador, String valor) {
        this.nombreIndicador = nombreIndicador;
        this.valor = valor;
    }

    public String getNombreIndicador() {
        return nombreIndicador;
    }

    public void setNombreIndicador(String nombreIndicador) {
        this.nombreIndicador = nombreIndicador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
