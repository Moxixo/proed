/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import personas.Paciente;

/**
 *
 * @author Carlos D.HD
 */
public class Cama {
    
    /*ATRIBUTOS*/
    protected Paciente paciente; //Paciente asignado a la cama
    protected boolean disponible;

    /*CONSTRUCTORES*/
    public Cama() {
    }

    public Cama(Paciente paciente, boolean disponible) {
        this.paciente = paciente;
        this.disponible = disponible;
    }
    
    /*GETTERS Y SETTERS*/
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
