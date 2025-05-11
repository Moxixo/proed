/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info_pacientes;


import java.util.ArrayList;
import data.Afeccion;
import java.io.Serializable;
/**
 *
 * @author aelit
 */
public class HistorialClinico implements Serializable{
    
    protected String id; //El id nos ayudará a diferenciar los historiales
    protected ArrayList<Informe> antecedentes; 
    protected ArrayList<Afeccion> alergias;
    protected ArrayList<Afeccion> enfermedadesCronicas;
    
    
    //Métodos
    
    public void aniadirInforme(){
        
    }
}
