/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author aisuw
 */
public class MaterialMedico {
    protected String nombre;
    protected int cantidad;
    protected boolean usando;
    
    public MaterialMedico(String nombre,int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.usando=false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isUsando() {
        return usando;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setUsando(boolean usando) {
        this.usando = usando;
    }
    
    public void alternarEstado(){
        if(this.usando){
            System.out.println("El objeto estaba siendo usado.");
            this.usando=false;
            System.out.println("Se ha modificado a sin usar");
        }else{
            System.out.println("El objeto estaba sin usar.");
            this.usando=true;
            System.out.println("Se ha modificado a usando");
        }
    }
    
}
