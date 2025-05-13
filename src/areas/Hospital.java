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
    Area urgencias = new Area(1,"Urgencias");
    Area uci = new Area(2,"UCI");
    
    
    public Hospital(){
    
        areas = new ArrayList <Area>();
        
        areas.add(urgencias);
        areas.add(uci);
        
    
    }
    
    public void mapaHospital(){
    
        for (Area a : areas){
        
            System.out.println("=================");
            System.out.println("=== " + a +  " ===");
            System.out.println("=================");
        }
    
    }
     
}

