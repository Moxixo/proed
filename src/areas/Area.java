/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areas;

import data.Cama;
import personas.Medico;

/**
 *
 * @author s3ira
 */
public class Area {
    protected int tipo; //Quirófano, habitación, sala, box...
    protected String nombre;
    protected Cama[] camas; //Placeholder, elegir coleccion conveniente
    protected Medico[] medicos; //Placeholder, elegir coleccion conveniente
}
