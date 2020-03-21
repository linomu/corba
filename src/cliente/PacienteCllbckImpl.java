package cliente;

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

    

    @Override
    public String notificarPaciente(String mensaje) {
        System.out.println("Mensaje");
        return "Hello";
    }
    
}
