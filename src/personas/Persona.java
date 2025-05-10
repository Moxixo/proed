package personas;

/**
 *
 * @author Sheila R.
 */
public abstract class Persona {
    private final String DNI;
    protected String nombre;
    protected String apellido;
    
    
    public Persona(String DNI, String nombre, String apellido){
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellido=apellido;
    }
      
}
