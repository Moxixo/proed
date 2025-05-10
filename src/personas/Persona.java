/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personas;

/**
 *
 * @author Sheila R.
 */
public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String apellido;
    
    
    public Persona(String dni, String nombre, String apellido){
        this.dni=dni;//comprobar que no se repita
        this.nombre=nombre;
        this.apellido=apellido;
    }
      
}
