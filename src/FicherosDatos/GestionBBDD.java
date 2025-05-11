/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosDatos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author aisuw
 */
public class GestionBBDD {
    
    
    
    public static void crearFichero(String rutaFichero){
        File archivo = new File(rutaFichero);
        
        if(!archivo.exists()) {
            try{
                boolean creado = archivo.createNewFile();
                if(creado){
                    System.out.println("Fichero creado: " + archivo.getAbsolutePath());
                }
                else{
                    System.out.println("No se pudo crear el fichero");
                }
            }catch(IOException e){
                System.out.println("ERROR Al crear el fichero");
            }
        }
        else{
            System.out.println("El fichero ya existe");
        }
    }
}
