
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones.servidor;
import ServidorDeAlertas.dao.ClsPersistencia;
import ServidorNotificaciones.dto.ClsIndicadoresAlerta;
import ServidorNotificaciones.dto.ClsIndicadoresRegistros;
import ServidorNotificaciones.dto.ClsNotificacionDTO;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import servidorNotificaciones.sop_corba.GestionNotificacionesPOA;
import servidorNotificaciones.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;
import ServidorNotificaciones.vistas.VistaNotificaciones;
import conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fernanda y Diana
 */
public class GestionNotificacionesImpl extends GestionNotificacionesPOA {

     //ClsNotificacionDTO objNotificacion;
    private final ConexionBD conexionABaseDeDatos1;
    JLabel numHabitacion, nombre, apellidos, edad, horaAlerta, fechaAlerta, mensajeDoctorEnfermera;
    JTable tablaIndicadores, tablaRegistros;
    DefaultTableModel objModeloTablaIndicadores = new DefaultTableModel();
    DefaultTableModel objModeloTablaRegistros = new DefaultTableModel();

    public GestionNotificacionesImpl(VistaNotificaciones Vista){
        super();
        this.numHabitacion = Vista.getTxtNumHabitacion();
        this.nombre = Vista.getTxtNombres();
        this.apellidos = Vista.getTxtApellidos();
        this.edad = Vista.getTxtEdad();
        this.horaAlerta = Vista.getTxtHoraAlerta();
        this.fechaAlerta = Vista.getTxtFechaAlerta();
        this.mensajeDoctorEnfermera = Vista.getTxtMensajeEnfermeraDoctor();
        this.tablaIndicadores = Vista.getTableIndicadores();
        this.tablaRegistros = Vista.getTableRegistros();
        conexionABaseDeDatos1 = new ConexionBD();
        setModelos();
    }
    
    
    
     /*En el constructor deben ir referenciados todos los elementos que se van a utilizar en la GUI, con el fin de efectuar
    los cambios en ésta clase y que se vean reflejados en el formulario*/
    public GestionNotificacionesImpl(JLabel numHabitacion, JLabel nombre, JLabel apellidos, JLabel edad, JLabel horaAlerta, JLabel fechaAlerta, JLabel mensajeDoctorEnfermera, JTable tablaIndicadores, JTable tablaRegistros) throws RemoteException {
        super();
        this.numHabitacion = numHabitacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.horaAlerta = horaAlerta;
        this.fechaAlerta = fechaAlerta;
        this.mensajeDoctorEnfermera = mensajeDoctorEnfermera;
        this.tablaIndicadores = tablaIndicadores;
        this.tablaRegistros = tablaRegistros;
        conexionABaseDeDatos1 = new ConexionBD();
        setModelos();

    }
    //Este método tiene como finalidad, dar el formato adecuado para cada tabla utilizada en la GUI
    private void setModelos() {
        String[] cabecera = {"Nombre Indicador", "Valor"};
        objModeloTablaIndicadores.setColumnIdentifiers(cabecera);
        this.tablaIndicadores.setModel(objModeloTablaIndicadores);
        String[] cabeceraTablaRegitros = {"Fecha de Alerta", "Hora de Alerta", "Puntuación"};
        objModeloTablaRegistros.setColumnIdentifiers(cabeceraTablaRegitros);
        this.tablaRegistros.setModel(objModeloTablaRegistros);

    }
    
    @Override
    public void notificarAlMedico(ClsMensajeNotificacionDTO objNotificacion) {
        System.out.println("***Datos Servidor Notificaiones***\nNombre: " + objNotificacion.nombres);
        System.out.println("Cantidad de alertas: " + objNotificacion.getListaIndicadoresAlerta().size());
       
        ClsPersistencia persistencia = new ClsPersistencia();
        ArrayList<ClsIndicadoresRegistros> listaIndicadoresRegistros = new ArrayList<>();
        ArrayList<ClsIndicadoresAlerta> listaIndicadoresAlerta =  new ArrayList<>();
        
        
        String idPaciente = persistencia.buscarPaciente(String.valueOf(objNotificacion.numeroHabitacion));
        conexionABaseDeDatos1.conectar();
        try {
            PreparedStatement sentencia = null;
            String consulta = "select * from registro where idPacienteFK = ? order by idRegistro desc limit 5";
            sentencia = conexionABaseDeDatos1.getConnection().prepareStatement(consulta);
            sentencia.setString(1, idPaciente);
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                ClsIndicadoresRegistros registro = new ClsIndicadoresRegistros();
                registro.setFecha(res.getString("fecha"));
                registro.setHora(res.getString("hora"));
                registro.setPuntuacion(res.getString("puntuacion"));
                listaIndicadoresRegistros.add(registro);
            }
            sentencia.close();
            conexionABaseDeDatos1.desconectar();
        } catch (SQLException e) {
            System.out.println("error en la consulta de una alerta: " + e.getMessage());
        }
        
