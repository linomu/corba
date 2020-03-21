/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import org.omg.CORBA.BooleanHolder;
import servidorDeAlertas.sop_corba.*;
/**
 *
 * @author Lino Alejandro Munoz
 */
public class GestionAlertasImpl extends GestionAlertasIntPOA{

    @Override
    public void registrarPaciente(PacienteDTO objPaciente, BooleanHolder resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enviarIndicadores(PacienteDTO objPaciente, BooleanHolder resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
