package personas;

import areas.Hospital;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sheila R.
 */
public abstract class Persona implements Serializable {
    protected String dni;
    protected String nombre;
    protected String apellido;
    
    public Persona(String nombre, String apellido,String dni,Hospital hospi){
        
        this.dni=asegurarId(dni);
        this.nombre=nombre;
        this.apellido=apellido;
        hospi.aniadirPersonaHospital(this);
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
        hospi.aniadirPersonaHospital(this);
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
    
    private String asegurarId(String dni){
        Scanner sc= new Scanner(System.in);
        String dniCorrect=null;
        String regex = "\\d{3}[A-Z]";
        if(dni != null && dni.matches(regex)){
            return dniCorrect=dni;
        }else{
            boolean correcto= false;
            do{
                System.out.println("El dni es incorrecto porfavor introduzca un id correcto como seria: '000A'");
                String newDni=sc.nextLine();
                if(newDni != null && newDni.matches(regex)){
                    correcto=true;
                    return dniCorrect=newDni;
                }else{
                    correcto=false;
                }    
            }while(!correcto);
        }
        return dniCorrect;
    }
}
