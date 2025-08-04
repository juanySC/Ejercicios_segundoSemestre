/*Tabla de multiplicar avanzada: pida un número n y un rango
máximo r. Imprima la tabla de 1 × n hasta r × n alineada en
columnas.*/
package org.example;
import java.util.Scanner;

public class TablaMultiplicar {
    /**tabla metodo que nos ayuda a imprimir la tabla de multiplicar segun las especificaciones
     * del usuario
     * @param numero  dato numerico que indica cuantos elementos se agregan a la tabla**/
    public static int tabla(int numero, int maximo){
        for (int i = 1; i <= maximo; i++) {
            System.out.printf("%3d x %3d = %4d\n", i, numero, i * numero);
        }
        return numero;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;
        int numeroTabla, maximoRango;

        System.out.println("\nEste programa devuelve una tabla de multiplicar");
        //para saber si desea reptir el programa
        do{
            System.out.println("\nIngrese el número por el que sea la tabla ej(10, 8, 34)");
            numeroTabla = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese hasta el númeor que desee que la tabla llegue");
            maximoRango = sc.nextInt();
            sc.nextLine();

            //llamo a mi metodo
            tabla(numeroTabla, maximoRango);

            //le pregutno al usuario si desea repetir el programa
            System.out.println("\n¿Deseas repetir el programa? s/n ");
            continuarUsuario = sc.nextLine();
        }while (continuarUsuario.equalsIgnoreCase("s"));

        sc.close();
        System.out.println("Gracias por usar el programa");
    }

}
