/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import areas.Area;
import areas.Hospital;
import java.util.Scanner;
import personas.Paciente;

/**
 *
 * @author Marta L.
 */
public class GestionMenu {
    static Scanner sc= new Scanner(System.in);
    
    public static void inicio(Hospital hospi){
        boolean salir= false;
        do{
            Menu.inicial();
            int[] inicial= {0,1,2,3};
            int opcion1= Menu.isInt(inicial);
            switch(opcion1){
                //Ingresar paciente
                case 1:
                    ingresarPaciente(hospi);
                    break;
                //Actualizar paciente
                case 2:
                    actualizarPaciente(hospi);
                    break;
                //Ver Estado
                case 3:
                    verEstado(hospi);
                    break;
                //Salir
                case 0:
                    System.out.println("El programa va a cerrarse");
                    salir= true;
                    break;
            }
        }while(!salir);
    }
    
    private static void  ingresarPaciente(Hospital hospi){
        boolean salir=false;
        do{
            Menu.ingresarPacientes();
            int[] ingresar={0,1,2};
            int opcion=Menu.isInt(ingresar);
            switch(opcion){
                //Triaje(urgencias)
                case 1:
                    ingresarTriaje(hospi);
                    break;
                //Trasladar nueva Area
                case 2:
                    trasladarArea(hospi);
                    break;
                //
                case 0:
                    salir=true;
                    break;
            }
            
        }while(!salir);
    }
    
