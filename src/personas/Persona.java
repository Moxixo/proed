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
