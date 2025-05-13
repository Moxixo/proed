/*
 * 
 */
package info_pacientes;


import java.util.ArrayList;
import data.Afeccion;
import java.io.Serializable;
/**
 *
 * @author Marta Lou
 */
public class HistorialClinico implements Serializable{
    
    protected String id; //El id nos ayudará a diferenciar los historiales
    protected ArrayList<Informe> antecedentes; 
    protected ArrayList<Afeccion> alergias;
    protected ArrayList<Afeccion> enfermedadesCronicas;
    
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

    public void setAntecedentes(ArrayList<Informe> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public ArrayList<Afeccion> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Afeccion> alergias) {
        this.alergias = alergias;
    }

    public ArrayList<Afeccion> getEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }

    public void setEnfermedadesCronicas(ArrayList<Afeccion> enfermedadesCronicas) {
        this.enfermedadesCronicas = enfermedadesCronicas;
    }
    
    
    //Métodos
    
    public void aniadirInforme(Informe nuevoInforme){
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
    
    public void aniadirEnfermedad(Afeccion enfermedad){
        if(!enfermedad.getTipo().equalsIgnoreCase("alergia")){
            enfermedadesCronicas.add(enfermedad);
            System.out.println(enfermedad.getNombre() + " ha sido añadida");
        }
        else{
            System.out.println(enfermedad.getNombre() + " se trata de una alergia. Porfavor vuelvalo a intentar");
  
        }
    }
    
    public void aniadirAlergia(Afeccion alergia){
        if(alergia.getTipo().equalsIgnoreCase("alergia")){
            alergias.add(alergia);
            System.out.println(alergia.getNombre() + " ha sido añadida");
        }
        else{
            System.out.println(alergia.getNombre() + " se trata de otro tipo de afeccion. Porfavor vuelvalo a intentar");
        }
    }
}
