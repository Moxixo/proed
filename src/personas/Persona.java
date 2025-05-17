package personas;

import areas.Hospital;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Sheila R.
 */
public abstract class Persona implements Serializable {
    protected String dni;
    protected String nombre;
    protected String apellido;
    
    public Persona(Hospital hospi){
        boolean existe=false;
        String dni;
        do{
            dni = crearId();
            existe=hospi.existeDni(dni);
        }while(existe);
        this.dni=dni;
        hospi.aniadirPacienteHospital(this);
    }
    
    public Persona(String nombre, String apellido,Hospital hospi){
        boolean existe=false;
        String dni;
        do{
            dni = crearId();
            existe=hospi.existeDni(dni);
        }while(existe);
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        hospi.aniadirPacienteHospital(this);
    }

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
      
    private String crearId(){    
        Random random =new Random();
        String id="";
        boolean igual = true;
            for (int i = 0; i<5; i++){
                if(i==4){
                    char letra=(char) ('A'+ random.nextInt(26));
                    id+= letra;
                }
                else{
                    id+= random.nextInt(10);
                } 
            }
        return id;
    }
}