        private static void ingresarTriaje(Hospital hospi){
                boolean enLista=false;
                boolean atendido=false;
                do{
                    System.out.println("Introduzca el dni del paciente");
                    String dni=sc.nextLine();
                    
                    if(hospi.obtenerPaciente(dni)!=null){ 
                        enLista=true;
                        for(int i=0; i<hospi.getAreas().size();i++){
                            for(int j=0; j<hospi.getAreas().get(i).getPacientes().size(); j++){
                                if(hospi.getAreas().get(i).getPacientes().get(j).getDni().equalsIgnoreCase(dni)){
                                    System.out.println("Ya se encuentra atendido en el hospital");
                                    System.out.println("Nombre: "+ hospi.getAreas().get(i).getPacientes().get(j).getNombre() +" "+ hospi.getAreas().get(i).getPacientes().get(j).getApellido() +"   DNI: " + hospi.getAreas().get(i).getPacientes().get(j).getDni() +"    Area: "+hospi.getAreas().get(i).getNombre());
                                        atendido=true;
                                }
                            }
                    }
                        if(!atendido){
                            hospi.obtenerPaciente(dni).registrarPaciente();
                            if(hospi.obtenerPaciente(dni).getCodigo().equalsIgnoreCase("rojo")){
                                System.out.format("""
                                                  \n\n
                                                  CODIGO ROJO
                                                  CODIGO ROJO
                                                  CODIGO ROJO
                                                  \n\n
                                                  Trasladar automaticamente a box.
                                                  **Estaría sonando una alarma, pero no sabemos como implementarlo**
                                                  """);
                                for(int i =0; i<hospi.getAreas().size();i++){
                                    if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("Urgencias")){
                                        hospi.getAreas().get(i).aniadirPaciente(hospi.obtenerPaciente(dni));
                                        hospi.getAreas().get(i).asignarCamaDisponible(hospi.getAreas().get(i).getPacientes().getLast());
                                    }
                            }
                            }else{
                                hospi.getAreas().get(0).aniadirPaciente(hospi.obtenerPaciente(dni));   
                            }
                        }else{
                            System.out.println("No se realizan cambios");
                            break;
                        }
                    }else{
                        System.out.println("No hay nadie con ese dni en nuestro sistema");
                        System.out.println("Introduzca los datos que se le requieran para aniadirlo a nuestro sistema");
                        System.out.println("Introduzca el nombre");
                        String nombre=sc.nextLine();
                        System.out.println("Introduzca el apellido");
                        String apellido=sc.nextLine();
                        Paciente p1=new Paciente(nombre,apellido,dni,hospi);
                        if(hospi.obtenerPaciente(p1.getDni())!=null){
                            enLista=true;
                            hospi.obtenerPaciente(p1.getDni()).registrarPaciente();
                            if(hospi.obtenerPaciente(p1.getDni()).getCodigo().equalsIgnoreCase("rojo")){
                                System.out.format("""
                                                  \n\n
                                                  CODIGO ROJO
                                                  CODIGO ROJO
                                                  CODIGO ROJO
                                                  \n\n
                                                  Trasladar automaticamente a box.
                                                  **Estaría sonando una alarma, pero no sabemos como implementarlo**
                                                  """);
                                for(int i =0; i>hospi.getAreas().size();i++){
                                    if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase("Urgencias")){
                                        hospi.getAreas().get(i).aniadirPaciente(hospi.obtenerPaciente(p1.getDni()));
                                        hospi.getAreas().get(i).asignarCamaDisponible(hospi.getAreas().get(i).getPacientes().getLast());
                                    }
                            }
                            }else{
                                hospi.getAreas().get(0).aniadirPaciente(hospi.obtenerPaciente(p1.getDni()));   
                            }
                            
                        }else{
                            System.out.println("Error no se aniadio");
                        }
                    }
                }while(!enLista);  
        }
        
        private static void trasladarArea(Hospital hospi){
            boolean enLista=false;
            do{
                System.out.println("Introduzca el dni del paciente");
                String dni=sc.nextLine();
                if(hospi.obtenerPaciente(dni)!=null){  
                    for(int i=0; i<hospi.getAreas().size();i++){
                        for(int j=0; j<hospi.getAreas().get(i).getPacientes().size(); j++){
                            if(hospi.getAreas().get(i).getPacientes().get(j).getDni().equalsIgnoreCase(dni)){
                                hospi.getAreas().get(i).getPacientes().remove(j);
                                break;
                            }
                        }
                    }
                    boolean plantaCorrecta=false;
                    do{
                    System.out.println("Introduzca el nombre de la nueva area");
                    String nuevaArea=sc.nextLine();
                    for(int i = 0; i<hospi.getAreas().size();i++){
                        if(hospi.getAreas().get(i).getNombre().equalsIgnoreCase(nuevaArea)){
                            hospi.getAreas().get(i).aniadirPaciente(hospi.obtenerPaciente(dni));
                            plantaCorrecta=true;
                            enLista=true;
                            break;
                        }else if(!hospi.getAreas().get(i).getNombre().equalsIgnoreCase(nuevaArea)&&i==(hospi.getAreas().size()-1)){
                            System.out.println("Error nombre nueva planta");
                            plantaCorrecta=false;
                            /*for(int j = 0; j<hospi.getAreas().size();j++){
                                
                                System.out.println(hospi.getAreas().get(i).getNombre());
                            }*/
                        }
                    }
                    }while(!plantaCorrecta);
                } 
                else{
                    System.out.println("Introduzca un dni correcto porfavor");
                }
            }while(!enLista);
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
                                    if(hospi.getAreas().get(i).getMateriales().get(j).getCantidad()>0){
                                        System.out.println("Nombre: " + hospi.getAreas().get(i).getMateriales().get(j).getNombre()+"    Cantidad: " +(hospi.getAreas().get(i).getMateriales().get(j).getCantidad()-hospi.getAreas().get(i).getMateriales().get(j).getUsando()));
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
                                    if(hospi.getAreas().get(i).getMateriales().get(j).getCantidad()>0){
                                        System.out.println("Nombre: " + hospi.getAreas().get(i).getMateriales().get(j).getNombre()+"    Cantidad: " +(hospi.getAreas().get(i).getMateriales().get(j).getCantidad()-hospi.getAreas().get(i).getMateriales().get(j).getUsando()));
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
                                    if(hospi.getAreas().get(i).getMateriales().get(j).getCantidad()>0){
                                        System.out.println("Nombre: " + hospi.getAreas().get(i).getMateriales().get(j).getNombre()+"    Cantidad: " +(hospi.getAreas().get(i).getMateriales().get(j).getCantidad()-hospi.getAreas().get(i).getMateriales().get(j).getUsando()));
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
                int[] actDataP={0,1,2,3};//faltaria de implementar el 3
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

                    //Prioridad
                    case 3:
                        System.out.println("No esta implementado actualmente");
                        //actPrioridad(hospi);
                        break;

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
                hospi.obtenerPaciente(dni1).getHistorial().aniadirAlergia();
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
        boolean enLista=false;
        do{
            System.out.println("Introduzca el dni del paciente");
            String dni1=sc.nextLine();
                if(hospi.obtenerPaciente(dni1)!=null){
                    enLista=true;
                    int idInforme=hospi.obtenerPaciente(dni1).getHistorial().obtenerIdInforme();
                    boolean salir=false;
                    
                do{
                    
                System.out.println("Introduce el id del Informe a modificar");
                int id=sc.nextInt();
                
                for(int i=0; i<hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().size();i++){
                    if(id==hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(i).getId()){
                    System.out.println("Introduzca el sintoma");
                    sc.nextLine();
                    String sintom=sc.nextLine();
                    hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(id).getSintomas().add(sintom);
                    System.out.println("sintoma aniadido");
                salir=true;
                break;
                    }else if(i==(hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().size()-1) && id!=hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(i).getId()){
                        System.out.println("No encontrado");
                        salir=false;
                        break;
                    }
                    else{
                        salir=false;
                    }
                }
                    }while(!salir);
                    
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
                    boolean salir=false;
                    
                do{
                    
                System.out.println("Introduce el id del Informe a modificar");
                int id=sc.nextInt();
                
                for(int i=0; i<hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().size();i++){
                    if(id==hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(i).getId()){
                    System.out.println("Introduzca el procedimiento");
                    sc.nextLine();
                    String sintom=sc.nextLine();
                    hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(id).getProcedimientos().add(sintom);
                    System.out.println("Procedimiento aniadido");
                salir=true;
                break;
                    }else if(i==(hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().size()-1) && id!=hospi.obtenerPaciente(dni1).getHistorial().getAntecedentes().get(i).getId()){
                        System.out.println("No encontrado");
                        salir=false;
                        break;
                    }
                    else{
                        salir=false;
                    }
                }
                    }while(!salir);
                    
                }else{
                    System.out.println("Asegurese de que el dni sea correcto");
                }
        }while(!enLista);                          
    }
}   

