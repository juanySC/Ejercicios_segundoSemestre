import javax.swing.text.TabSet;

import tarea.Tarea;

public class AppTareasDemo{
    public static void main(String[] args){

        //CLASE TAREA
        System.out.println("Clase tarea: ");

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
    }
}