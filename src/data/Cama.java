/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import personas.Paciente;

/**
 *
 * @author Sheila R.
 */
public class Cama {
    protected Paciente paciente; //Paciente asignado a la cama
    protected boolean disponible;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean libre) {
        this.disponible = libre;
    }
    
    
}
