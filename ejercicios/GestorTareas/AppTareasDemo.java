import java.util.Scanner;

import javax.swing.text.TabSet;

import gestor.GestorTareas;
import tarea.Tarea;

public class AppTareasDemo{

    

     /**menu muestra las acciones que podemos realizar
      * desde las clases gestorTareas y tarea**/
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        //instancio mis clases para menu
        Tarea tareaMenu = new Tarea(null, null);
        GestorTareas gestorMenu = new GestorTareas();
        while (true) {
            System.out.println("\nMenú de opciones eliga el que desee: ");
        System.out.println("1. Crear tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Listar tareas pendientes");
        System.out.println("4. Listar tareas completadas");
        System.out.println("5. Marcar como completado por id");
        System.out.println("6. Alterar estaado id");
        System.out.println("7. Eliminar estado por id");
        System.out.println("8. Buscar tarea por id");
        System.out.println("9. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
            String continuar;
                do {
                    System.out.println("Ingrese el titutlo de la tarea");
                    String titulo = sc.nextLine();
                    System.out.println("Ingrese la descripcion de la tarea");
                    String descripcion = sc.nextLine();
                
                    gestorMenu.crearTarea(titulo, descripcion);
                    //le pregunto al usuario si desea añadir otra tarea o no
                    System.out.println("¿deseas añadir otra tarea? s/n");
                    continuar = sc.nextLine();
                } while (continuar.equalsIgnoreCase("s"));

                
                break;
            case 2:
                //muestra la lista de tareas
                gestorMenu.listarTarea();
                break;
            case 3:
                gestorMenu.listarPendiente();
                break;
            case 4:
                gestorMenu.listarCompletadas();
                break;
            case 5:
                //ingresa por id
                System.out.println("Ingrese el id para poder marcar como completa");
                String id = sc.nextLine();

                if (gestorMenu.completarTarea(id)) {
                    System.out.println("La tarea con id: "+id + "ha sido completada");
                } else {
                    System.out.println("No se encontro ninguna coincidencia con el id "+id);
                }
                break;
            case 6:
                //alterar por id
                System.out.println("Ingrese el id para alternar su estado: ");
                String alternar = sc.nextLine();

                if (gestorMenu.alternarEstado(alternar)) {
                    System.out.println("La tarea con id" + alternar + "se ha hecho con exito");
                } else{
                   System.out.println("No se encontro ninguna coincidencia con el id "+alternar);
                }
                break;
            case 7:
             //eliminar por id
                System.out.println("Ingrese el id para eliminar la tarea ");
                String eliminar = sc.nextLine();

                if (gestorMenu.eliminarTarea(eliminar)) {
                    System.out.println("La tarea con id" + eliminar + "se ha hecho con exito");
                } else{
                   System.out.println("No se encontro ninguna coincidencia con el id "+eliminar);
                }
                break;
            case 8:
                //llamo a mi metodo buscar
                System.out.println("Ingrese el id para buscarlo en la lista");
                String buscar = sc.nextLine();
                //creo mi nuevo objeto
               Tarea tareaBuscar = gestorMenu.buscarTarea(buscar);
                if (tareaBuscar!= null) {
                    //le devuelvo la descripcion
                    System.out.println("la tarea fue encontrada" +tareaBuscar.toString());
                }else{
                    System.out.println("La tarea no fue encontrada, no existe" + tareaBuscar);
                }
                break;
            case 9:
                System.out.println("Gracias por usar el programa!");
                sc.close();
                System.exit(0);
                break;                                        
            default:
                System.out.println("La opcion que desea no esta disponible");
                break;
        }
        }
        
    }
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

        //MENU-----------------------------------------------------------
        menu();

    }
}