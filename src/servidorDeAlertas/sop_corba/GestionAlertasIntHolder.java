package servidorDeAlertas.sop_corba;

/**
* servidorDeAlertas/sop_corba/GestionAlertasIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GestionUsuariosInt.idl
* s�bado 21 de marzo de 2020 08:59:52 PM COT
*/

public final class GestionAlertasIntHolder implements org.omg.CORBA.portable.Streamable
{
  public servidorDeAlertas.sop_corba.GestionAlertasInt value = null;

  public GestionAlertasIntHolder ()
  {
  }

  public GestionAlertasIntHolder (servidorDeAlertas.sop_corba.GestionAlertasInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = servidorDeAlertas.sop_corba.GestionAlertasIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    servidorDeAlertas.sop_corba.GestionAlertasIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return servidorDeAlertas.sop_corba.GestionAlertasIntHelper.type ();
  }

}
