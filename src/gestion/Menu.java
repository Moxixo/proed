package gestion;

import java.util.Scanner;

/**
 *
 * @author Marta Lou
 */
public class Menu {
    
    public static Scanner sc= new Scanner(System.in);
    
    public static void inicial(){
        System.out.format("""
                          \n
                          *******************************
                          *      ¿QUE DESEAS HACER?     *
                          *******************************
                          *   1-Ingresar paciente       *
                          *   2-Actualizar paciente     *
                          *   3-Ver estado              *
                          *                             *
                          *   0-Salir                   *
                          *******************************
                          \n
                          """);
    }
    
    public static void ingresarPacientes(){
        System.out.format("""
                          \n
                          *********************************
                          *      ¿QUE DESEAS HACER?       *
                          *********************************
                          *   1-Triaje(Urgencias)         *
                          *   2-Trasladar area            *
                          *                               *
                          *   0-Volver                    *
                          *********************************
                          \n
                          """);
    }
    
    public static void verEstado(){
        System.out.format("""
                          \n
                          ******************************
                          *      ¿QUE DESEAS VER?      *
                          ******************************
                          *   1-Disponibilidad camas   *
                          *   2-Equipos médicos        *
                          *   3-Personal               *
                          *                            *
                          *   0-Volver                 *
                          ******************************
                          \n
                          """);
    }
    
    public static void verLugar(){
        System.out.format("""
                          ************************
                          *    ¿DE QUE LUGAR?    *
                          ************************
                          *   1-UCI              *
                          *   2-Urgencias        *
                          *   3-Plantas          *
                          *                      *
                          *   0-Volver           *
                          ************************
                          \n
                          """);
    }
    
    public static void actualizarPaciente(){
        System.out.format("""
                          \n
                          *******************************
                          *      ¿QUE DESEAS HACER?     *
                          *******************************
                          *   1-Actualizar estado       *
                          *   2-Actualizar historial    *
                          *   3-Actualizar informe      *
                          *                             *
                          *   0-Volver                  *
                          *******************************
                          \n
                          """);
    }
    
    public static void actualizarHistorial(){
        System.out.format("""
                          \n
                          *********************************
                          *       ¿QUE DESEAS HACER?      *
                          *********************************
                          *   1-Aniadir enfermedades      *
                          *   2-Aniadir alergias          *
                          *                               *
                          *   0-Volver                    *
                          *                               *
                          *********************************
                          *     No se pueden eliminar     *
                          *      afecciones cronicas      *
                          *        debe seguir el         *
                          *      protocolo estipulado     *
                          *                               *
                          *********************************
                          \n""");
    }
    
    public static void actualizarDatosP(){
        System.out.format("""
                          \n
                          *********************************
                          *       ¿QUE DESEAS HACER?      *
                          *********************************
                          *   1-Actualizar estado         *
                          *   2-Actualizar constantes     *
                          *   3-Actualizar prioridad      *
                          *                               *
                          *   0-Volver                    *
                          *********************************
                          \n""");
    }
    
    public static void actualizarInforme(){
        System.out.format("""
                          \n
                          *********************************
                          *       ¿QUE DESEAS HACER?      *
                          *********************************
                          *   1-Aniadir sintoma           *
                          *   2-Aniadir procedimiento     *
                          *                               *
                          *   0-Volver                    *
                          *                               *
                          *********************************
                          *      No se puede cerrar       *
                          *   un informe si el paciente   *
                          *       no tiene el alta        *
                          *     o ha sido trasladado      *
                          *         a otra area           *
                          *********************************
                          \n""");
    }
    
    /**
     * Metodo para asegurar que lo que se introduce es int para controlar los menus, repitiendo el proceso hasta que lo sea
     * @params int[] opciones Se pasa un array de numeros para controlar que esta entre las opciones del menu 
     * @return int opcion 
     */
    public static int isInt(int[] opciones){
        boolean entradaValida= false;
        int opcion=5;
        do {
            
            if (sc.hasNextInt()) {
                // Si es un número, lo leemos
                opcion = sc.nextInt();
                for(int i= 0 ; i<opciones.length ; i++){
                    if(i==opcion){
                        entradaValida = true;
                        break;
                    }else if(i==(opciones.length-1)&& i!=opcion){
                        System.out.println("Introduzca la opcion");
                        entradaValida=false;
                    }
                }
            } else {
                // Si no es un número, mostramos error y limpiamos el buffer
                System.out.println("Entrada no válida. Por favor, introduzca un número.");
                break;
            }
            
        } while(!entradaValida);
        sc.nextLine();
        return opcion;
        
        }
    }

