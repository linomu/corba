/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones.servidor;
import servidorNotificaciones.sop_corba.GestionNotificacionesPOA;
import servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;

/**
 *
 * @author Fernanda y Diana
 */
public class GestionNotificacionesImpl extends GestionNotificacionesPOA {

    

    @Override
    public void notificarAlMedico(ClsMensajeNotificacionDTO objNotificacion) {
        if (1 == 1) {
            System.out.println("======== Notificacion ========");
            System.out.println("Se registro el paciente " + objNotificacion.nombres + "\nen la habitacion "
                    + objNotificacion.numeroHabitacion + " EXITOSAMENTE");
            System.out.println("===============================");
        }else{
            System.out.println("======== Notificacion ========");
            System.out.println("FALLO del registro del paciente " + objNotificacion.nombres + "\nen la habitacion "
                    + objNotificacion.numeroHabitacion);
            System.out.println("===============================");
        }
    }

}
