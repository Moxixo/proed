/*
 * 
 */
package info_pacientes;


import areas.Hospital;
import java.util.ArrayList;
import data.Afeccion;
import info_pacientes.Informe;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import personas.Medico;
/**
 *
 * @author Marta Lou
 */
public class HistorialClinico implements Serializable{
    
    protected String id; //El id nos ayudará a diferenciar los historiales
    protected ArrayList<Informe> antecedentes; 
    protected ArrayList<Afeccion> alergias;
    protected ArrayList<Afeccion> enfermedadesCronicas;
    
    public HistorialClinico(String id){
        this.id= id;
        ArrayList<Informe> antecedentes = new ArrayList(); 
        ArrayList<Afeccion> alergias= new ArrayList();
        ArrayList<Afeccion> enfermedadesCronicas= new ArrayList();
        this.alergias=alergias;
        this.antecedentes=antecedentes;
        this.enfermedadesCronicas= enfermedadesCronicas;
    }
    
    //Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Informe> getAntecedentes() {
        return antecedentes;
    }

    public ArrayList<Afeccion> getAlergias() {
        return alergias;
    }

    public ArrayList<Afeccion> getEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }
    
    //Métodos
    
    /**
     * AniadirInforme  permite añadir nuevos informes al ArrayList autogenerado llamado antecedentes.
     * El metodo controla si el informe ya ha sido añadido.
     * @param nuevoInforme 
     */
    public void aniadirInforme(Hospital hospi){
        Informe nuevoInforme=crearInforme(hospi);
        boolean existe= false;
        for(Informe informe: antecedentes){
            if(nuevoInforme.getId()== informe.getId()){
                existe=true;
                break;
            }
        if(existe){
            System.out.println("El informe ya fue añadido");
        }
        else{
            antecedentes.add(nuevoInforme);
            System.out.println("El informe " + nuevoInforme.getId() + " ha sido añadido");
        } 
        }
    }
    
    /**
     * AniadirEnfermedad  permite añadir nuevas afecciones del tipo enfermedad al ArrayList autogenerado llamado enfermedadesCronicas.
     * El metodo controla si la enfermedad ya ha sido añadido y si es de otro tipo que no sea enfermedad.
     * @param nuevoEnfermedad 
     */
    public void aniadirEnfermedad(Afeccion nuevaEnfermedad){
        boolean existe= false;
        for(Afeccion enfermedad: enfermedadesCronicas){
            if(nuevaEnfermedad.getNombre().equalsIgnoreCase(enfermedad.getNombre())){
                existe=true;
                break;
            }
        }
        if(existe){
            System.out.println("La enfermedad ya fue añadida");
        }
        else{
            if(!nuevaEnfermedad.getTipo().equalsIgnoreCase("Enfermedad")){
                System.out.println(nuevaEnfermedad.getNombre() + " se trata de otro tipo de afeccion. Porfavor vuelvalo a intentar");
            }
            else{
                enfermedadesCronicas.add(nuevaEnfermedad);
                System.out.println(nuevaEnfermedad.getNombre() + " ha sido añadida");
            }
        }
        
    }
    
    public void aniadirAlergia(Afeccion alergia){
        boolean existe =false;
        for(Afeccion enfermedad: enfermedadesCronicas){
            if(alergia.getNombre().equalsIgnoreCase(enfermedad.getNombre())){
                existe=true;
                break;
            }
        }
        if(existe){
            System.out.println("La enfermedad ya fue añadida");
        }
        else{
            if(alergia.getTipo().equalsIgnoreCase("Alergia")){
                alergias.add(alergia);
                System.out.println(alergia.getNombre() + " ha sido añadida");
            }
            else{
                System.out.println(alergia.getNombre() + " se trata de otro tipo de afeccion. Porfavor vuelvalo a intentar");
            }
        }
    }
    
    private Informe crearInforme(Hospital hospi){
        int id = (antecedentes.get(antecedentes.size()-1).getId())+1;
        Scanner sc = new Scanner(System.in);
        Medico m1= obtenerMedico(hospi);
        System.out.println("Introduce el motivo inicial del paciente");
        String motivo=sc.nextLine();
        Informe inf=new Informe(id,LocalDate.now(),m1,motivo);
        return inf;
    }
    
    private Medico obtenerMedico(Hospital hospi){
        Scanner sc = new Scanner(System.in);
        boolean enLista= false;
        Medico m1= null;
        do{
            System.out.println("            Lista de Medicos");
            System.out.println("________________________________________");
            hospi.obtenerDniMedicos();
            System.out.println("Porfavor introduzca el dni de uno de los antteriores medicos");
            String dni=sc.nextLine();
            sc.nextLine();
            m1=hospi.obtenerMedico(dni);
            if(m1!=null){
                System.out.println("Medico encontrado");
                enLista=true;
            }else{
                System.out.println("Asegurese de que el dni se encuentre entre los de la lista");
            }
        }while(!enLista);
        return m1;
    }
}
