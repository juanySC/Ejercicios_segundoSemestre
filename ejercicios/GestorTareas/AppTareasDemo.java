import javax.swing.text.TabSet;

import gestor.GestorTareas;
import tarea.Tarea;

public class AppTareasDemo{
    public static void main(String[] args){

        //CLASE TAREA ----------------------------------------------------
        System.out.println("(\nClase tarea: ");

        //instancio mi clase
        Tarea tareita = new Tarea("Compras del super", "Lecha, galletas");
        tareita.setId("T001");
        //confirmo que se crea la tarea
        System.out.println("Tarea creada con exito: "+tareita.toString());

        //tarea completa
        tareita.marcarCompleta();
        System.out.println("Su tarea esta en un estado: "+tareita.isCompletada());
        //alternar tarea
        tareita.alternarEstado();
        System.out.println("Alterar el estado : "+tareita.isCompletada());
        tareita.alternarEstado();
        System.out.println("Alterno de nuevo: "+tareita.isCompletada());

        //tarea
        System.out.println("Informacion de la tarea "+tareita.toString());
        System.out.println("");

        //CLASE GESTOR TAREAS----------------------------------------
        System.out.println("(\nClase gestor tareas");

        //instanci mi calse
        GestorTareas gestorT = new GestorTareas();
        //creo mi lista de tareas
        gestorT.crearTarea("compras del super", "Leche, galletas");
        gestorT.crearTarea("Alimentos", "tomate, cebolla");
        gestorT.crearTarea("Gustitos", "pizza, tortrix");

        //muestro el listado de mis tareas creadas
        System.out.println("\nListando las tareas: ");
        gestorT.listarTarea();

        //vamos hacer pendientes
        System.out.println("\nCompleto mis tareas: ");
        boolean completo = gestorT.completarTarea("T002");
        //busco si existe para devolverme el valor de verdadero o falso
        if (completo) {
            System.out.println("La tarea ha sido completada con exito");
        } else {
            System.out.println("La tarea no existe");
        }

        //listo las tareas pendientes y completadas
        gestorT.listarCompletadas();
        gestorT.listarPendiente();

        //eliminio mi primera tarea
        System.out.println("\nEliminando tarea T001");
        boolean eliminar = gestorT.eliminarTarea("T001");
        if (eliminar) {
            System.out.println("tarea eliminada con exito");
        
        } else{
            System.out.println("no se puede eliminar una tarea que no existe");
        }

        //muestro las tareas restante
        System.out.println("\nTareas actuales");
        gestorT.listarTarea();
    }
}