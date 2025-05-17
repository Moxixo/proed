/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosDatos;

import static FicherosDatos.GestionBBDD.*;
import areas.*;
import java.util.HashSet;
import java.util.Set;
import personas.*;

/**
 *
 * @author Marta Lou
 */
public class BBDD {
    
    
    
    
    public static void datosBase(Hospital hospi){
    
        Area urgencias= new Area();
        
        
        Area boxVital= new Area();
        
        
        Medico drASloan= new Medico(hospi);
        drASloan.setNombre("Alexander");
        drASloan.setApellido("Sloan");
        drASloan.setEspecialidad("Urgencias");
        
        Medico drZShepherd= new Medico(hospi);
        drZShepherd.setNombre("Zola");
        drZShepherd.setApellido("Shepherd");
        drZShepherd.setEspecialidad("Neurologia");
        
        Paciente alinaB= new Paciente(hospi);
        alinaB.setNombre("Alina");
        alinaB.setApellido("Black");
        alinaB.setHistorial("AB0");
        alinaB.setMedico(drZShepherd);
        
        Paciente jackL= new Paciente(hospi);
        jackL.setNombre("Jack");
        jackL.setApellido("Lupin");
        jackL.setHistorial("JL0");
        jackL.setMedico(drASloan);
    }
    
    
}
    

