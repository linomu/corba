/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorDeAlertas.servidor;

import ServidorDeAlertas.dao.ClsPersistencia;
import ServidorDeAlertas.dto.GestionAlertaIndicadores;
import ServidorNotificaciones.dto.ClsIndicadoresAlerta;
import ServidorNotificaciones.dto.ClsIndicadoresRegistros;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
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
public class SolucionImpl extends GestionAlertasIntPOA {

    HashMap pacientes = new HashMap<Integer, PacienteDTO>();
    GestionNotificacionesOperations referenciaNotificaciones;

    public SolucionImpl() {

    }

    @Override
    public void registrarPaciente(PacienteDTO objPaciente, BooleanHolder resultado) {

        if (pacientes.containsKey(objPaciente.numHabitacion)) {
            System.out.println("No se puede introducir el paciente. El numero de habitación está repetido.");

        } else {
            pacientes.put(objPaciente.numHabitacion, objPaciente);
            System.out.println("Paciente agregado correctamente!");

        }

    }

    @Override
    public boolean enviarIndicadores(PacienteDTO objPaciente, BooleanHolder resultado) {
        /*
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
         //Analizar los indicadores
            ClsMensajeNotificacionDTO objNotificacion = new  ClsMensajeNotificacionDTO(objPaciente.numHabitacion, objPaciente.edad, objPaciente.nombres, objPaciente.apellidos, "You are good", "2020-12-10", "10:00");
            referenciaNotificaciones.notificarAlMedico(objNotificacion);
         */
        System.out.println("Invocando al método enviarIndicadores desde el servidor...");
        ClsMensajeNotificacionDTO objMensajeNotificacion;
        String respuestaCallback = "El paciente se encuentra bien";

        //La variable listaConIndicadores me retorna un arreglo que tiene las alertas generadas con base en los indicadores    
        GestionAlertaIndicadores objIndicadoresAlertas = new GestionAlertaIndicadores(objPaciente);
        ArrayList<ClsIndicadoresAlerta> listaConIndicadores = objIndicadoresAlertas.llenarListaConIndicadores();
        //Tengo que validar si se debe o no enviar la informacion al servidor de notificaciones y esto debe ser con base en la cantidad de alertas
        if (listaConIndicadores.size() > 1) {

            /*Parte del Callback*/
            //Si hay una alerta se debe notificar al paciente, obtengo la refencia de ese OR
            String nombreAlertasGeneradas = "";
            //De la listaConIndicadores, solo voy a obtener el nombre de los indicadores, esto con el fin de enviárselo al paciente
            for (ClsIndicadoresAlerta listaConIndicadore : listaConIndicadores) {
                nombreAlertasGeneradas += listaConIndicadore.getNombreIndicador() + " [ " + listaConIndicadore.getValor() + " ] " + "\n";
            }
            //Esta es la respuesta que se enviará al Paciente, mediate el retorno del método.
            objPaciente.pacbck.notificarPaciente("El paciente que se encuntra en la habitacion " + objPaciente.numHabitacion + " tiene  " + listaConIndicadores.size() + " indicadores que se encuentran fuera del rango normal.\n" + nombreAlertasGeneradas);

            String mensaje = "La enfermera debe revisar al paciente";
            if (listaConIndicadores.size() >= 3) {
                mensaje = "El medico y la enfermera deben revisar al paciente";
            }
            String hora = obtenerHora();
            String fecha = obtenerFecha();

            /*Realizar la persistencia*/
            ClsPersistencia objPersistencia = new ClsPersistencia();
            /*Creo un objeto de la clase ClsIndicadoresRegistros, con el fin de estructurar la alerta y así guardarlo en el txt*/
            ClsIndicadoresRegistros objRegistro = new ClsIndicadoresRegistros(String.valueOf(objPaciente.numHabitacion), objPaciente.nombres, objPaciente.apellidos, fecha, hora, String.valueOf(listaConIndicadores.size()));
            //JOptionPane.showMessageDialog(null, objRegistro.mostrar());
            //objRegistro.mostrar();

            objPersistencia.GuardarRegistro(objRegistro);
            objPersistencia.GuardarIndicador(listaConIndicadores, objRegistro.getNumHabitacion());

            objMensajeNotificacion = new ClsMensajeNotificacionDTO(objPaciente.numHabitacion, objPaciente.edad, objPaciente.nombres, objPaciente.apellidos, mensaje, fecha, hora);

            //Le paso al mensajeNotificacion las alertas generadas
            objMensajeNotificacion.setListaIndicadoresAlerta(listaConIndicadores);
            String idPaciente = objPersistencia.buscarPaciente(String.valueOf(objPaciente.numHabitacion));
            /*Aqui debo leer del archivo txt los registros que tiene almacenados con base en su edad,
            al mismo tiempo que le paso esa lista al objMensajeNotificacion*/
            ArrayList<ClsIndicadoresRegistros> LeerRegistros = objPersistencia.LeerRegistros(idPaciente);
            //objMensajeNotificacion.setListaIndicadoresRegistros(LeerRegistros);
            objMensajeNotificacion.listaIndicadoresRegistros = LeerRegistros;
            //Enviar el mensaje*/

            referenciaNotificaciones.notificarAlMedico(objMensajeNotificacion);
            //ORServidorNotificaciones.notificarAlMedico(objMensajeNotificacion);
            //ORServidorNotificaciones.notificarAlMedicoConMensaje();

        }
        return true;
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

    private String obtenerHora() {
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatterTime.format(date);
    }

    private String obtenerFecha() {
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatterDate.format(date);
    }

}
