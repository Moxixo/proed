/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info_pacientes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import personas.Medico;

/**
 *
 * @author Marta Lou
 */
public class Informe implements Serializable{
    
    protected int id;
    protected Medico medico; //Medico el cual ha iniciado el informe
    protected LocalDate fechaInicio;
    protected LocalDate fechaFinal;
    protected ArrayList<String> sintomas;
    protected String motivoInicial;
    protected ArrayList<String> procedimientos;//igual otro tipo de lista una que ordene
    protected boolean abierto;
    
    
    public Informe(int id,LocalDate fechaIncio,Medico medico, String motivoInicial) {
        ArrayList<String> procedimientos= new ArrayList();
        ArrayList<String> sintomas= new ArrayList();
        this.id = id;
        this.fechaInicio = fechaIncio;
        this.abierto = true;
        this.medico = medico;
        this.motivoInicial=motivoInicial;
        this.sintomas= sintomas;
        this.procedimientos=procedimientos;
    }
    
    
    public void aniadirProcedimiento(){//(comprobar antes que esta abierto
        Scanner key = new Scanner(System.in);
        if(this.abierto){
            
            String procedimiento;
            boolean confirmado= false;
            do{
                System.out.println("Por favor introduzca el sintoma");
                procedimiento=key.nextLine();
                confirmado=confirmarAniadir(procedimiento);
            }while(enBlanco(procedimiento)&& !confirmado);
            procedimientos.add(procedimiento);
        }else{
            System.out.println("El informe no se encuentra abierto. Fue cerrado a fecha: "+this.fechaFinal);
            System.out.println("Asegure que se trata del informe correcto");
        }
        key.close();
    }
    
    public void aniadirSintoma(){
        try (Scanner key = new Scanner(System.in)) {
            if(this.abierto){
                
                String sintoma;
                
                do{
                    System.out.println("Por favor introduzca el sintoma");
                    sintoma=key.next();
                }while(enBlanco(sintoma));
                if(!enLista(sintoma,sintomas)){
                    sintomas.add(sintoma);
                }else{
                    System.out.println("Ya fue añadido");
                }
            }else{
                System.out.println("El informe no se encuentra abierto. Fue cerrado a fecha: "+this.fechaFinal);
                System.out.println("Asegure que se trata del informe correcto");
            }
        }
    }
    
    private boolean confirmarAniadir(String aniadir){
        Scanner sckey= new Scanner(System.in);
        boolean correct=false;
        boolean confirmado=false;
        do{
            System.out.println("Quiere aniadir " + aniadir +", si es correcto pulse 'Si' . Si no lo es pulse 'No' .");
            String correcto=sckey.next();
            if(correcto.equalsIgnoreCase("S")||correcto.equalsIgnoreCase("s")){
                correct=true;
                confirmado=true;
                System.out.println("Se ha aniadio");
            }    
            else if(correcto.equalsIgnoreCase("N")|| correcto.equalsIgnoreCase("n")){
                correct=true;
                System.out.println("Asegurese de introducirlo de nuevo.");
                confirmado=false;
            }
            else{
                System.out.println("Porfavor introduzca correctamente la letra");
            }
        }while(!correct);
        sckey.close();
        return confirmado;
    }
    
    private boolean enLista(String aniadir, ArrayList<String> lista){
        boolean listado=false;
        for(String aniadido: lista){
            if(aniadir.equalsIgnoreCase(aniadido)){
                System.out.println("Ya ha sido añadido");
                listado=true;
                break;
            }
            else{
                listado=false;
            }
        } 
        return listado;
    }
            
    private boolean enBlanco(String aniadir){
        return aniadir.trim().isEmpty();
    }
    
    //GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public String getMotivoInicial() {
        return motivoInicial;
    }

    public ArrayList<String> getProcedimientos() {
        return procedimientos;
    }

    public boolean getIsAbierto() {
        return abierto;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setFechaIncio(LocalDate fechaIncio) {
        this.fechaInicio = fechaIncio;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setMotivoInicial(String motivoInicial) {
        this.motivoInicial = motivoInicial;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    
    
    
    
}
