package servidorDeAlertas.sop_corba;


/**
* servidorDeAlertas/sop_corba/GestionAlertasIntPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GestionUsuariosInt.idl
* viernes 20 de marzo de 2020 05:45:47 PM COT
*/

public class GestionAlertasIntPOATie extends GestionAlertasIntPOA
{

  // Constructors

  public GestionAlertasIntPOATie ( servidorDeAlertas.sop_corba.GestionAlertasIntOperations delegate ) {
      this._impl = delegate;
  }
  public GestionAlertasIntPOATie ( servidorDeAlertas.sop_corba.GestionAlertasIntOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public servidorDeAlertas.sop_corba.GestionAlertasIntOperations _delegate() {
      return this._impl;
  }
  public void _delegate (servidorDeAlertas.sop_corba.GestionAlertasIntOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void registrarPaciente (servidorDeAlertas.sop_corba.PacienteDTO objPaciente, org.omg.CORBA.BooleanHolder resultado)
  {
    _impl.registrarPaciente(objPaciente, resultado);
  } // registrarPaciente

  public boolean enviarIndicadores (servidorDeAlertas.sop_corba.PacienteDTO objPaciente, org.omg.CORBA.BooleanHolder resultado)
  {
    return _impl.enviarIndicadores(objPaciente, resultado);
  } // enviarIndicadores

  private servidorDeAlertas.sop_corba.GestionAlertasIntOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionAlertasIntPOATie