package servidorNotificaciones.sop_corba.GestionNotificacionesPackage;

/**
* servidorNotificaciones/sop_corba/GestionNotificacionesPackage/ClsMensajeNotificacionDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from NotificacionesInt.idl
* s�bado 21 de marzo de 2020 08:59:57 PM COT
*/

public final class ClsMensajeNotificacionDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO value = null;

  public ClsMensajeNotificacionDTOHolder ()
  {
  }

  public ClsMensajeNotificacionDTOHolder (servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.type ();
  }

}
