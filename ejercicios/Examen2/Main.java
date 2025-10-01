/*Menú: 1) Agregar  2) Listar  3) Eliminar  4) Salir

Al listar, imprimir:

Título — creado: dd/MM/yyyy HH:mm — Nota: <texto>*/
import agenda.Agenda;
import nota.Nota;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Agenda agenda = new Agenda();
    static Scanner sc = new Scanner(System.in);

    /*menu me ayuda a visualizar las posibles ocpiones para poder manipular
     * agregar, listar, eliminar y salir
    */
    public static void menu() {
        int opcion;
        do {
            System.out.println("\nMenu de mini agenda");
            System.out.println("1. Agregar nota");
            System.out.println("2. Listar notas");
            System.out.println("3. Eliminar nota");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Agregar nota");
                    System.out.print("Ingrese el titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Ingrese la nota: ");
                    String nota = sc.nextLine();

                    //llamando a mi objeto de nota, y pasandole los parametros
                    //de mi constructor de la clase nota
                    Nota nuevaNota = new Nota(titulo, nota);

                    //comparo si ya existe ese titutlo o no
                    if (agenda.agregar(nuevaNota)) {
                        System.out.println("Nota agregada correctamente: " + nuevaNota);
                    } else {
                        System.out.println("\nNo se ha podido completar existe un titulo igual");
                    }
                    break;
                case 2:
                    System.out.println("Listar notas");
                    //imprimiendo mi notas
                    for (Nota notita : agenda.listar()) {
                        System.out.println(notita.toString());
                    }
                    break;
                case 3:
                    System.out.println("Eliminar nota");
                    System.out.print("Ingrese el titulo: ");
                    String tituloEliminar = sc.nextLine();

                    //verifico que exista dicho titlo
                    if (agenda.eliminar(tituloEliminar)) {
                        System.out.println("Nota eliminada: " + tituloEliminar);
                    } else {
                        System.out.println("\nNo existe ese titulo");
                    }
                    break;
                case 4:
                    System.out.println("Salir");
                    sc.close();
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
                    break;
            }
        } while (opcion != 4);
    }

   public static void main(String[] args) {

    //llamando a clase NOTA-------------------------------------------
    Nota notita = new Nota("\nExamen de progra","5");
    //imprimo la informacion
    System.out.println(notita.toString());

    //llamanod a clase AGENDA-------------------------------------------
  
    Agenda agenda = new Agenda();
    agenda.agregar(notita);
    agenda.agregar(new Nota("\nExamen de mate", "8"));
    List<Nota> listaNotas = agenda.listar(); // obtengo mi nota
    agenda.agregar(new Nota("Examen de fisica", "3"));
    List<Nota> listaNotas2 = agenda.listar(); // lista mas actual

    System.out.println("\nNotas en la agenda: " + listaNotas.size());
    for (Nota not : listaNotas2) {
        System.out.println(not.toString());
    
    }

    //trantando de eliminar un anota
    if (agenda.eliminar("Examen de progra")) {
        System.out.println("\nNota eliminada: Examen de progra");
    } else {
        System.out.println("\nNo existe ese titulo");
    }

    //Recorro de nuevo mi lista de notas
    List<Nota> listaNotas3 = agenda.listar(); // lista mas actual
    System.out.println("\nNotas en la agenda: " + listaNotas.size());
        for (Nota not : listaNotas3) {
            System.out.println(not.toString());
    
    }

    //llamo a mi menu
    menu();

    }
}


    


