package cliente;

import javax.swing.JTextArea;
import servidorDeAlertas.sop_corba.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lino Alejandro Munoz
 */
public class PacienteCllbckImpl extends PacienteCllbckIntPOA {

    
    JTextArea textAreaCallBack;
    
    public PacienteCllbckImpl(){
        super();
    }
    
    public PacienteCllbckImpl(JTextArea textArea) {
        super();
        this.textAreaCallBack = textArea;
    }

    @Override
    public String notificarPaciente(String mensaje) {
         System.out.println("Mensaje enviado del servidor: " + mensaje);
        this.textAreaCallBack.setText("Call back: " +mensaje);
        return "Mensaje Retornado";
    }
    
}
