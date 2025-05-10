package personas;

import areas.Area;

/**
 *
 * @author Sheila R.
 */
public class Medico extends Persona {
    protected Area area;
    protected String especialidad;

    public Medico(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }
    
    
}
