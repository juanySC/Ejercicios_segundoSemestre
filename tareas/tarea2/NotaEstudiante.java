/*Gestor de notas de estudiantes: permita registrar hasta 30
notas (0-100). Luego muestre promedio, nota más alta, más
baja y cuántos aprobaron (≥ 61).*/
package org.example;
import java.util.Scanner;

public class NotaEstudiante {

    /**ingresoDeNotas es un arreglo que nos permite almacenar hasta 30 notas por el usuario
     * y clasifica si dechas notas cumplen en el rango de 0 a 100**/
    public static int[] ingresoDeNotas(){
        Scanner sc = new Scanner(System.in);
        int[] notas = new int[30]; //limito a las notas que ingreo solo sean 30
        int totalNotas = 0;
        String continuarUsuario= "n"; //para preguntarle al usuario si deseea seguir ingresando
        int nota;

        do{
            System.out.println("Ingrese la nota: ");
            nota = sc.nextInt();
            sc.nextLine();

            //hago una comparacion para saber si la nota es valida
            if (nota<0 || nota>100){
                System.out.println("Nota invalida, tiene que estar en un rango de 0 a 100");
                continue;
            }

            //si no inremento el total de las notas
            notas[totalNotas++] = nota;
            if (totalNotas == 30) break; //si se tienen las 30 notas, enotnces termina

            //le pregunto al usuario si desea ingresar otra nota
            System.out.println("¿Desea ingresar otra nota? s/n");
            continuarUsuario = sc.nextLine();
        }while (totalNotas < 30 && continuarUsuario.equalsIgnoreCase("s"));
        sc.close();

        //Esta línea crea y devuelve una copia del arreglo notas, pero solo hasta la cantidad de elementos válidos
        return java.util.Arrays.copyOf(notas, totalNotas);
    }

    /**imprimirNotas nos permite visualizar todas las notas que fueron metidas en el arreglo
     *  @param notas  dato que ayuda a comparar y clasificar segun los requisitos que se solicita**/
    public static void imprimirNotas(int[] notas){
        double suma = 0;
        int max = Integer.MIN_VALUE; //es una constante que representa el valor entero más pequeño posible
        int min = Integer.MAX_VALUE; //es la constante que representa el valor entero más grande posible
        int aprobados = 0;

        for (int nota : notas) {
            suma += nota;
            if (nota > max) max = nota;
            if (nota < min) min = nota;
            if (nota >= 61) aprobados++;
        }

        System.out.println("Promedio: " + (suma / notas.length));
        System.out.println("Nota más alta: " + max);
        System.out.println("Nota más baja: " + min);
        System.out.println("Estudiantes aprobados: " + aprobados);
    }

    public static void main(){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;

        do{
            int[] resultado = ingresoDeNotas();
            imprimirNotas(resultado);
            //le pregunto al usuario si quiero continuar
            System.out.println("¿Deseas continuar? s/n ");
            continuarUsuario = sc.nextLine();
        }while (continuarUsuario.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el programa");
    }
}
