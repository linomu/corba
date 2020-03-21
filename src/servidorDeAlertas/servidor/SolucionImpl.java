/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDeAlertas.servidor;

import java.util.ArrayList;
import java.util.HashMap;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import servidorDeAlertas.sop_corba.GestionAlertasIntPOA;
import servidorDeAlertas.sop_corba.*;
import servidorNotificaciones.sop_corba.GestionNotificacionesHelper;
import servidorNotificaciones.sop_corba.GestionNotificacionesOperations;
import servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;

/**
 *
 * @author santi
 */
public class SolucionImpl extends GestionAlertasIntPOA{

    HashMap pacientes = new HashMap<Integer, PacienteDTO>();
    GestionNotificacionesOperations referenciaNotificaciones;

    public SolucionImpl() {
        
    }

   

    @Override
    public void registrarPaciente(PacienteDTO objPaciente, BooleanHolder resultado) {
        
        if(pacientes.containsKey(objPaciente.numHabitacion)){
            System.out.println("No se puede introducir el paciente. El numero de habitación está repetido.");
            
        }else{
            pacientes.put(objPaciente.numHabitacion, objPaciente);
            System.out.println("Paciente agregado correctamente!");

        }
        ClsMensajeNotificacionDTO objNotificacion = new  ClsMensajeNotificacionDTO(objPaciente.numHabitacion, objPaciente.edad, objPaciente.nombres, objPaciente.apellidos, objPaciente.estrato, "You are good", "2020-12-10", "10:00");
        
         referenciaNotificaciones.notificarAlMedico(objNotificacion);
    }

    @Override
    public boolean enviarIndicadores(PacienteDTO objPaciente, BooleanHolder resultado) {
        System.out.println("Entre al metodo enviar Indicadores");
         boolean seEnviaronCorrectamente = false;
       PacienteDTO objPacienteEncontrado = (PacienteDTO)pacientes.get(objPaciente.numHabitacion);
       if(objPaciente.edad > 12 && objPaciente.edad < 16){
           if(objPaciente.frecuenciaCardiaca > 70 && objPaciente.frecuenciaCardiaca < 80){
               seEnviaronCorrectamente = true;
               String mensaje = "You're wrong eh!";
               System.out.println(mensaje + " desde la consola");
               objPaciente.pacbck.notificarPaciente(mensaje);
           }
        }else if(objPaciente.edad > 15){
           if(objPaciente.frecuenciaCardiaca > 60 && objPaciente.frecuenciaCardiaca < 80){
               seEnviaronCorrectamente = true;
               String mensaje = "You're wrong eh!";
               System.out.println(mensaje + " desde la consola");
               objPaciente.pacbck.notificarPaciente(mensaje);
           }
       }
       return seEnviaronCorrectamente;
    }
     public void obtenerLaReferenciaRemotaDelServidorDeNotificaciones(String direccionIPNS, String puertoNS) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            vec[1] = direccionIPNS;
            vec[2] = "-ORBInitialPort";
            vec[3] = puertoNS;
            
            ORB orb = ORB.init(vec, null);
            
            org.omg.CORBA.Object objRef
                   = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objNotificaciones";
            referenciaNotificaciones = GestionNotificacionesHelper.narrow(ncRef.resolve_str(name));
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
            
  
    
}