        //Buscar
        conexionABaseDeDatos1.conectar();
        try {
            PreparedStatement sentencia = null;
            String consulta = "select nombre, valor from indicadores where idRegistro = (select max(idRegistro) from registro where idPacienteFK = ?)";
            sentencia = conexionABaseDeDatos1.getConnection().prepareStatement(consulta);
            sentencia.setString(1, idPaciente);
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                ClsIndicadoresAlerta indicador = new ClsIndicadoresAlerta();
                indicador.setNombreIndicador(res.getString("nombre"));
                indicador.setValor(res.getString("valor"));
                listaIndicadoresAlerta.add(indicador);
            }
            sentencia.close();
            conexionABaseDeDatos1.desconectar();
        } catch (SQLException e) {
            System.out.println("error en la consulta de un indicador: " + e.getMessage());
        }
        //SE haga la consulta a la base de datos y se recuperen
        objNotificacion.setListaIndicadoresAlerta(listaIndicadoresAlerta);
       
        
        //Consulas la bd
        objNotificacion.setListaIndicadoresRegistros(listaIndicadoresRegistros);
        
        imprimirInformacion(objNotificacion);
    }

    
     private void imprimirInformacion(ClsMensajeNotificacionDTO objNotificacion) {
        //El comando setRowCount lo utilizamos para Limpiar las tablas
        this.objModeloTablaIndicadores.setRowCount(0);
        this.objModeloTablaRegistros.setRowCount(0);
        
        
        DecimalFormat df = new DecimalFormat("#.00");
            
        this.numHabitacion.setText(String.valueOf(objNotificacion.numeroHabitacion));
        this.nombre.setText(String.valueOf(objNotificacion.nombres));
        this.apellidos.setText(String.valueOf(objNotificacion.apellidos));
        if(objNotificacion.edad<1){
            //Convertimos la edad en semanas
            double semanas = (365*objNotificacion.edad)/7;
            
            this.edad.setText(String.valueOf(df.format(semanas))+" Semanas ");
            
        }
        
        this.edad.setText(String.valueOf(df.format(objNotificacion.edad) + " Años"));
        this.horaAlerta.setText(String.valueOf(objNotificacion.hora));
        this.fechaAlerta.setText(String.valueOf(objNotificacion.fecha));
        this.mensajeDoctorEnfermera.setText(String.valueOf(objNotificacion.mensajeAlMedico));
        /*El siguiente for recorrer todas las alertas, con el fin de pasarlas a la tabla*/
        Object[] datos = new Object[this.objModeloTablaIndicadores.getColumnCount()];
        for (ClsIndicadoresAlerta objIndicadorAlerta : objNotificacion.getListaIndicadoresAlerta()) {
            datos[0] = objIndicadorAlerta.getNombreIndicador();
            datos[1] = objIndicadorAlerta.getValor();
            this.objModeloTablaIndicadores.addRow(datos);
        }
        this.tablaIndicadores.setModel(objModeloTablaIndicadores);
        /*Imprimir en la tabla las ultimos 5 registros de las alertas*/

        int tamanioLista = objNotificacion.getListaIndicadoresRegistros().size();
        //System.err.println("Tamano de la de lista: "+tamanioLista);
        Object[] datosRegistros = new Object[this.objModeloTablaRegistros.getColumnCount()];

        if (tamanioLista >= 5) {
            for (int i = (tamanioLista - 5); i < tamanioLista; i++) {
                datosRegistros[0] = objNotificacion.getListaIndicadoresRegistros().get(i).getFecha();
                datosRegistros[1] = objNotificacion.getListaIndicadoresRegistros().get(i).getHora();
                datosRegistros[2] = objNotificacion.getListaIndicadoresRegistros().get(i).getPuntuacion();
                this.objModeloTablaRegistros.addRow(datosRegistros);
            }
        }
        if (tamanioLista == 1) {
            datosRegistros[0] = objNotificacion.getListaIndicadoresRegistros().get(0).getFecha();
            datosRegistros[1] = objNotificacion.getListaIndicadoresRegistros().get(0).getHora();
            datosRegistros[2] = objNotificacion.getListaIndicadoresRegistros().get(0).getPuntuacion();
            this.objModeloTablaRegistros.addRow(datosRegistros);
        }
        if (tamanioLista == 2) {
            for (int i = 0; i < 1; i++) {
                datosRegistros[0] = objNotificacion.getListaIndicadoresRegistros().get(i).getFecha();
                datosRegistros[1] = objNotificacion.getListaIndicadoresRegistros().get(i).getHora();
                datosRegistros[2] = objNotificacion.getListaIndicadoresRegistros().get(i).getPuntuacion();
                this.objModeloTablaRegistros.addRow(datosRegistros);
            }
        }
        if (tamanioLista == 3) {
            for (int i = 0; i < 2; i++) {
                datosRegistros[0] = objNotificacion.getListaIndicadoresRegistros().get(i).getFecha();
                datosRegistros[1] = objNotificacion.getListaIndicadoresRegistros().get(i).getHora();
                datosRegistros[2] = objNotificacion.getListaIndicadoresRegistros().get(i).getPuntuacion();
                this.objModeloTablaRegistros.addRow(datosRegistros);
            }
        }
        if (tamanioLista == 4) {
            for (int i = 0; i < 3; i++) {
                datosRegistros[0] = objNotificacion.getListaIndicadoresRegistros().get(i).getFecha();
                datosRegistros[1] = objNotificacion.getListaIndicadoresRegistros().get(i).getHora();
                datosRegistros[2] = objNotificacion.getListaIndicadoresRegistros().get(i).getPuntuacion();
                this.objModeloTablaRegistros.addRow(datosRegistros);
            }
        }

        this.tablaRegistros.setModel(objModeloTablaRegistros);

    }

}
