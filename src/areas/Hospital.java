/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areas;

import java.util.ArrayList;
import java.util.HashMap;
import personas.*;

/**
 *
 * @author s3ira
 */
public class Hospital {
        
    ArrayList <Area> areas;
    HashMap<String,Persona> personasTotal;
    
    
    public Hospital(){
        ArrayList<Area> areas = new ArrayList <Area>();
        this.areas=areas;
    }
    
    public void mapaHospital(){
    
        
        for (Area a : areas){
        
            System.out.println("=================");
            System.out.println("=== " + a +  " ===");
            System.out.println("=================");
        }
    
    }
    
    public void aniadirArea(Area area){
    
        areas.add(area);
        
    }
    
    public ArrayList <Area> getAreas(){
        
        return areas;
        
    }
    
    
    public void aniadirPacienteHospital(Persona persona){
        personasTotal.put(persona.getDni(), persona);
    }
    
    public boolean existeDni(String dni){
        boolean existe = false;
        
        for (String id : personasTotal.keySet()) {
            if(dni.equalsIgnoreCase(id)){
                existe = true;
            }
        }
        return existe;
    }
}

