package personas;

import areas.Area;

/**
 *
 * @author Sheila R.
 */
public class Medico extends Persona {
    private String especialidad;
    protected Area area;

    //Constructores
    
    public Medico(){
        
    }
    
    public Medico(String dni, String nombre, String apellido, String especialidad) {
        super(dni, nombre, apellido);
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
