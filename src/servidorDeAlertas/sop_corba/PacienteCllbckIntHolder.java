package servidorDeAlertas.sop_corba;

/**
* servidorDeAlertas/sop_corba/PacienteCllbckIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GestionUsuariosInt.idl
* s�bado 21 de marzo de 2020 08:59:52 PM COT
*/

public final class PacienteCllbckIntHolder implements org.omg.CORBA.portable.Streamable
{
  public servidorDeAlertas.sop_corba.PacienteCllbckInt value = null;

  public PacienteCllbckIntHolder ()
  {
  }

  public PacienteCllbckIntHolder (servidorDeAlertas.sop_corba.PacienteCllbckInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = servidorDeAlertas.sop_corba.PacienteCllbckIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    servidorDeAlertas.sop_corba.PacienteCllbckIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return servidorDeAlertas.sop_corba.PacienteCllbckIntHelper.type ();
  }

}
