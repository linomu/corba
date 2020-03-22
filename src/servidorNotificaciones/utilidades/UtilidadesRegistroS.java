
package ServidorNotificaciones.utilidades;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class UtilidadesRegistroS
{
	public static void arrancarNS(String direccionIPNS, int numPuertoNS) throws RemoteException 
	{
		try
		{
                        
			Registry registro = LocateRegistry.getRegistry(direccionIPNS, numPuertoNS);
                        registro.list();
                        
                        System.out.println("El n_s se ha obtenido y se encuentra escuchando en la dirección IP "+direccionIPNS+" y puerto "+numPuertoNS);
			
		}
		catch(RemoteException e)
		{
			System.out.println("El registro RMI no se localizó");
			
			Registry registro = LocateRegistry.createRegistry(numPuertoNS);
			System.out.println("El registro se ha creado ");
		}
		
	}
        
        	
	public static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIPNS, int numPuertoNS, String nombreObjeto)
	{
		String UrlRegistro = "rmi://"+dirIPNS+":"+numPuertoNS+"/"+nombreObjeto;
		try
		{
                        //Descompone la url del registro, localiza el ns y el ns tiene una tabla q guarda
                        //el nombre del obj remoto, la dir ip del obj remoto y el puerto del obj remoto
			Naming.rebind(UrlRegistro, objetoRemoto);
			System.out.println("Se realizó el registro del objeto remoto con la direccion: " +UrlRegistro);
		} catch (RemoteException e)
		{
			System.out.println("Error en el registro del objeto remoto");
			e.printStackTrace();
		} catch (MalformedURLException e)
		{
			System.out.println("Error url inválida");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
}
