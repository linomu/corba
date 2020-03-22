package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import servidorDeAlertas.sop_corba.*;


public class ClienteDeObjetos {
    //*** Atributo estático ***

    static GestionAlertasInt ref;
    

    public static void main(String args[]) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            vec[1] = "localhost";
            vec[2] = "-ORBInitialPort";
            vec[3] = "2020";

            // crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // obtiene la base del naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
           
            
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            
            //Instancia el servant
            PacienteCllbckImpl pacback = new PacienteCllbckImpl();
            //Obtiene las referencias del rootPOA y acttive el POAManager
            org.omg.CORBA.Object ref1 = rootPOA.servant_to_reference(pacback);
            PacienteCllbckInt href1 = PacienteCllbckIntHelper.narrow(ref1);
            

            
            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "ges-alertas";
            ref = GestionAlertasIntHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
            String nombre, apellido;
            int numHabitacion, edad;
            int rta = 0;
            do {
                rta = menu();
                
                switch(rta){
                    case 1:
                        System.out.println(" Patient's name ");
                        nombre = UtilidadesConsola.leerCadena();
                        
                        System.out.println(" Patient's lastname ");
                        apellido = UtilidadesConsola.leerCadena();

                        System.out.println("Patient's age");
                        edad = Integer.parseInt(UtilidadesConsola.leerCadena());
                        
                        System.out.println("Patient's number room");
                        
                        numHabitacion = Integer.parseInt(UtilidadesConsola.leerCadena());
                        
                        PacienteDTO objPaciente = new PacienteDTO(numHabitacion, nombre, apellido, edad, 75, 75, 75, 75, 75, 75, 75, href1);
                        
                       BooleanHolder resultado = new BooleanHolder();
                       ref.registrarPaciente(objPaciente, resultado);
                        
                        ref.enviarIndicadores(objPaciente, resultado);
                             
                        
                    
                        
                        break;
                    
                }
                
            }while(rta != 2);
            

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
    
    public static int menu() {
        
        System.out.println(" :: MENU ::");
        System.out.println(" :1: Registrar Usuario");
        System.out.println(" :2: Salir");
        int rta = UtilidadesConsola.leerEntero();
        
        return rta;
        
    }
    
    public static void printPatient(PacienteDTO objNew){
        System.out.println("\nEl paciente: " + objNew.nombres + " " + objNew.apellidos + " de " +
                objNew.edad + " anios de edad, se encuentra en la habitacion " + objNew.numHabitacion); 
        System.out.println("");
    }
    
    
   

}
