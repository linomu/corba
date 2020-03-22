/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorDeAlertas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import ServidorNotificaciones.dto.ClsIndicadoresRegistros;
import java.util.ArrayList;

/**
 *
 * @author Lino Alejandro Munoz
 */
public class ClsPersistencia {
    
    private String cwd;
    private String nombreArchivo;
    private File f;

    public ClsPersistencia() {
        
         this.f = new File("ZColeccionCarros.txt");
        /*this.cwd = new File("").getAbsolutePath();
        this.nombreArchivo="historialDeAlertas.txt";
        this.f = new File(this.cwd+"/"+this.nombreArchivo);*/
    }
    

    public void GuardarRegistro(ClsIndicadoresRegistros registro) {
        try {
            
            
            FileWriter fw;
            BufferedWriter bw;
            if (f.exists() && f.length() != 0) {
                System.out.println("LLENE POR IF");
                fw = new FileWriter(f, true);//True para que no sobreescriba el objeto anterior, con el true va añadiendo en vez de sobreescribir
                bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(String.valueOf(registro.getNumHabitacion()) + "%"+ registro.getNombre()+ "%" +registro.getApellidos()+ "%"+ String.valueOf(registro.getFecha()) + "%" + registro.getHora() + "%" + registro.getPuntuacion());

            } else {
                System.out.println("LLENE POR ELSE");
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
                bw.write(String.valueOf(registro.getNumHabitacion()) + "%"+ registro.getNombre()+ "%" +registro.getApellidos()+ "%"+ String.valueOf(registro.getFecha()) + "%" + registro.getHora() + "%" + registro.getPuntuacion());

            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<ClsIndicadoresRegistros> LeerRegistros(String numHabitacionArg) {
        
        
        System.out.println("Estoy leyendo el archivo");
        ClsIndicadoresRegistros auxRegistro;
        ArrayList<ClsIndicadoresRegistros> listaRegistros = new ArrayList<>();

        try {
             if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    //Continue mientras tenga algo en la linea
                    String[] registro = linea.split("%");

                    String numHabitacion = registro[0];
                    String nombre = registro[1];
                    String apellidos = registro[2];
                    String fecha = registro[3];
                    String hora = registro[4];
                    String puntuacion = registro[5];
                    //Recupero solo las alertas del paciente en cuestion
                    if (numHabitacionArg.equals(numHabitacion)) {

                        auxRegistro = new ClsIndicadoresRegistros(numHabitacion, nombre, apellidos, fecha, hora, puntuacion);
                        listaRegistros.add(auxRegistro);
                    }

                }
            } else {
                System.out.println("No hay carros gurdados");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaRegistros;
    }
    
    public ArrayList<Integer> LeerNumerosHabitacion() {
        ArrayList<Integer> listaNumerosHabitacion = new ArrayList<>();

        try {
           

            if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    //Continue mientras tenga algo en la linea
                    String[] registro = linea.split("%");

                    String numHabitacion = registro[0];
                    int numeroHabitacion = Integer.parseInt(numHabitacion);
                   
                    //Recupero solo las alertas del paciente en cuestion
                    if (!(listaNumerosHabitacion.contains(numHabitacion))) {
                         listaNumerosHabitacion.add(numeroHabitacion);
                    }

                }
            } else {
                System.out.println("No hay carros gurdados");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaNumerosHabitacion;
    }

}
