/*Analizador de texto: lea una frase y ofrezca un sub-menú:1)
Contar vocales2) Contar palabras3) Invertir frase4) Salir.*/
package org.example;
import java.util.Scanner;


public class AnalizadorTexto {

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Contar vocales");
        System.out.println("2. Contar palabras");
        System.out.println("3. Invertir frase");
        System.out.println("Eliga la opcion que desee: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("opción no válida");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;

        System.out.println("Este programa es un analizador de texto y puede hacer lo siguiente: ");
        do{
            //llamo a la funcion
            menu();

            //le pregunto al usuario si desea repetir el programa
            System.out.println("¿Deseas repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        }while(continuarUsuario.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el programa");
    }
}
