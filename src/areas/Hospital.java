/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areas;

import java.util.ArrayList;

/**
 *
 * @author s3ira
 */
public class Hospital {
        
    ArrayList <Area> areas;
    
    
    
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
     
}

