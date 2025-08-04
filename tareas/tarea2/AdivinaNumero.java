/*Adivina el número: genere aleatoriamente un entero 1-100. El
usuario intenta adivinar; después de cada intento indique “más
alto” o “más bajo”. Limite a 5 intentos.*/
package org.example;
import java.util.Scanner;

public class AdivinaNumero {

    /**verificarNumero ayuda a comprar el numero que ingresa el usuario con el numero
     * generado de manera aleatoria**/
    public static void verificarNumero(){
        Scanner sc = new Scanner(System.in);
        int numeroSecreto = (int)(Math.random() * 100) + 1;
        int intento = 5, numero;

        //repito el ciclo hasta llegar a los 5 intentos mientras el numero no acerte
        do{
            System.out.println("Ingresa el número: ");
            numero = sc.nextInt();
            sc.nextLine();

            //comparo
            if(numero == numeroSecreto){
                System.out.println("Acertaste! el numero era :" + numeroSecreto);
            } else if ((numero > numeroSecreto)  || (numero < numeroSecreto)) {
                int margen = 10;
                int min = Math.max(1, numeroSecreto - margen);
                int max = Math.min(100, numeroSecreto + margen);
                System.out.println("Pista: el número esta entre "+min+" y "+max);
            } else{
                System.out.println("Terminaste tus intentos! suerte para la proxima");
            }

        }while (numeroSecreto != intento);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;

        System.out.println("Adivina el número y te dare pistas");
        //para repetir el programa
        do{
            //llamo a la funcion
            verificarNumero();

            //le pregunto al usuario si desea seguir o terminar el programa
            System.out.println("¿Deseas repetir el programa? s/n ");
            continuarUsuario = sc.nextLine();
        }while (continuarUsuario.equalsIgnoreCase("s"));

    }
}
