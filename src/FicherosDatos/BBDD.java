/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosDatos;

import static FicherosDatos.GestionBBDD.*;
import areas.Area;
import java.util.HashSet;
import java.util.Set;
import personas.*;

/**
 *
 * @author aisuw
 */
public class BBDD {
    private static final String FICHERO_INFORME ="informe.txt";
    private static final String FICHERO_HISTORIAL="historiales.txt";
    private static final String FICHERO_PERSONA="personas.txt";
    private static final String FICHERO_AREA="areas.txt";
    
    public static void crearBBDD(){
        crearFichero(FICHERO_INFORME);
        crearFichero(FICHERO_HISTORIAL);
        crearFichero(FICHERO_PERSONA);
        crearFichero(FICHERO_AREA);
    }
    
    
    
    private static void datosBase(){
    
        
        Area urgencias= new Area();
        
        
        Area boxVital= new Area();
        
        
        Medico drASloan= new Medico();
        drASloan.setDni("0000M");
        drASloan.setNombre("Alexander");
        drASloan.setApellido("Sloan");
        drASloan.setArea(urgencias);
        drASloan.setEspecialidad("Urgencias");
        
        Medico drZShepherd= new Medico();
        drZShepherd.setDni("0001M");
        drZShepherd.setNombre("Zola");
        drZShepherd.setApellido("Shepherd");
        drZShepherd.setArea(boxVital);
        drZShepherd.setEspecialidad("Neurologia");
        
        Paciente alinaB= new Paciente();
        alinaB.setDni("1111A");
        alinaB.setNombre("Alina");
        alinaB.setApellido("Black");
        alinaB.setIdHistorial("0AB");
        alinaB.setMedico(drZShepherd);
        
        Paciente jackL= new Paciente();
        jackL.setDni("2222B");
        jackL.setNombre("Jack");
        jackL.setApellido("Lupin");
        jackL.setIdHistorial("0JL");
        jackL.setMedico(drASloan);
    }
    
    
}
    

