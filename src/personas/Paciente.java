package personas;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sheila R.
 */
public class Paciente extends Persona{
    protected String idHistorial;
    protected int idPaciente;
    protected Medico medico;
    protected String codigo;
    protected String estado;
    protected int prioridad;
    protected float tensionArterial;
    protected int saturacion;
    protected int frecuenciaCardiaca;
    protected int frecuenciaRespiratoria;
    protected float temperatura;
    Scanner sc = new Scanner(System.in);
    
    //Constructores
    
    public Paciente(){
        
    }
    
    public Paciente(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    //Getters y setters
    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getIdHistorial(){
        return idHistorial;
    }
    
    public void setIdHistorial(String idHistorial){
        this.idHistorial = idHistorial;
    }
    
    //Métodos
    
    /**
     *Este método utiliza los métodos addConstantes y asignarCodigoColor para
     * clasificar a cada paciente
     * 
     * @param paciente
     */
    public static void registrarPaciente(Paciente paciente){
        paciente.addConstantes();
        
        String codigo = paciente.asignarCodigoColor();
        paciente.setCodigo(codigo);
        
        System.out.println("El paciente " + paciente.nombre + " " + paciente.apellido + " ha sido clasificado como: " + codigo.toUpperCase());
    }
    
    /**
     * Este método añade las constantes vitales iniciales del paciente
     * de manera aleatoria.
     * Los límites de la generación están seleccionados de manera que los valores
     * recibidos sean posibles en una persona viva.
     * 
     */
    private void addConstantes(){
        Random rd = new Random();
        
        tensionArterial = rd.nextFloat(6.4f, 20.15f);
        saturacion = rd.nextInt(85, 100);
        frecuenciaCardiaca = rd.nextInt(30, 200);
        frecuenciaRespiratoria = rd.nextInt(5, 50);
        temperatura = rd.nextFloat(33, 45);
        
        System.out.println("Constantes vitales añadidas.");
    }
    
    /**
     * Este método permite modificar las constantes vitales del paciente de manera individual.
     * Simula la monitorización de las constantes del paciente con las diferentes 
     * herramientas empleadas para esta tarea una vez está bajo vigilancia.
     * 
     * En cada uno de los casos, se controla que el input del usuario sea el correcto
     * y se informa una vez ha sido modificado el parámetro correctamente
     */
    public void modificarConstantes(){ 
        String constante;
        System.out.println("Seleccione la constante que quiere modificar:");
        System.out.println("'ta' para tensión, 'so' para saturación, 'fc' para frecuencia cardiaca, 'fr' para frecuencia respiratoria, 'temp' para temperatura");
        constante = sc.nextLine();
        while(!"ta".equalsIgnoreCase(constante) && !"so".equalsIgnoreCase(constante) && !"fc".equalsIgnoreCase(constante) && !"fr".equalsIgnoreCase(constante) && !"temp".equalsIgnoreCase(constante)){
            System.out.println("Error. Introduzca una de las opciones válidas ('ta', 'so', 'fc', 'fr' o 'temp'): ");
            constante = sc.nextLine();
        }
        switch(constante){
            //Modificar tensión arterial
            case "ta":
                System.out.println("Introduce la tensión arterial actual del paciente: ");
                while (!sc.hasNextFloat()){
                    System.out.println("Error, introduzca un valor decimal");
                    sc.next();
                }
                tensionArterial = sc.nextFloat();
                System.out.println("Tensión arterial actualizada.");
                break;
                
            //Modificar saturación de oxígeno en sangre
            case "so":
                System.out.println("Introduce la saturación de oxígeno en sangre actual del paciente: ");
                while (!sc.hasNextInt()){
                    System.out.println("Error, introduzca un valor entero");
                    sc.next();
                }
                saturacion = sc.nextInt();
                System.out.println("Saturación de oxígeno en sangre actualizada.");
                break;
                
            //Modificar frecuencia cardiaca
            case "fc":
                System.out.println("Introduce la frecuencia cardiaca actual del paciente: ");
                while (!sc.hasNextInt()){
                    System.out.println("Error, introduzca un valor entero");
                }
                frecuenciaCardiaca = sc.nextInt();
                System.out.println("Frecuencia cardiaca actualizada.");
                break;
                
            //Modificar frecuencia respiratoria
            case "fr":
                System.out.println("Introduce la frecuencia respiratoria actual del paciente: ");
                while (!sc.hasNextInt()){
                    System.out.println("Error, introduzca un valor entero");
                }
                frecuenciaRespiratoria = sc.nextInt();
                System.out.println("Frecuencia respiratoria actualizada.");
                break;
                
            //Modificar temperatura
            case "temp":
                System.out.println("Introduce la temperatura actual del paciente: ");
                while (!sc.hasNextFloat()){
                    System.out.println("Error, introduzca un valor entero");
                }
                temperatura = sc.nextFloat();
                System.out.println("Temperatura actualizada.");
                break;
        }
    }
    
    /**
     * Este método asigna un código de color (blanco, verde, amarillo, rojo)
     * según el nivel de gravedad de las constantes vitales.
     * 
     * @return el color asignado tras la comprobación
     */
    private String asignarCodigoColor() {
        int nivelRiesgo = 0;

        // Evaluación de tensión arterial
        if (tensionArterial < 6.5f || tensionArterial > 17f) nivelRiesgo++;

        // Evaluación de saturación de oxígeno en sangre
        if (saturacion < 90) nivelRiesgo++;

        // Evaluación de frecuencia cardíaca
        if (frecuenciaCardiaca < 40 || frecuenciaCardiaca > 130) nivelRiesgo++;

        // Evaluación de frecuencia respiratoria
        if (frecuenciaRespiratoria < 8 || frecuenciaRespiratoria > 30) nivelRiesgo++;

        // Evaluación de temperatura
        if (temperatura < 35f || temperatura > 39f) nivelRiesgo++;

        // Asignar color según nivel de riesgo
        if (nivelRiesgo >= 4) return "rojo";
        if (nivelRiesgo >= 2) return "amarillo";
        if (nivelRiesgo >= 1) return "verde";
        return "blanco";
    }
    
    /**
     * Este método permite asignar un estado al paciente, cuyo valor puede ser
     * estable, grave o pendiente de traslado a otra unidad.
     * 
     * @return devuelve el estado del paciente asignado
     */
    public String actualizarEstadoPaciente(){
        System.out.println("Indique el estado actual del paciente:");
        estado = sc.nextLine();
        while(!"estable".equalsIgnoreCase(estado) && !"grave".equalsIgnoreCase(estado) && !"pendiente".equalsIgnoreCase(estado)){
            System.out.println("Error. Introduzca una de las opciones válidas ('estable', 'grave' o 'pendiente'(para pte. de traslado)): ");
            estado = sc.nextLine();
        }
        return estado;
    }
    
    /**
     * Este método muestra las constantes vitales del paciente seleccionado
     * de manera ordenada.
     */
    public void mostrarConstantes() {
        System.out.println("=== Constantes Vitales de " + nombre + " " + apellido + " ===");
        System.out.println("Frecuencia Cardíaca: " + frecuenciaCardiaca + " bpm");
        System.out.println("Presión Arterial: " + tensionArterial + " mmHg");
        System.out.println("Frecuencia Respiratoria: " + frecuenciaRespiratoria + " rpm");
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("Saturación de Oxígeno: " + saturacion + " %");
        System.out.println("=========================================");
    }
    
    public void mostrarEstadoPaciente(){
        System.out.println("=== Estado actual de " + nombre + " " + apellido + " ===");
        
        if (estado == null){
            System.out.println("El estado de este paciente no está actualizado.");
        } else if(estado.equalsIgnoreCase("estable")){
            System.out.println(estado);
            System.out.println("El paciente está estable. Será necesario volver a comprobar su estado.");
        } else if(estado.equalsIgnoreCase("grave")){
            System.out.println(estado);
            System.out.println("El paciente está bajo vigilancia dada la gravedad de su caso.");
        }else if(estado.equalsIgnoreCase("pendiente")){
            System.out.println(estado);
            System.out.println("El paciente está pendiente de traslado a otra unidad. ");
            System.out.println("Para comprobar el estado de la solicitud de traslado, contacte con la unidad correspondiente.");
        }   
        System.out.println("=========================================");
        
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Paciente p = (Paciente) obj;
        return this.idPaciente == p.idPaciente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaciente);
    }
}
