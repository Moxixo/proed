package personas;

import areas.Area;
import areas.Hospital;

/**
 *
 * @author Sheila R.
 */
public class Medico extends Persona {
    protected String especialidad;
    protected Area area;

    //Constructores
    
    
    
    public Medico(String nombre, String apellido, String especialidad, Hospital hospi) {
        super(nombre, apellido, hospi);
        this.especialidad = especialidad;
    }
    
    //Getters y setters
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    
}
