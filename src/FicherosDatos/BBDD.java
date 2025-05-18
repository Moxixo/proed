/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosDatos;

import static FicherosDatos.GestionBBDD.*;
import areas.*;
import data.*;
import info_pacientes.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import personas.*;

/**
 *
 * @author Marta Lou
 */
public class BBDD {
   
    
    public static void datosBase(Hospital hospi){
        MaterialMedico mm1=new MaterialMedico("Guantes nitrilo",100);
        mm1.setUsando(5);
        MaterialMedico mm2=new MaterialMedico("Vendaje compresivo",50);
        MaterialMedico mm3=new MaterialMedico("Fonendo",10);
        mm3.setUsando(1);
        MaterialMedico mm4=new MaterialMedico("Ecografo",3);
        MaterialMedico mm5=new MaterialMedico("Apositos",300);
        MaterialMedico mm6=new MaterialMedico("Sondas",90);
        mm6.setUsando(33);
        MaterialMedico mm7=new MaterialMedico("Tensiometro",5);
        MaterialMedico mm8=new MaterialMedico("Agua oxigenada",25);
        mm8.setUsando(3);
        MaterialMedico mm9=new MaterialMedico("Alcohol de curar",35);
        mm9.setUsando(8);
        
        
        
        
        
        
        
        Medico m1= new Medico("Zola","Shepherd","Neurologia",hospi);
        Medico m2= new Medico("Belinda","Gordon","Psicologia",hospi);
        Medico m3= new Medico("Percy","Jackson","Urgencias",hospi);
        Medico m4= new Medico("Ryshand","Grey","Urgencias",hospi);
        
        Paciente p1= new Paciente("Alina","Black",hospi);
        p1.registrarPaciente();
        p1.getHistorial().getAlergias().add("Latex");
        p1.getHistorial().getAlergias().add("Acaros");
        p1.getHistorial().getAlergias().add("Ibuprofeno");
        p1.getHistorial().getEnfermedadesCronicas().add("Migrañas");
        Informe i1=new Informe(1,LocalDate.of(2025, 5, 12) ,m1,"Dolores fuertes que perduran en el tiempo");
        Informe i2=new Informe(0,LocalDate.of(2011, 11, 25),m3,"Rojeces intensas y ardor en las manos,tras ponerse unos guantes de latex");
        i1.getSintomas().add("Dolor que palpita o late");
        i1.getSintomas().add("Sensibilidad a la luz");
        i1.getProcedimientos().add("Escaner del cerebro");
        i2.setFechaFinal(LocalDate.of(2011,11,25));
        i2.getSintomas().add("Manchas y rojeces");
        i2.getSintomas().add("Picazon");
        i2.getProcedimientos().add("Pruebas de alergia");
        i2.getProcedimientos().add("Antiestaminicos recetados");
        i2.setAbierto(false);
        p1.getHistorial().getAntecedentes().add(i2);
        p1.getHistorial().getAntecedentes().add(i1);
        
        Paciente p2= new Paciente("Jack","Lupin",hospi);
        p2.registrarPaciente();
        p2.getHistorial().getAlergias().add("Penicilina");
        p2.getHistorial().getAlergias().add("Ibuprofeno");
        p2.getHistorial().getEnfermedadesCronicas().add("Ansiedad");
        Informe i3=new Informe(1,LocalDate.of(2025, 5, 12) ,m2,"Taquicardia y falta de aire prolongada");
        Informe i4=new Informe(0,LocalDate.of(2015, 10, 6),m4,"Manchas y rojeces en la espalda que perduran en el tiempo y pican");
        i4.setFechaFinal(LocalDate.of(2015,10,8));
        i4.getSintomas().add("Manchas y rojeces");
        i4.getSintomas().add("Picazon");
        i4.getProcedimientos().add("Pruebas de alergia");
        i4.getProcedimientos().add("Antiestaminicos recetados");
        i4.setAbierto(false);
        i3.getSintomas().add("Palpitaciones");
        i3.getSintomas().add("Dificultad para concentrarse");
        i3.getProcedimientos().add("Charla con la Psicologa: DraGordon");
        i3.getProcedimientos().add("Ansioliticos recetados");
        p2.getHistorial().getAntecedentes().add(i4);
        p2.getHistorial().getAntecedentes().add(i3);
        
        Paciente p3= new Paciente("Paco","De La Robia",hospi);
        p3.getHistorial().getAlergias().add("Gato");
        Informe i5=new Informe(0,LocalDate.of(2011, 2, 20),m3,"Posible reaccion alergica");
        i5.setFechaFinal(LocalDate.of(2011,2,20));
        i5.getSintomas().add("Estornudos");
        i5.getSintomas().add("Picazon");
        i5.getSintomas().add("Ojos llorosos");
        i5.getProcedimientos().add("Pruebas de alergia");
        i5.getProcedimientos().add("Antiestaminicos recetados");
        i5.setAbierto(false);
        p3.getHistorial().getAntecedentes().add(i5);
        
        Paciente p4=new Paciente("Bibi","Stern",hospi);
        p4.getHistorial().getEnfermedadesCronicas().add("Depresion severa");
        Informe i6=new Informe(0,LocalDate.of(2006, 7, 17),m2,"Encontrada inconsciente, consumo de estupefacientes");
        i6.setFechaFinal(LocalDate.of(2006,7,27));
        i6.getProcedimientos().add("Lavado de estomago");
        i6.getProcedimientos().add("Movida e ingresada a planta para surpervision");
        i6.getProcedimientos().add("Charlas con la psicologa: DraGordon");
        i6.getProcedimientos().add("Receta de antidepresivos y ansioliticos con visitas continuas al psicologo");
        i6.setAbierto(false);
        p4.getHistorial().getAntecedentes().add(i6);
        
        
        
        
        
        
        
        Area urgencias=new Area(1,"Urgencias");
        m3.setArea(urgencias);
        m2.setArea(urgencias);
        urgencias.aniadirMedico(m2);
        urgencias.aniadirMedico(m3);
        urgencias.aniadirPaciente(p2);
        urgencias.getMateriales().add(mm2);
        urgencias.getMateriales().add(mm4);
        urgencias.getMateriales().add(mm6);
        urgencias.getMateriales().add(mm7);
        urgencias.getMateriales().add(mm8);
        
        hospi.aniadirArea(urgencias);
        
        Area uci=new Area(1,"UCI");
        m1.setArea(uci);
        m4.setArea(uci);
        uci.aniadirMedico(m1);
        uci.aniadirMedico(m4);
        uci.aniadirPaciente(p1);
        uci.getMateriales().add(mm1);
        uci.getMateriales().add(mm3);
        uci.getMateriales().add(mm9);
        uci.getMateriales().add(mm5);
        
        hospi.aniadirArea(uci);
    }
}
    

