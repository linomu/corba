package servidorNotificaciones.sop_corba;


/**
* servidorNotificaciones/sop_corba/_GestionNotificacionesStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from NotificacionesInt.idl
* viernes 20 de marzo de 2020 05:49:38 PM COT
*/

public class _GestionNotificacionesStub extends org.omg.CORBA.portable.ObjectImpl implements servidorNotificaciones.sop_corba.GestionNotificaciones
{

  public void notificarAlMedico (servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO objNotificacion)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("notificarAlMedico", true);
                servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.write ($out, objNotificacion);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                notificarAlMedico (objNotificacion        );
            } finally {
                _releaseReply ($in);
            }
  } // notificarAlMedico

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionNotificaciones:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GestionNotificacionesStub
