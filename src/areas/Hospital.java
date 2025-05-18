/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import personas.*;

/**
 *
 * @author Kevin Miranda
 */
public class Hospital {
        
    protected ArrayList <Area> areas;
    protected HashMap<String,Persona> personasTotal;
    
    
    public Hospital(){
        ArrayList<Area> areas = new ArrayList();
        HashMap<String,Persona> personasTotal= new HashMap();
        this.areas=areas;
        this.personasTotal=personasTotal;
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
    
    
    public void aniadirPersonaHospital(Persona persona){
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
    
    
    public void obtenerDniMedicos(){
         for (Map.Entry<String, Persona> entry : personasTotal.entrySet()) {
            Persona persona = entry.getValue();
            if (persona instanceof Medico) {
                System.out.println(persona.getNombre() + " - " + entry.getKey());
            }
        }  
    }
    
    
    public Medico obtenerMedico(String dni) {
        Persona p = personasTotal.get(dni);
        if (p instanceof Medico) {
            return (Medico) p;
        } else {
            return null;
        }
    }
    
    public Paciente obtenerPaciente(String dni) {
        Persona p = personasTotal.get(dni);
        if (p instanceof Paciente) {
            return (Paciente) p;
        } else {
            return null;
        }
    }
}

