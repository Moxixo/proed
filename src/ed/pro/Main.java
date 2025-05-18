/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ed.pro;

import FicherosDatos.*;
import areas.*;
import gestion.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
        
        inicioPrograma();
        GestionMenu.inicio(hospi);
        finPrograma();
        
    }
    
    /**
     * El metodo comprueba si existe el fichero y si existe carga el objeto. 
     * En caso contrario carga la base de datos, la guarda en el fichero y lo carga del fichero.
    **/
    public static void inicioPrograma(){
        if(fichero.exists()){
            hospi=GestionBBDD.leerFichero(ruta);
        }else{
            BBDD.datosBase(hospi);
            GestionBBDD.aniadirFichero(hospi,ruta);
            hospi=GestionBBDD.leerFichero(ruta);
        }
    }
    
    /**
     * El metodd carga el objeto en el fichero
     */
    public static void finPrograma(){
        GestionBBDD.aniadirFichero(hospi,ruta);
    }
}
