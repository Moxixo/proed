package gestion;

/**
 *
 * @author aelit
 */
public class Menu {
    
    public void inicial(){
        System.out.format("""
                          \n
                          *******************************
                          *      ¿QUE DESEAS HACER?     *
                          *******************************
                          *   1-Ingresar paciente       *
                          *   2-Actualizar paciente     *
                          *   3-Ver estado              *
                          *                             *
                          *   0-Salir                   *
                          *******************************
                          \n
                          """);
    }
    
    public void ingresarPacientes(){
        System.out.format("""
                          \n
                          *********************************
                          *      ¿QUE DESEAS HACER?       *
                          *********************************
                          *   1-Triaje/Urgencias          *
                          *   2-Trasladar area            *
                          *                               *
                          *   0-Volver                    *
                          *********************************
                          \n
                          """);
    }
    
    public void verEstado(){
        System.out.format("""
                          \n
                          ******************************
                          *      ¿QUE DESEAS VER?      *
                          ******************************
                          *   1-Disponibilidad camas   *
                          *   2-Equipos médicos        *
                          *   3-Personal               *
                          *                            *
                          *   0-Volver                 *
                          ******************************
                          \n
                          """);
    }
    
    public void verLugar(){
        System.out.format("""
                          \n
                          ************************
                          *    ¿DE QUE LUGAR?    *
                          ************************
                          *   1-UCI              *
                          *   2-Urgencias        *
                          *   3-Plantas          *
                          *                      *
                          *   0-Volver           *
                          ************************
                          \n
                          """);
    }
    
    public void actualizarPaciente(){
        System.out.format("""
                          \n
                          *******************************
                          *      ¿QUE DESEAS HACER?     *
                          *******************************
                          *   1-Trasladar paciente      *
                          *   2-Actualizar historial    *
                          *   3-Actualizar informe      *
                          *                             *
                          *   0-Salir                   *
                          *******************************
                          \n
                          """);
    }
}
