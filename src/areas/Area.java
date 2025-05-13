/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areas;

import data.Cama;
import java.util.ArrayList;
import personas.Medico;
import personas.Paciente;

/**
 *
 * @author Kevin M.
 */
public class Area {
    
    //FALTA LOS GETTERS DE LA CLASE DE CAMAS
    
    protected int tipo; //Quirófano, habitación, sala, box...
    protected String nombre;
    protected ArrayList<Cama> camas = new ArrayList<>();
    protected ArrayList<Medico> medicos = new ArrayList<>();
    protected ArrayList<Paciente> pacientes = new ArrayList<>();

    public Area(){
        ArrayList<Medico> medicos = new ArrayList<>();
        this.medicos=medicos;
        ArrayList<Paciente> pacientes = new ArrayList<>();
        this.pacientes=pacientes;
        
        ArrayList<Cama> camas = new ArrayList<>();
        this.camas=camas;
        Cama cama1 = new Cama();//De momento tenemos un supuesto de 5 camas por area creada
        Cama cama2 = new Cama();
        Cama cama3 = new Cama();
        Cama cama4 = new Cama();
        Cama cama5 = new Cama();
        camas.add(cama1);
        camas.add(cama2);
        camas.add(cama3);  
        camas.add(cama4);
        camas.add(cama5);
    }
    
    public Area(int tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        
        ArrayList<Medico> medicos = new ArrayList<>();
        this.medicos=medicos;
        ArrayList<Paciente> pacientes = new ArrayList<>();
        this.pacientes=pacientes;
        
        ArrayList<Cama> camas = new ArrayList<>();
        this.camas=camas;
        Cama cama1 = new Cama();//De momento tenemos un supuesto de 5 camas por area creada
        Cama cama2 = new Cama();
        Cama cama3 = new Cama();
        Cama cama4 = new Cama();
        Cama cama5 = new Cama();
        camas.add(cama1);
        camas.add(cama2);
        camas.add(cama3);  
        camas.add(cama4);
        camas.add(cama5);
        
    }

    public void verCamas() {

        System.out.println("=================== " + this.nombre + " ====================");
        System.out.println("====== Camas Disponibles en este momento ======");
        System.out.println("");
        for (Cama aux : camas) {

            if (aux.getPaciente() != null) {

                System.out.println(aux + " " + aux.getPaciente());
                System.out.println("===============================================");

            } else {

                System.out.println(aux);
                System.out.println("===============================================");

            }
        }

    }

    public void verCamasDisponibles() {

        System.out.println("=================== " + this.nombre + " ====================");
        System.out.println("====== Camas Disponibles en este momento ======");
        System.out.println("");
        for (Cama aux : camas) {

            if (aux.getDisponible()) {
                System.out.println(aux);
            }
            System.out.println("===============================================");
        }

    }

    public void asignarCamaDisponible(Paciente paciente) {

        boolean aux = false;
        
        for (Cama c : camas) {
            if (c.getPaciente() != null && c.getPaciente().equals(paciente)) {
                System.out.println("ESTE PACIENTE YA TIENE UNA CAMA");
                aux=true;
            }
        }

        for (Cama c : camas) {
            if (c.getDisponible() && c.getPaciente() == null && !aux) {
                c.setPaciente(paciente);
                c.setDisponible(false);
                System.out.println("PACIENTE ASIGNADO CORRECTAMENTE");
                aux = true;
            }
        }

        if (!aux) {
            System.out.println("NO HAY CAMAS DISPONIBLES PARA ASIGNAR ESTE PACIENTE");
        }
    }

    public void desasignarCama(Paciente paciente) {

        boolean encontrado = false;

        for (Cama c : camas) {

            if (c.getPaciente() != null && c.getPaciente().equals(paciente)) {

                c.setDisponible(true);
                c.setPaciente(null);
                System.out.println("EL PACIENTE SE HA DESASIGNADO CORRECTAMENTE");
                encontrado = true;
            }
        }

        if (!encontrado) {

            System.out.println("EL PACIENTE NO ESTA EN NINGUNA CAMA DE ESTE AREA");
        }

    }
    
    public void aniadirMedico(Medico medico){
    
        medicos.add(medico);
    }
    
    public void aniadirPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    
    public void aniadirCama(Cama cama){
        camas.add(cama);
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cama> getCamas() {
        return camas;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
