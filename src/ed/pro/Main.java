/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ed.pro;

import FicherosDatos.*;
import areas.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static Hospital hospi= null;
    static String ruta="src/prueba/hospital.dat";
    static File fichero= new File(ruta);
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //controlar si el archivo ya tenia archivos o esta vacío.
        inicioPrograma();
        
        
    }
    
    
    public static void inicioPrograma(){
        if(fichero.exists()){
            hospi=GestionBBDD.leerFichero(ruta);
        }else{
            BBDD.datosBase(hospi);
            GestionBBDD.aniadirFichero(hospi,ruta);
            hospi=GestionBBDD.leerFichero(ruta);
        }
    }
    
    public static void finPrograma(){
        GestionBBDD.aniadirFichero(hospi,ruta);
    }
}
