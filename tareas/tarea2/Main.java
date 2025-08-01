/*Calculadora de tarifa eléctrica residencial: el usuario ingresa su
consumo mensual en kWh.
0–100 kWh → Q 0.75/kWh
101–300 kWh → Q 1.20/kWh
301 kWh o más → Q 1.50/kWh + 10 % de recargo por “alto
consumo”.
Muéstrele el total a pagar y el ahorro si hubiera consumido 100
kWh. (en dado caso el consumo supere los 100)*/
package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * tarifaElctrica hace una comparacion del consumo de KWh para saber cuanto sera el
     * porcentaje que hay que cobrarle al usuario
     * antes de clasificarlo en los distintos tipos que existen
     * @param KWh  recibe un numero en esta unidad para clasificarla segun el consumo
     * **/
    public static double tarifaElectrica(double KWh){
        double tarifa =0 ;
        //hare la estructura para los distintos consumos mensuales
        if(KWh >= 0 && KWh <=100){
            tarifa = KWh * 0.75;
        }else if(KWh >= 101 && KWh <=300){
            tarifa = KWh * 1.20;
        } else if (KWh > 301){
            tarifa = (KWh * 1.50) + 0.10 * (KWh*1.50);
        }
        return tarifa;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double tarifaCliente, ahorroDinero, tarifaBase;
        String continuarUsuario;

        System.out.println("\nEste programa la tarifa que pagara por consumo electrico");


        do{
            System.out.println("Ingrese el consumo en KWh: ");
            tarifaCliente = sc.nextDouble();
            sc.nextLine();
            //llamo a mi funcion
            double resultadoDinero = tarifaElectrica(tarifaCliente);

            //hago una comparacion si es mayor que 100 los KWh del cliente
            if(tarifaCliente > 100){
                System.out.println(String.format("\nLa tarifa que tiene que pagar es : %.3f", resultadoDinero));

                //asigno valor a la tarifa base que es de 100
                tarifaBase = tarifaElectrica(100);
                //hago una resta para saber el ahorro
                ahorroDinero = resultadoDinero - tarifaBase;

                System.out.println(String.format("El ahorro si hubiera consumido solo 100 KWh es de : %.3f", ahorroDinero));
            }else if (tarifaCliente < 0){
                System.out.println("\nEntrada no válida, intente de nuevo");
            } else{
                /*
            String.format("%.3f", valor) = limita los decimales, en este caso a 3
            format toma "," o "." segun la configuracion
            * */
                System.out.println(String.format("\nLa tarifa que tiene que pagar es : %.3f", resultadoDinero));
            }


            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n ¿Deseas repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        }while(continuarUsuario.equalsIgnoreCase("s"));

        sc.close();
        System.out.println("\nGracias por usar el programa :D");
    }
}