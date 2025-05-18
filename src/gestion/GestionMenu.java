/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import areas.Hospital;
import java.util.Scanner;

/**
 *
 * @author aisuw
 */
public class GestionMenu {
    static Scanner sc= new Scanner(System.in);
    
    
    private static void  ingresarPaciente(Hospital hospi){
        boolean salir=false;
        do{
            Menu.ingresarPacientes();
            int[] ingresar={0,1,2};
            int opcion=Menu.isInt(ingresar);
            switch(opcion){
                //
                case 1:
                
                    break;
                //
                case 2:
                    
                    break;
                //
                case 0:
                    salir=true;
                    break;
            }
        }while(!salir);
    }
    
    
    
    
    
    
    private static void verEstado(Hospital hospi){
        boolean salir=false;
        do{
            Menu.verEstado();
            int[] verE={0,1,2,3};
            int opcion=Menu.isInt(verE);
            switch(opcion){
                //Disponibilidad camas
                case 1:
                    dispoCama(hospi);
                    break;
                    
                //Disponibilidad equipos medicos
                case 2:
                    equiposMed(hospi);
                    break;
                    
                //Disponibilidad personal
                case 3:
                    verPersonal(hospi);
                    break;
                    
                //Volver
                case 0:
                    salir=true;
                    break;
            }
        }while(!salir);    
    }
    
