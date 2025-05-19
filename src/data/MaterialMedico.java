/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;

/**
 *
 * @author Marta Lou
 */
public class MaterialMedico implements Serializable{
    protected String nombre;
    protected int cantidad;
    protected int usando;
    
    public MaterialMedico(String nombre,int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.usando=0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getUsando() {
        return usando;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setUsando(int usando) {
        this.usando = usando;
    }
    
    
}
