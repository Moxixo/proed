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
    
    
    public static void aniadirFichero(Hospital hospi, String ruta){
        File fichero = new File(ruta);
        if(fichero.exists()){
            escribirHospital(fichero,hospi);
        }else{
            crearFichero(fichero);
            escribirHospital(fichero,hospi);
        }
    }
    
    
    public static void escribirHospital(File fichero,Hospital hospi){
        try{MiObjectOutputStream oos = new MiObjectOutputStream( new FileOutputStream (fichero));
                oos.writeObject(hospi);
                System.out.println("Fichero escrito");
                oos.close();
            } catch (IOException ex) {
                System.out.println("Error Fatal");
            }
    }
    
    public static Hospital leerFichero(String ruta){
        Hospital hospi= null;
        File fichero= new File(ruta);
        if(fichero.exists()){
            hospi=leerHospital(fichero);
        }else{
            System.out.println("No existe el fichero, no se puede leer");
        }
        
        return hospi;
    }
    
    public static Hospital leerHospital(File fichero){
        Hospital hospi= null;
        try{ObjectInputStream oos = new ObjectInputStream( new FileInputStream (fichero));
                hospi=(Hospital) oos.readObject();
                oos.close();
            } catch (IOException ex) {
                System.out.println("Error Fatal");
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontrada");
            }
        return hospi;
    }
}
