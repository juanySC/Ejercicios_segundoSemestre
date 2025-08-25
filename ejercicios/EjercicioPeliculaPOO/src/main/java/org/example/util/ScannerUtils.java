package org.example.util;

import java.util.Scanner;

/*Ahorrar lineas de codigo para ingresas titutlo, genero, duracion*/
public class ScannerUtils {

    //para preguntar datos
    public static final Scanner scanner = new Scanner(System.in);

    /**capturarTexto nos ayudam a recuperar la informacion dada
     *@param mensaje me devuelve el contenido de este **/
    public static String capturarTexto (String mensaje){
        System.out.println(mensaje + ":");
        return scanner.nextLine();
    }

    /**capturarNumero nos ayudam a capturar solo los numeros enteros
     *@param mensaje me devuelve el contenido de este **/
    public static int  capturarNumero (String mensaje){
        System.out.println(mensaje + ":");
        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;
    }

    /**capturarDecimal nos ayudam a recuperar informacion de los numeros con decimales
     *@param mensaje me devuelve el contenido de este **/
    public static double capturarDecimal (String mensaje){
        System.out.println(mensaje + ":");
        double dato = scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }

}
