package servidorNotificaciones.sop_corba.GestionNotificacionesPackage;


/**
* servidorNotificaciones/sop_corba/GestionNotificacionesPackage/ClsMensajeNotificacionDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from NotificacionesInt.idl
* viernes 20 de marzo de 2020 05:49:38 PM COT
*/

abstract public class ClsMensajeNotificacionDTOHelper
{
  private static String  _id = "IDL:sop_corba/GestionNotificaciones/ClsMensajeNotificacionDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [8];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "numeroHabitacion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "edad",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "nombres",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "apellidos",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "estrato",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "mensajeAlMedico",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "fecha",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "hora",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.id (), "ClsMensajeNotificacionDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO value = new servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO ();
    value.numeroHabitacion = istream.read_long ();
    value.edad = istream.read_long ();
    value.nombres = istream.read_string ();
    value.apellidos = istream.read_string ();
    value.estrato = istream.read_string ();
    value.mensajeAlMedico = istream.read_string ();
    value.fecha = istream.read_string ();
    value.hora = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO value)
  {
    ostream.write_long (value.numeroHabitacion);
    ostream.write_long (value.edad);
    ostream.write_string (value.nombres);
    ostream.write_string (value.apellidos);
    ostream.write_string (value.estrato);
    ostream.write_string (value.mensajeAlMedico);
    ostream.write_string (value.fecha);
    ostream.write_string (value.hora);
  }

}
