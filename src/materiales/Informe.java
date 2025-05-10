/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiales;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author aelit
 */
public class Informe {
    
    protected int id;
    protected LocalDate fechaIncio;
    protected LocalDate fechaFinal;
    protected ArrayList<String> sintomas;
    protected String motivoInicial;
    protected ArrayList<String> procedimientos;//igual otro tipo de lista una que ordene
    protected boolean abierto;
    
    public Informe(int id, LocalDate fechaIncio, ArrayList<String> sintomas, String motivoInicial, ArrayList<String> procedimientos) {
        this.id = id;
        this.fechaIncio = fechaIncio;
        this.sintomas = sintomas;
        this.motivoInicial = motivoInicial;
        this.procedimientos = procedimientos;
        this.abierto=true;
    }
    
    /*
    aniadirProcedimiento(comprobar antes que esta abierto
    aniadirSintoma(comprobar antes que esta abierto
    */

    
}
