/*Genera aleatoriamente 30 enteros (1-100) y guárdalos en un int[].- Implementa boolean 
esPrimo(int n).- Copia todos los primos a un segundo array sin huecos; imprime
ambos arrays.*/

import java.util.Random;
import java.util.Scanner;

public class FiltroNumerosPrimos {

/** esPrimo compara si el residuo es distinto de 0 es primo**/
  public static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++)
            if (numero % i == 0) return false; //si es 0 es distinto de primo
        return true;
    }

    public static void clasificacion(){
        Random rand = new Random();
        int[] numeros = new int[30];
        int[] primosTemp = new int[30];
        int contador = 0;

        for (int i = 0; i < 30; i++) {
            numeros[i] = rand.nextInt(100) + 1; //generando numeros aleatorios
            if (esPrimo(numeros[i])) {
                primosTemp[contador++] = numeros[i];
            }
        }

        //imprimo
        System.out.print("Lista: \n");
        for (int n : numeros) System.out.print(n + "\n ");

        System.out.print("\nPrimos: \n");
        for (int i = 0; i < contador; i++) System.out.print(primosTemp[i] + "\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;
        System.out.println("\nEste programa clasifica los numeros primos");
        System.out.println("Imprime 30 numeros aleatorios y tambien una lista de los numeros primos");
        
        do {
            //llamo a las funciones
            clasificacion();

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas repetir el programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("\nGracias por usar el programa");
    }

}
