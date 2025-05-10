/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package personas;

import java.time.LocalDate;

/**
 *
 * @author s3ira
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Datos de ejemplo para el paciente
        String dni = "12345678A";
        String nombre = "María";
        String apellido = "González";

        // Crear el paciente con el constructor proporcionado
        Paciente paciente = new Paciente(dni, nombre, apellido);
        
        paciente.addConstantes();
        
        //paciente.modificarConstantes();
        
        //paciente.mostrarConstantes();
        
        paciente.actualizarEstadoPaciente();
        
        paciente.mostrarEstadoPaciente();
    }
    
}
