/*
 * 
 */
package info_pacientes;


import areas.Hospital;
import java.util.ArrayList;
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
    protected ArrayList<String> alergias;
    protected ArrayList<String> enfermedadesCronicas;
    
    public HistorialClinico(String id){
        this.id= id;
        ArrayList<Informe> antecedentes = new ArrayList(); 
        ArrayList<String> alergias= new ArrayList();
        ArrayList<String> enfermedadesCronicas= new ArrayList();
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

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public ArrayList<String> getEnfermedadesCronicas() {
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
     */
    public void aniadirEnfermedad(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzca la enfermedad a aniadir");
        String nuevaEnfermedad=sc.nextLine();
        boolean existe= false;
        for(String enfermedad: enfermedadesCronicas){
            if(nuevaEnfermedad.equalsIgnoreCase(enfermedad)){
                existe=true;
                break;
            }
        }
        if(existe){
            System.out.println("La enfermedad ya fue añadida");
        }
        else{
            this.enfermedadesCronicas.add(nuevaEnfermedad);
        }
        
    }
    
    public void aniadirAlergia(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzca la alergia a aniadir");
        String alergia=sc.nextLine();
        boolean existe =false;
        for(String enfermedad: alergias){
            if(alergia.equalsIgnoreCase(enfermedad)){
                existe=true;
                break;
            }
        }
        if(existe){
            System.out.println("La alergia ya fue añadida");
        }
        else{
            this.alergias.add(alergia);
        }
    }
    
    private Informe crearInforme(Hospital hospi){
        int id=0;
        if(antecedentes.isEmpty()){
            id=000;
        }else{
            id = (antecedentes.get(antecedentes.size()).getId())+1;
        }
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
    
    public int obtenerIdInforme(){
        Scanner sc= new Scanner(System.in);
        int obtenido=0;
        boolean abierto=false;
        for(int i=0; i<this.antecedentes.size();i++){
            if(antecedentes.get(i).getIsAbierto()){
                System.out.println("Id: " + antecedentes.get(i).getId() + " con fecha de inicio: " +antecedentes.get(i).getFechaInicio());
                abierto=true;
            }
        }
        
        return obtenido;
    }
}
