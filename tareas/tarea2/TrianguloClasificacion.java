/*
* Clasificación de triángulos: lea tres longitudes, valide que
formen un triángulo y clasifíquelo como equilátero, isósceles o
escaleno. Además, indique si es rectángulo.*/
package org.example;
import java.util.Scanner;

public class TrianguloClasificacion {

    /**
     * esTriangulo ayuda a identificar si cumple con las caracteristicas de un triangulo
     * antes de clasificarlo en los distintos tipos que existen
     * @param lado1  dato numerico que ayuda a identificar uno de los lados de la figura
     * @param lado2  dato numerico que ayuda a identificar uno de los lados de la figura
     * @param lado3  dato numerico que ayuda a identificar uno de los lados de la figura
     * **/

    public static boolean esTriangulo(double lado1, double lado2, double lado3){
        /*La suma de dos lados debe ser mayor que el tercero.
          Ejemplo: 3, 4, 5 sí forman un triángulo.
          Ejemplo: 2, 2, 5 no (porque 2 + 2 no es mayor que 5).*/
        return ((lado1 + lado2 > lado3) && (lado2 + lado3 > lado1) && (lado1 + lado3 > lado2));
    }

    /**
     * tipoTriangulo ayuda a identificar que tipo de triangulo es dependiendo de las
     * caracteristicas
     * @param lado1  dato numerico que ayuda a identificar el tipo de triangulo
     * @param lado2  dato numerico que ayuda a identificar el tipo de triangulo
     * @param lado3  dato numerico que ayuda a identificar el tipo de triangulo
     * **/
    public static String tipoTriangulo(double lado1, double lado2, double lado3){
        if((lado1 == lado2) && (lado1 == lado3)){
            return "---triangulo equilatero---";
        } else if (((lado1 == lado2) && (lado1 != lado3)) || ((lado1 == lado3) && (lado1 != lado2)) || ((lado2 == lado3) && (lado2 != lado1))) {
            return "---triangulo isosceles---";
        } else {
            return "---Triangulo escaleno---";
        }

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;
        double ladoA , ladoB , ladoC;

        do{
            System.out.println("\nEste programa permite verificar que tipo de triangulo ingreso");
            System.out.println("\nIngrese el primer lado del triangulo entero/decimal: ");
            ladoA = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el segundo lado del triangulo entero/decimal: ");
            ladoB = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el tercer lado del triagulo entero/decimal:");
            ladoC = sc.nextDouble();
            sc.nextLine();

            //calsificando si es o no un triangulo
            boolean verificacion = esTriangulo(ladoA, ladoB, ladoC);
            String tiposTri = tipoTriangulo(ladoA, ladoB, ladoC);

            if(verificacion){
                System.out.println("\nLos lados que ingreso cumplen con un triagunlo");
                System.out.println("El tipo de triangulo es: "+tiposTri);
            }else{
                System.out.println("\nNo cumple con un triangulo");
            }

            //clasifico el tipo del triagunlo

            //le pregunto al usuario si desea continuar
            System.out.println("\n¿Desea ejecutar el programa nuevamente? s/n ");
            continuarUsuario = sc.nextLine();
        }while (continuarUsuario.equalsIgnoreCase("s"));

        sc.close();
        System.out.println("Gracias por usar el programa");
    }
}
