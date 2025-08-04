/*Analizador de texto: lea una frase y ofrezca un sub-menú:1)
Contar vocales2) Contar palabras3) Invertir frase4) Salir.*/
package org.example;
import java.util.Scanner;


public class AnalizadorTexto {

    /**contarVocales ayuda a identificar a tarves de un contador las vocales que existan
     *  @param frase para comparar si tiene las vocales**/
    public static int contarVocales(String frase) {
        int contador = 0;
        for (char caracter : frase.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(caracter) != -1) contador++;
        }
        return contador;
    }

    /**contarPalabras nos permite visualizar las frases a traveés de los espacios que tenga
     * @param frase  para identificar dichas frases**/
    public static int contarPalabras(String frase) {
        return frase.trim().split("\\s+").length;
    }

    /**invertirFrase
     *  @param frase  dato que ayuda a comparar y clasificar segun los requisitos que se solicita**/
    public static String invertirFrase(String frase) {
        return new StringBuilder(frase).reverse().toString();
    }
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una frase: ");
        String frase = sc.nextLine();
        String continuarUsuario;

        do{ System.out.println("1. Contar vocales");
            System.out.println("2. Contar palabras");
            System.out.println("3. Invertir frase");
            System.out.println("Eliga la opcion que desee: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Las vocales son: "+contarVocales(frase));
                    break;
                case 2:
                    System.out.println("Las palabras son: "+contarPalabras(frase));
                    break;
                case 3:
                    System.out.println("Las frases invertidas son: "+invertirFrase(frase));
                    break;
                default:
                    System.out.println("opción no válida");
            }
            //le pregunto al usuario si desea repetir el programa
            System.out.println("¿Deseas repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        }while(continuarUsuario.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el programa");

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;

        System.out.println("Este programa es un analizador de texto y puede hacer lo siguiente: ");
            //llamo a la funcion
            menu();


    }
}
