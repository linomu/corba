package servidorDeAlertas.sop_corba;


/**
* servidorDeAlertas/sop_corba/PacienteCllbckIntPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GestionUsuariosInt.idl
* s�bado 21 de marzo de 2020 08:59:52 PM COT
*/

public class PacienteCllbckIntPOATie extends PacienteCllbckIntPOA
{

  // Constructors

  public PacienteCllbckIntPOATie ( servidorDeAlertas.sop_corba.PacienteCllbckIntOperations delegate ) {
      this._impl = delegate;
  }
  public PacienteCllbckIntPOATie ( servidorDeAlertas.sop_corba.PacienteCllbckIntOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public servidorDeAlertas.sop_corba.PacienteCllbckIntOperations _delegate() {
      return this._impl;
  }
  public void _delegate (servidorDeAlertas.sop_corba.PacienteCllbckIntOperations delegate ) {
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
  public String notificarPaciente (String mensaje)
  {
    return _impl.notificarPaciente(mensaje);
  } // notificarPaciente

  private servidorDeAlertas.sop_corba.PacienteCllbckIntOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class PacienteCllbckIntPOATie
