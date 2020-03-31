/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorDeAlertas.dto;

import ServidorNotificaciones.dto.ClsIndicadoresAlerta;
import java.io.Serializable;
import java.util.ArrayList;
import servidorDeAlertas.sop_corba.PacienteDTO;

/**
 *
 * @author Lino Alejandro Munoz
 */
public class GestionAlertaIndicadores implements Serializable {

    /*Este método tienen como finalidad recibir el objPaciente, revisar los indicadores a través de sus variables y 
       retornar una lista con que contiene en forma de objetos las alertas que no están dentro del rango establecido*/

    private ArrayList<ClsIndicadoresAlerta> listaIndicadoresAlerta = new ArrayList<>();
    private PacienteDTO objPaciente;

    public GestionAlertaIndicadores(PacienteDTO objPaciente) {
        this.objPaciente = objPaciente;
    }

    public ArrayList<ClsIndicadoresAlerta> llenarListaConIndicadores() {

        if (objPaciente.saturacionOxigeno < 95 || objPaciente.saturacionOxigeno > 100) {
            ClsIndicadoresAlerta objIndicadorSaturacion = new ClsIndicadoresAlerta("Saturacion de Oxigeno", String.valueOf(objPaciente.saturacionOxigeno));
            listaIndicadoresAlerta.add(objIndicadorSaturacion);
            System.out.println("Alerta de Saturaciòn");
        }
        //Edad Nacimiento - 6 Semanas
        if (objPaciente.edad > 0 && objPaciente.edad <= 1) {
            llenarIndicadoresNacimiento6Semanas();
        }
        //Edad 1 año - 2 año
        if (objPaciente.edad > 1 && objPaciente.edad <= 2) {
            llenarIndicadores1anio2anio();

        }
        //Edad 2 año - 6 año
        if (objPaciente.edad > 2 && objPaciente.edad <= 6) {
            llenarIndicadores2anio6anios();

        }
        //Edad 6 año - 13 años
        if (objPaciente.edad > 6 && objPaciente.edad <= 13) {
            llenarIndicadores6anios13anios();

        }
        //Edad 13 año - 16 años
        if (objPaciente.edad > 13 && objPaciente.edad <= 16) {
            llenarIndicadores13anios16anios();

        }

        //Edad 16 años o mas
        if (objPaciente.edad > 16) {
            llenarIndicadoresMas16anios();

        }

        return listaIndicadoresAlerta;

    }

    private void llenarIndicadoresNacimiento6Semanas() {
        if (objPaciente.frecuenciaCardiaca < 100 || objPaciente.frecuenciaCardiaca > 140) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 70 || objPaciente.sistolica > 106 || objPaciente.diastolica < 50 || objPaciente.diastolica > 70) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 20 || objPaciente.frecuenciaRespiratoria > 45) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura < 37.5 || objPaciente.temperatura > 38) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }

    }

    private void llenarIndicadores6Semanas1Semanas() {
        if (objPaciente.frecuenciaCardiaca < 100 || objPaciente.frecuenciaCardiaca > 140) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 70 || objPaciente.sistolica > 106 || objPaciente.diastolica < 50 || objPaciente.diastolica > 70) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 20 || objPaciente.frecuenciaRespiratoria > 45) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura < 37.5 || objPaciente.temperatura > 38) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }
    }

    private void llenarIndicadores1anio2anio() {
        if (objPaciente.frecuenciaCardiaca < 100 || objPaciente.frecuenciaCardiaca > 120) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 98 || objPaciente.sistolica > 106 || objPaciente.diastolica < 58 || objPaciente.diastolica > 70) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 20 || objPaciente.frecuenciaRespiratoria > 30) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura < 37.5 || objPaciente.temperatura > 37.8) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }
    }

    private void llenarIndicadores2anio6anios() {
        if (objPaciente.frecuenciaCardiaca < 80 || objPaciente.frecuenciaCardiaca > 120) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 99 || objPaciente.sistolica > 112 || objPaciente.diastolica < 64 || objPaciente.diastolica > 70) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 20 || objPaciente.frecuenciaRespiratoria > 30) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura < 37.5 || objPaciente.temperatura > 37.8) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }
    }

    private void llenarIndicadores6anios13anios() {
        if (objPaciente.frecuenciaCardiaca < 80 || objPaciente.frecuenciaCardiaca > 100) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 104 || objPaciente.sistolica > 124 || objPaciente.diastolica < 64 || objPaciente.diastolica > 86) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 12 || objPaciente.frecuenciaRespiratoria > 20) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura < 37 || objPaciente.temperatura > 37.5) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }
    }

    private void llenarIndicadores13anios16anios() {
        if (objPaciente.frecuenciaCardiaca < 70 || objPaciente.frecuenciaCardiaca > 80) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 118 || objPaciente.sistolica > 132 || objPaciente.diastolica < 70 || objPaciente.diastolica > 82) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 12 || objPaciente.frecuenciaRespiratoria > 20) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura != 37) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }
    }

    private void llenarIndicadoresMas16anios() {
        if (objPaciente.frecuenciaCardiaca < 60 || objPaciente.frecuenciaCardiaca > 80) {
            ClsIndicadoresAlerta objIndicadorFrecuencia = new ClsIndicadoresAlerta("Frecuencia Cardiaca", String.valueOf(objPaciente.frecuenciaCardiaca));
            listaIndicadoresAlerta.add(objIndicadorFrecuencia);
            System.out.println("Alerta de Frecuencia Cardiaca");
        }
        if (objPaciente.sistolica < 110 || objPaciente.sistolica > 140 || objPaciente.diastolica < 70 || objPaciente.diastolica > 90) {
            ClsIndicadoresAlerta objIndicadorPresion = new ClsIndicadoresAlerta("Presion Arterial", String.valueOf(objPaciente.sistolica) + "/" + String.valueOf(objPaciente.diastolica));
            listaIndicadoresAlerta.add(objIndicadorPresion);
            System.out.println("Alerta por Presion Arterial");
        }
        if (objPaciente.frecuenciaRespiratoria < 12 || objPaciente.frecuenciaRespiratoria > 20) {
            ClsIndicadoresAlerta objIndicadorFreResp = new ClsIndicadoresAlerta("Frecuencia Respiratoria", String.valueOf(objPaciente.frecuenciaRespiratoria));
            listaIndicadoresAlerta.add(objIndicadorFreResp);
            System.out.println("Alerta por Frecuencia Respiratoria");
        }
        if (objPaciente.temperatura < 36.2 || objPaciente.temperatura > 37.2) {
            ClsIndicadoresAlerta objIndicadorTemp = new ClsIndicadoresAlerta("Temperatura", String.valueOf(objPaciente.temperatura));
            listaIndicadoresAlerta.add(objIndicadorTemp);
            System.out.println("Alerta por Temperatura");
        }
    }

}
