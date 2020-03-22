package cliente.vistas;

import ServidorDeAlertas.dao.ClsPersistencia;
import cliente.PacienteCllbckImpl;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import servidorDeAlertas.sop_corba.*;


import cliente.dto.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ClienteDeObjetos extends javax.swing.JFrame {

    static PacienteCllbckInt href1;
    static GestionAlertasInt ref;
    private ArrayList<String> mensajesTextArea = new ArrayList<>();
    private ArrayList<Integer> numeroHabitaciones = new ArrayList<>();

    public ClienteDeObjetos() {
        initComponents();
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        funcionalidadCorba();
        fijarImagenesEnElFormulario();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtNumHabitacion = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_indicadores = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        comboTipoEdad = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        imagenEPS = new javax.swing.JLabel();
        logocorazon = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaCallback = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Edad:");

        jLabel4.setText("Num Habitación:");

        txtNombre.setName("txtNombre"); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtEdad.setName("txtEdad"); // NOI18N
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        txtNumHabitacion.setName("txtNumHabitacion"); // NOI18N

        txtApellido.setName("txtApellido"); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar y enviar indicadores");
        btnGuardar.setName("btnGuardarCliente"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        jLabel5.setText("Indicadores");

        txtarea_indicadores.setColumns(20);
        txtarea_indicadores.setRows(5);
        txtarea_indicadores.setName("txtIndicadores"); // NOI18N
        jScrollPane1.setViewportView(txtarea_indicadores);

        jLabel6.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
        jLabel6.setText("Notificaciones");

        comboTipoEdad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semanas", "Años" }));

        jLabel7.setText("Tipo de edad:");

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtAreaCallback.setColumns(20);
        txtAreaCallback.setRows(5);
        jScrollPane3.setViewportView(txtAreaCallback);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(imagenEPS, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNumHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboTipoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(9, 9, 9)
                                .addComponent(logocorazon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalir)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(578, 578, 578))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnSalir)))
                            .addComponent(logocorazon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagenEPS, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNumHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTipoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Capturar Informacion

        //Validar que todos los campos tengan información
        if (validarFormulario()) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String tipoMensaje = comboTipoEdad.getSelectedItem().toString();
            float edad = Float.parseFloat(txtEdad.getText());
            int numHabitacion = Integer.parseInt(txtNumHabitacion.getText());
            
            if (tipoMensaje.equals("Semanas")) {
                //Esta conversion nos permite pasar el numero de semanas a años
                edad = (float) (edad * (7.0 / 365.0));
                System.out.println("Entre a semanas: " + edad);

            }
            //ClsPersistencia objPersistencia = new ClsPersistencia();
            //this.numeroHabitaciones = objPersistencia.LeerNumerosHabitacion();
            if (!this.numeroHabitaciones.contains(numHabitacion)) {
                JOptionPane.showMessageDialog(this, "Iniciando la lectura de sensores...");
                //Creamos un objeto paciente
                PacienteDTO objPaciente = new PacienteDTO(numHabitacion, nombre, apellido, edad, href1);
                //Deshabilitamos los demás componentes de la GUI para envitar el ingreso de datos
                inhabilitarComponentes();
                //Objeto de la clase Timer, el cual me permite realizar una actividad cada N Milisegundos
                Timer objTimer = new Timer(8000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        //Generar los indicadores aleatoriamente
                        GestionIndicadores objGestion = new GestionIndicadores();
                        PacienteDTO objNewCliente;
                        //El objNewCliente es el resultado de la informacion personas + los indicadores
                        objNewCliente = objGestion.GenerarIndicadores(objPaciente);
                        // Obtener indicadores en un String para luego imprimirlos
                        String mensajeTextArea = mensajeIndicadores(objNewCliente);
                        //Agrego los indicadores a una lista, para tener un historial de indicadores emitidos
                        mensajesTextArea.add(mensajeTextArea);
                        //Fijar los mensajes en el area de Indicadores
                        mostrarIndicadoresEnPantalla();
                        //Ejecucion de los Objetos Remotos
                        
                        BooleanHolder resultado = new BooleanHolder();
                        ref.registrarPaciente(objNewCliente, resultado);
                        
                        ref.enviarIndicadores(objNewCliente, resultado);

                    }
                });
                objTimer.start();
            } else {
                JOptionPane.showMessageDialog(this, "El número de habitación ya se encuentra registrado...");
            }
        } else {
            //JOptionPane.showMessageDialog(this, "El formulario se encuentra incompleto...");
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    public String mensajeIndicadores(PacienteDTO objNewCliente) {
        DecimalFormat df = new DecimalFormat("#.00");
        String mensaje = "Enviando Indicadores...\n"
                + "Frecuencia Cardiaca: " + df.format(objNewCliente.frecuenciaCardiaca)
                + "\nPresión Arterial: " + df.format(objNewCliente.sistolica) + "/" + df.format(objNewCliente.diastolica)
                + "\nFrecuencia Respiratoria: " + df.format(objNewCliente.frecuenciaRespiratoria)
                + "\nTemperatura: " + df.format(objNewCliente.temperatura)
                + "\nSaturación de Oxígento: " + df.format(objNewCliente.saturacionOxigeno) + "\n"
                + "************\n";
        return mensaje;
    }

    

    public void mostrarIndicadoresEnPantalla() {
        String mensajeFinal = "";
        for (String string : mensajesTextArea) {
            mensajeFinal += string;
        }
        this.txtarea_indicadores.setText(mensajeFinal);
    }

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteDeObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteDeObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteDeObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteDeObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteDeObjetos().setVisible(true);
            }
        });
    }

    private void funcionalidadCorba() {

        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            vec[1] = "localhost";
            vec[2] = "-ORBInitialPort";
            vec[3] = "2020";

            // crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // obtiene la base del naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
           
            
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            
            //Instancia el servant
            PacienteCllbckImpl pacback = new PacienteCllbckImpl(txtAreaCallback);
            //Obtiene las referencias del rootPOA y acttive el POAManager
            org.omg.CORBA.Object ref1 = rootPOA.servant_to_reference(pacback);
            href1 = PacienteCllbckIntHelper.narrow(ref1);
            

            
            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "ges-alertas";
            ref = GestionAlertasIntHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
        } catch (Exception e) {
            System.err.println("Error al momento de iniciarlizar Corba: "+e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboTipoEdad;
    private javax.swing.JLabel imagenEPS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logocorazon;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtAreaCallback;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumHabitacion;
    private javax.swing.JTextArea txtarea_indicadores;
    // End of variables declaration//GEN-END:variables

    private void inhabilitarComponentes() {
        this.txtNumHabitacion.setEnabled(false);
        this.txtNombre.setEnabled(false);
        this.txtApellido.setEnabled(false);
        this.comboTipoEdad.setEnabled(false);
        this.txtEdad.setEnabled(false);
        this.btnGuardar.setEnabled(false);
    }

    private void fijarImagenesEnElFormulario() {
        Image img = new ImageIcon(this.getClass().getResource("img/logo.png")).getImage();
        this.imagenEPS.setIcon(new ImageIcon(img));
        Image img2 = new ImageIcon(this.getClass().getResource("img/corazon.png")).getImage();
        this.logocorazon.setIcon(new ImageIcon(img2));
    }

    private boolean validarFormulario() {
        boolean formularioCorrecto=true;
        if((this.txtEdad.getText().equals("") || this.txtNombre.getText().equals("") || this.txtApellido.getText().equals("") || this.txtEdad.getText().equals(""))){
            formularioCorrecto  = false;
            JOptionPane.showMessageDialog(this, "El formulario se encuentra incompleto...");
        }
        try {
            float edad = Float.parseFloat(txtEdad.getText());
            int numHabitacion = Integer.parseInt(txtNumHabitacion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad y/o la habitación deben ser números.");
            formularioCorrecto = false;
        }
        return formularioCorrecto;
    }
}