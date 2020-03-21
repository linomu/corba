package servidor;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import servidorDeAlertas.servidor.SolucionImpl;
import servidorDeAlertas.sop_corba.GestionAlertasInt;
import servidorDeAlertas.sop_corba.GestionAlertasIntHelper;

import servidorDeAlertas.sop_corba.*;

public class ServidorDeObjetos {

  public static void main(String args[]) {
    try{
        
        String[] vec = new String[4];
        vec[0] = "-ORBInitialHost";
        vec[1] = "localhost";
        vec[2] = "-ORBInitialPort";
        vec[3] = "2020";
        
      // crea e iniciia el ORB
      ORB orb = ORB.init(vec, null);

      // obtiene la referencia del rootpoa y activa el POAManager
      POA rootpoa =  POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
      
      
      
            

      //*** crea una instancia del servant y lo registra con el ORB ***
      SolucionImpl convref = new SolucionImpl();
      convref.obtenerLaReferenciaRemotaDelServidorDeNotificaciones(vec[1], vec[3]);
      
    System.out.println("5. Crea el objeto tie y se registra una referencia al objeto servant mediante el contructor");
    GestionAlertasIntPOATie objTIE = new GestionAlertasIntPOATie(convref);
       
      //*** obtiene la referencia del objeto desde el servant ***
      org.omg.CORBA.Object obj =   rootpoa.servant_to_reference(convref);
      GestionAlertasInt href = GestionAlertasIntHelper.narrow(obj);
	  
      // obtiene la base del contexto de nombrado
      org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
      // Usa NamingContextExt el cual es parte de la especificacion 
      // del servicio de nombrado interoperable (INS).
      NamingContextExt ncref = NamingContextExtHelper.narrow(objref);

      // *** Realiza el binding de la referencia de objeto en el N_S ***
      String name = "ges-alertas";
      NameComponent path[] = ncref.to_name( name );
      ncref.rebind(path, href);

      System.out.println("El Servidor esta listo y esperando ...");

      // esperan por las invocaciones desde los clientes
      orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Servidor: Saliendo ...");
	
  }
}
