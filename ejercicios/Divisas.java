package org.example;
import java.util.Scanner;

public class Divisas {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        double dinero, resultado;
        String continuarUsuario;
        char operacion;

        System.out.println("Este programa hace conversiones de quetzales a otras monedas");

        do{
            System.out.println("Ingrese la cantidad de dinero en Q: ");
            dinero = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese la opcion: m, d");
            System.out.println("m = peso mexicano");
            System.out.println("d = dolar");
            System.out.println("l = libra esterlina");
            operacion = sc.next().charAt(0);
            sc.nextLine();

            //logica
            switch (operacion){
                case 'm':
                    resultado = dinero * 2.46;
                    System.out.println("La conversion es: "+resultado);
                    break;
                case 'd':
                    resultado = dinero  * 0.13;
                    System.out.println("La conversion es "+ resultado);
                    break;
                case 'l':
                    resultado =  0.098 * dinero;
                    break;
            }

            //le pregunto al usuario si desea repetir el programa
            System.out.println("¿Desea repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        }while(continuarUsuario.equalsIgnoreCase("s"));

    }
}
