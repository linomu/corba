package servidorDeAlertas.sop_corba;


/**
* servidorDeAlertas/sop_corba/PacienteDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GestionUsuariosInt.idl
* s�bado 21 de marzo de 2020 08:59:52 PM COT
*/

abstract public class PacienteDTOHelper
{
  private static String  _id = "IDL:sop_corba/PacienteDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, servidorDeAlertas.sop_corba.PacienteDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static servidorDeAlertas.sop_corba.PacienteDTO extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [12];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "numHabitacion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "nombres",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "apellidos",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[3] = new org.omg.CORBA.StructMember (
            "edad",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[4] = new org.omg.CORBA.StructMember (
            "frecuenciaCardiaca",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[5] = new org.omg.CORBA.StructMember (
            "presionArterial",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[6] = new org.omg.CORBA.StructMember (
            "frecuenciaRespiratoria",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[7] = new org.omg.CORBA.StructMember (
            "saturacionOxigeno",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[8] = new org.omg.CORBA.StructMember (
            "sistolica",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[9] = new org.omg.CORBA.StructMember (
            "diastolica",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[10] = new org.omg.CORBA.StructMember (
            "temperatura",
            _tcOf_members0,
            null);
          _tcOf_members0 = servidorDeAlertas.sop_corba.PacienteCllbckIntHelper.type ();
          _members0[11] = new org.omg.CORBA.StructMember (
            "pacbck",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (servidorDeAlertas.sop_corba.PacienteDTOHelper.id (), "PacienteDTO", _members0);
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

  public static servidorDeAlertas.sop_corba.PacienteDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    servidorDeAlertas.sop_corba.PacienteDTO value = new servidorDeAlertas.sop_corba.PacienteDTO ();
    value.numHabitacion = istream.read_long ();
    value.nombres = istream.read_string ();
    value.apellidos = istream.read_string ();
    value.edad = istream.read_float ();
    value.frecuenciaCardiaca = istream.read_float ();
    value.presionArterial = istream.read_float ();
    value.frecuenciaRespiratoria = istream.read_float ();
    value.saturacionOxigeno = istream.read_float ();
    value.sistolica = istream.read_float ();
    value.diastolica = istream.read_float ();
    value.temperatura = istream.read_float ();
    value.pacbck = servidorDeAlertas.sop_corba.PacienteCllbckIntHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, servidorDeAlertas.sop_corba.PacienteDTO value)
  {
    ostream.write_long (value.numHabitacion);
    ostream.write_string (value.nombres);
    ostream.write_string (value.apellidos);
    ostream.write_float (value.edad);
    ostream.write_float (value.frecuenciaCardiaca);
    ostream.write_float (value.presionArterial);
    ostream.write_float (value.frecuenciaRespiratoria);
    ostream.write_float (value.saturacionOxigeno);
    ostream.write_float (value.sistolica);
    ostream.write_float (value.diastolica);
    ostream.write_float (value.temperatura);
    servidorDeAlertas.sop_corba.PacienteCllbckIntHelper.write (ostream, value.pacbck);
  }

}
