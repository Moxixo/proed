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
    protected LocalDate fechaIncio;
    protected LocalDate fechaFinal;
    protected ArrayList<String> sintomas;
    protected String motivoInicial;
    protected ArrayList<String> procedimientos;//igual otro tipo de lista una que ordene
    protected boolean abierto;
    
    public Informe (){
        
    }
    public Informe( LocalDate fechaIncio, Medico medico, String motivoInicial) {
        this.id = id;//se autogenera viendo cual es el ultimo id de fichero
        this.fechaIncio = fechaIncio;
        this.abierto = true;
        this.medico = medico;
        this.motivoInicial=motivoInicial;
    }
    
    
    public void aniadirProcedimiento(){//(comprobar antes que esta abierto
        if(this.abierto){
            Scanner sc = new Scanner(System.in);
            String procedimiento;
            boolean salir= false;
            boolean right= false;
            do{
                System.out.println("Por favor introduzca el procedimiento");
                procedimiento=sc.nextLine();
                do{
                    System.out.println("Quiere aniadir " + procedimiento +", si es correcto pulse 'S' . Si no lo es pulse 'N' .");
                    String correcto=sc.nextLine();
                    if(correcto.equalsIgnoreCase("S")||correcto.equalsIgnoreCase("s")){
                        right=true;
                        procedimientos.add(procedimiento);
                        System.out.println("Se aniadio el procedimiento: " + procedimiento);
                        salir=true;
                    }    
                    else if(correcto.equalsIgnoreCase("N")|| correcto.equalsIgnoreCase("n")){
                        right=true;
                        System.out.println("Asegurese de introducirlo de nuevo.");
                        salir=false;
                    }
                    else{
                        System.out.println("Porfavor introduzca correctamente la letra");
                    }
                }while(!right);
            }
            while(!salir);
        }else{
            System.out.println("El informe no se encuentra abierto. Fue cerrado a fecha: "+this.fechaFinal);
            System.out.println("Asegure que se trata del informe correcto");
        }
    }
    public void aniadirSintoma(){//(comprobar antes que esta abierto, sobrescribir fichero donde se guarda)
        if(this.abierto){
            Scanner sc = new Scanner(System.in);
            String sintoma;
            boolean salir= false;
            boolean right= false;
            do{
                System.out.println("Por favor introduzca el sintoma");
                sintoma=sc.nextLine();
                do{
                    System.out.println("Quiere aniadir " + sintoma +", si es correcto pulse 'S' . Si no lo es pulse 'N' .");
                    String correcto=sc.nextLine();
                    if(correcto.equalsIgnoreCase("S")||correcto.equalsIgnoreCase("s")){
                        right=true;
                        sintomas.add(sintoma);
                        System.out.println("Se aniadio el sintoma: " + sintoma);
                        salir=true;
                    }    
                    else if(correcto.equalsIgnoreCase("N")|| correcto.equalsIgnoreCase("n")){
                        right=true;
                        System.out.println("Asegurese de introducirlo de nuevo.");
                        salir=false;
                    }
                    else{
                        System.out.println("Porfavor introduzca correctamente la letra");
                    }
                }while(!right);
            }
            while(!salir);
        }else{
            System.out.println("El informe no se encuentra abierto. Fue cerrado a fecha: "+this.fechaFinal);
            System.out.println("Asegure que se trata del informe correcto");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(LocalDate fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public String getMotivoInicial() {
        return motivoInicial;
    }

    public void setMotivoInicial(String motivoInicial) {
        this.motivoInicial = motivoInicial;
    }

    public ArrayList<String> getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(ArrayList<String> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }
    
    
    
}
