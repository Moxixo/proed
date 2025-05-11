/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info_pacientes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import personas.Medico;

/**
 *
 * @author aelit
 */
public class Informe implements Serializable{
    
    protected int id;
    protected Medico medico; //Medico el cual ha iniciado el informe
    protected LocalDate fechaIncio;
    protected LocalDate fechaFinal;
    protected ArrayList<String> sintomas;
    protected String motivoInicial;
    protected ArrayList<String> procedimientos;//igual otro tipo de lista una que ordene
    protected boolean abierto;
    
    public Informe(int id, LocalDate fechaIncio,Medico medico) {
        this.id = id;
        this.medico = medico;
        this.fechaIncio = fechaIncio;
        this.abierto = true;
    }
    
    /*
    aniadirProcedimiento(comprobar antes que esta abierto
    aniadirSintoma(comprobar antes que esta abierto
    */

    
}
