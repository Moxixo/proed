/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

/**
 *
 * @author aelit
 */
public class Menu {
    
    public void inicial(){
        System.out.format("""
                          \n
                          *******************************
                          *     SELECIONA QUE HACER     *
                          *******************************
                          *   1-Administrar paciente    *
                          *   2-Ver disponibilidad...   *
                          *******************************
                          \n
                          """);
    }
    
    public void administrarPacientes(){
        System.out.format("""
                          \n
                          *********************************
                          *     SELECCIONA QUE HACER      *
                          *********************************
                          *   1-Ingresar paciente         *
                          *   2-Modificar informe         *
                          *   3-Redirigir a otra Unidad   *
                          *   4-Hospitalizar paciente     *
                          *   5-Dar Alta                  *
                          *   0-Volver                    *
                          *********************************
                          \n
                          """);
    }
    
    public void verDisponibilidad(){
        System.out.format("""
                          \n
                          En este menú podrás ver la disponibilidad de los equipos, 
                          personal, etc de las diferentes áreas.
                          
                          ************************
                          *  SELECIONA UN AREA   *
                          ************************
                          *   1-Sala de espera   *
                          *   2-Urgencias        *
                          *   3-Otras plantas    *
                          *   0-Volver           *
                          ************************
                          \n
                          """);
    }
    
    public void disponibilidadPlantas(){
        System.out.format("""
                          \n
                          ************************
                          *  SELECIONA UN AREA   *
                          ************************
                          *   1-UCI              *
                          *   2-Urgencias        *
                          *   3-Plantas          *
                          *   0-Volver           *
                          ************************
                          \n
                          """);
    }
}
