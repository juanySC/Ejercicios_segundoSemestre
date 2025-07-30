/*
Realice un menu para elegir opciones
1. Si quiere ver pelicula
2. Si quiere ver series
0. para salir
* */
package org.example;
import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;
        int opcion;

        System.out.println("\nEste programa le pregunta que desea ver");

        //ciclo para que el programa de nuevo corra
        do {

            System.out.println("\n1. Ver pelicula");
            System.out.println("2. Ver serie");
            System.out.println("3. Salir");
            System.out.println("Ingrese un número para saber que desea ver: ");
            opcion = sc.nextInt();
            sc.nextLine();

            //le pongo un ciclo para que eliga que desea hacer
            switch (opcion){
                case 1:
                    System.out.println("\nQue pelicula deseas ver?");
                    break;
                case 2:
                    System.out.println("\nque serie deseas ver");
                    break;
                case 3:
                    System.out.println("\nEl programa se termino con exito");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nEsta opción no esta disponible");
            }

            //desea volver a repetir
            System.out.println("\n¿Desea repetir el programa? s/n: ");
            continuarUsuario = sc.nextLine();
        } while(continuarUsuario.equalsIgnoreCase("s"));

        sc.close();
        System.out.println("\nGracias por usar el programa");

    }
}