        private static void dispoCama(Hospital hospi){
            boolean salir=false;
            do{
                Menu.verLugar();
                int[] verL={0,1,2,3};
                int opcion=Menu.isInt(verL);
                switch(opcion){
                    //UCI
                    case 1:
                        for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("UCI")){
                                hospi.getAreas().get(i).verCamasDisponibles();
                            }
                        }
                        break;
                        
                    //Urgencias
                    case 2:
                        for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("Urgencias")){
                                hospi.getAreas().get(i).verCamasDisponibles();
                            }
                        }
                        break;
                        
                    //Plantas
                    case 3:
                        System.out.println("No hay plantas disponibles en este momento");
                        //listarPlantas
                        //selecciona una String nombre= plantaSeleccionada;
                        /*for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase(nombre)){
                                hospi.getAreas().get(i).verCamasDisponibles();
                            }
                        }*/
                        break;
                    //Volver
                    case 0:
                        salir=true;
                        break;
                    
                }
            }while(!salir);
        }
        
        private static void equiposMed(Hospital hospi){
            boolean salir=false;
            do{
                Menu.verLugar();
                int[] verL={0,1,2,3};
                int opcion=Menu.isInt(verL);
                switch(opcion){
                    //UCI
                    case 1:
                        for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("UCI")){
                                System.out.println("Equipos medicos disponibles en la UCI");
                                System.out.println("_______________________________________________");
                                for(int j=0;j< hospi.getAreas().get(i).getMateriales().size();j++){
                                    if(!hospi.getAreas().get(i).getMateriales().get(j).isUsando()){
                                        System.out.println("Nombre: " + hospi.getAreas().get(i).getMateriales().get(j).getNombre()+"    Cantidad: " +hospi.getAreas().get(i).getMateriales().get(j).getCantidad());
                                    }
                                }
                            }
                        }
                        break;
                        
                    //Urgencias
                    case 2:
                        for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("Urgencias")){
                                System.out.println("Equipos medicos disponibles en la Urgencias");
                                System.out.println("_______________________________________________");
                                for(int j=0;j< hospi.getAreas().get(i).getMateriales().size();j++){
                                    if(!hospi.getAreas().get(i).getMateriales().get(j).isUsando()){
                                        System.out.println("Nombre: " + hospi.getAreas().get(i).getMateriales().get(j).getNombre()+"    Cantidad: " +hospi.getAreas().get(i).getMateriales().get(j).getCantidad());
                                    }
                                }
                            }
                        }
                        break;
                        
                    //Plantas
                    case 3:
                        System.out.println("No hay plantas disponibles en este momento");
                        //listarPlantas
                        //selecciona una String nombre= plantaSeleccionada;
                        /*for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase(nombre)){
                                System.out.println("Equipos medicos disponibles en la Urgencias");
                                System.out.println("_______________________________________________");
                                for(int j=0;j< hospi.getAreas().get(i).getMateriales().size();j++){
                                    if(!hospi.getAreas().get(i).getMateriales().get(j).isUsando()){
                                        System.out.println("Nombre: " + hospi.getAreas().get(i).getMateriales().get(j).getNombre()+"    Cantidad: " +hospi.getAreas().get(i).getMateriales().get(j).getCantidad());
                                    }
                                }
                            }
                        }*/
                        break;
                    //Volver
                    case 0:
                        salir=true;
                        break;
                    
                }
            }while(!salir);
        }
        
        private static void verPersonal(Hospital hospi){
            boolean salir=false;
            do{
                Menu.verLugar();
                int[] verL={0,1,2,3};
                int opcion=Menu.isInt(verL);
                switch(opcion){
                    //UCI
                    case 1:
                        for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("UCI")){
                                System.out.println("Medicos disponibles en la UCI");
                                System.out.println("_______________________________________________");
                                for(int j=0;j< hospi.getAreas().get(i).getMedicos().size();j++){
                                    System.out.println("Nombre: " + hospi.getAreas().get(i).getMedicos().get(j).getNombre()+"    DNI: " +hospi.getAreas().get(i).getMedicos().get(j).getDni());
                                }
                            }
                        }
                        break;
                        
                    //Urgencias
                    case 2:
                        for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("Urgencias")){
                                System.out.println("Medicos disponibles en la Urgencias");
                                System.out.println("_______________________________________________");
                                for(int j=0;j< hospi.getAreas().get(i).getMedicos().size();j++){
                                    System.out.println("Nombre: " + hospi.getAreas().get(i).getMedicos().get(j).getNombre()+"    DNI: " +hospi.getAreas().get(i).getMedicos().get(j).getDni());
                                }
                            }
                        }
                        break;
                        
                    //Plantas
                    case 3:
                        System.out.println("No hay plantas disponibles en este momento");
                        //listarPlantas
                        //selecciona una String nombre= plantaSeleccionada;
                        /*for(int i= 0 ; i< hospi.getAreas().size() ; i++){
                            if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase(nombre)){
                                System.out.println("Medicos disponibles en la Urgencias");
                                System.out.println("_______________________________________________");
                                for(int j=0;j< hospi.getAreas().get(i).getMedicos().size();j++){
                                    System.out.println("Nombre: " + hospi.getAreas().get(i).getMedicos().get(j).getNombre()+"    DNI: " +hospi.getAreas().get(i).getMedicos().get(j).getDni());
                                }
                            }
                        }*/
                        break;
                    //Volver
                    case 0:
                        salir=true;
                        break;
                    
                }
            }while(!salir);
        }
    
    
    
    
    private static void actualizarPaciente(Hospital hospi){
        boolean salir=false;
        do{
            Menu.actualizarPaciente();
            int[] actualizarP={0,1,2,3};
            int opcion=Menu.isInt(actualizarP);
            switch(opcion){
                //Actualizar datos paciente
                case 1:
                    actDataPaciente(hospi);        
                    break;
                    
                //Actualizar historial
                case 2:
                    actHistorial(hospi);        
                    break;
                            
                //Actualizar informe
                case 3:
                    actInforme(hospi);        
                    break;
                            
                //Volver
                case 0:
                    salir=true;
                    break;
            } 
        }while(!salir);
    }
    
        private static void actDataPaciente(Hospital hospi){
            boolean salir= false;
            do{
                Menu.actualizarDatosP();
                int[] actDataP={0,1,2};//faltaria de implementar el 3
                int opcion=Menu.isInt(actDataP);
                switch(opcion){
                    //Estado
                    case 1:
                        actEstado(hospi);
                        break;

                    //Constantes
                    case 2:
                        actConstantes(hospi);
                        break;

                    /*//Prioridad
                    case 3:
                        actPrioridad(hospi);
                        break;*/

                    //Volver
                    case 0:
                        salir=true;
                        break;
                }
            }while(!salir);
        }
    
            private static void actEstado(Hospital hospi){
                boolean enLista=false;
                do{
                    System.out.println("Introduzca el dni del paciente");
                    String dni1=sc.nextLine();
                    if(hospi.obtenerPaciente(dni1)!=null){
                        enLista=true;
                        hospi.obtenerPaciente(dni1).actualizarEstadoPaciente();
                        hospi.obtenerPaciente(dni1).mostrarEstadoPaciente();
                    }else{
                        System.out.println("Asegurese de que el dni sea correcto");
                    }
                }while(!enLista);
            }
            
            private static void actConstantes(Hospital hospi){
                boolean enLista=false;
                do{
                    System.out.println("Introduzca el dni del paciente");
                    String dni1=sc.nextLine();
                    if(hospi.obtenerPaciente(dni1)!=null){
                        enLista=true;
                        hospi.obtenerPaciente(dni1).modificarConstantes();
                        hospi.obtenerPaciente(dni1).mostrarConstantes();
                    }else{
                        System.out.println("Asegurese de que el dni sea correcto");
                    }
                }while(!enLista);
            }
            
            private static void actPrioridad(Hospital hospi){
                System.out.println("Por implementar");
            }
    
        private static void actHistorial(Hospital hospi){
            boolean salir= false;
            do{
                Menu.actualizarHistorial();
                int[] actHist={0,1,2};
                int opcion=Menu.isInt(actHist);
                switch(opcion){
                    //Aniadir enfermedad
                    case 1:
                        aniadirEnf(hospi);                
                        break;
                    //Aniadir alergia
                    case 2:
                        aniadirAlergy(hospi);                
                        break;
                    //Volver
                    case 0:
                        salir=true;
                        break;
                }
            }while(!salir);
    }
        
            private static void aniadirEnf(Hospital hospi){
        boolean enLista=false;
        do{
            System.out.println("Introduzca el dni del paciente");
            String dni1=sc.nextLine();
            if(hospi.obtenerPaciente(dni1)!=null){
                enLista=true;
                hospi.obtenerPaciente(dni1).getHistorial().aniadirEnfermedad();
            }else{
                System.out.println("Asegurese de que el dni sea correcto");
            }
        }while(!enLista);
    }
    
            private static void aniadirAlergy(Hospital hospi){
        boolean enLista=false;
        do{
            System.out.println("Introduzca el dni del paciente");
            String dni1=sc.nextLine();
            if(hospi.obtenerPaciente(dni1)!=null){
                enLista=true;
                hospi.obtenerPaciente(dni1).getHistorial().aniadirEnfermedad();
            }else{
                System.out.println("Asegurese de que el dni sea correcto");
            }
        }while(!enLista);
    }
        
        private static void actInforme(Hospital hospi){
            boolean salir= false;
            do{
                Menu.actualizarInforme();
                int[] actInf={0,1,2};
                int opcion=Menu.isInt(actInf);

                    switch(opcion){
                        //Aniadir sintoma
                        case 1:
                            aniadirSin(hospi);
                            break;

                        //Aniadir procedimiento
                        case 2:
                            aniadirProd(hospi);
                            break;

                        //Volver
                        case 0:
                            salir=true;
                            break;
                    }
            }while(!salir);
    }
    
            private static void aniadirSin(Hospital hospi){
        boolean enLista= false;
        do{
            System.out.println("Introduzca el dni del paciente");
            String dni1=sc.nextLine();
            if(hospi.obtenerPaciente(dni1)!=null){
                enLista=true;
                int idInforme=hospi.obtenerPaciente(dni1).getHistorial().obtenerIdInforme();
                hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(idInforme).aniadirSintoma();
            }else{
                System.out.println("Asegurese de que el dni sea correcto");
            }
        }while(!enLista);
    }
    
            private static void aniadirProd(Hospital hospi){
        boolean enLista=false;
        do{
            System.out.println("Introduzca el dni del paciente");
            String dni1=sc.nextLine();
                if(hospi.obtenerPaciente(dni1)!=null){
                    enLista=true;
                    int idInforme=hospi.obtenerPaciente(dni1).getHistorial().obtenerIdInforme();
                    hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(idInforme).aniadirProcedimiento();
                }else{
                    System.out.println("Asegurese de que el dni sea correcto");
                }
        }while(!enLista);                          
    }
}   

