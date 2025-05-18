/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosDatos;

import areas.Hospital;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marta Lou
 */
public class GestionBBDD {
    
    
    
    public static void crearFichero(File fichero){
        try{
                boolean creado = fichero.createNewFile();
                if(creado){
                    System.out.println("Fichero creado: " + fichero.getAbsolutePath());
                }
                else{
                    System.out.println("No se pudo crear el fichero");
                }
            }catch(IOException e){
                System.out.println("ERROR Al crear el fichero");
            }
    }
    
    
    public static void aniadirFichero(Hospital hospi, File fichero){
        if(fichero.exists()){
            escribirHospital(hospi,fichero);
        }else{
            crearFichero(fichero);
            escribirHospital(hospi,fichero);
        }
    }
    
    
    public static void escribirHospital(Hospital hospi,File fichero){
        try{ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream (fichero));
                oos.writeObject(hospi);
                System.out.println("Fichero escrito");
                oos.close();
            } catch (IOException ex) {
                System.out.println("Error Fatal");
            }
    }
    
    public static Hospital leerFichero(File fichero, Hospital hospi){
        if(fichero.exists()){
            hospi=leerHospital(fichero,hospi);
        }else{
            System.out.println("No existe el fichero, no se puede leer");
        }
        
        return hospi;
    }
    
    public static Hospital leerHospital(File fichero,Hospital hospi){
        try{ObjectInputStream ios = new ObjectInputStream( new FileInputStream (fichero));
                hospi=(Hospital) ios.readObject();
                ios.close();
            } catch (IOException ex) {
                System.out.println("Error Fatal");
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontrada");
            }
        return hospi;
    }
}
