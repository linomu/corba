package servidorNotificaciones.sop_corba;


/**
* servidorNotificaciones/sop_corba/GestionNotificacionesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from NotificacionesInt.idl
* viernes 20 de marzo de 2020 05:49:38 PM COT
*/

public class GestionNotificacionesPOATie extends GestionNotificacionesPOA
{

  // Constructors

  public GestionNotificacionesPOATie ( servidorNotificaciones.sop_corba.GestionNotificacionesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionNotificacionesPOATie ( servidorNotificaciones.sop_corba.GestionNotificacionesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public servidorNotificaciones.sop_corba.GestionNotificacionesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (servidorNotificaciones.sop_corba.GestionNotificacionesOperations delegate ) {
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
  public void notificarAlMedico (servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO objNotificacion)
  {
    _impl.notificarAlMedico(objNotificacion);
  } // notificarAlMedico

  private servidorNotificaciones.sop_corba.GestionNotificacionesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionNotificacionesPOATie