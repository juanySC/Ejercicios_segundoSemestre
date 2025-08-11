/*Lee la temperatura de los 7 días de la semana en un double[].- Crea dos funciones: promedio() y
diasPorEncima(double promedio) que devuelvan el promedio semanal y un contador de los días por encima
de él.- Muestra el nombre del día más caluroso usando un switch.*/

import java.util.Scanner;

public class TemperaturaDiaria {

     /** promedio tiene una lista de los 7 dias los cuales se utilizan para hacer los calculos**/
    public static double promedio(double[] temperatura) {
        double suma = 0; //va sumando todas las temperaturas
        for (double temp : temperatura){
         suma += temp; 
        }
        return suma / temperatura.length; //promedio
    }

     /** diasPorEncima cuantos dias antes del promedio mas alto hay
      * @param temperatura nos ayuda a comparar las distitntas temperaturas
        @param promedio ayuda a recorrer los dias que estan antes de la temperatura mas alta**/
    public static int diasPorEncima(double[] temperatura, double promedio) {
        int contador = 0;
        for (double t : temperatura) {
            if (t > promedio) contador++;
        }
        return contador;
    }

     /** diaMasCaluroso, ayuda a comparar la temperatura y los dias entre si para saber cual es el mayor
      * @param temperatura para ir recorriende y reconociendo cual sera el valor que tome el dia mas caluroso**/
    public static void diaMasCaluroso(double[] temperatura){
        double max = temperatura[0];
        int diaMax = 0;
        for (int i = 1; i < 7; i++) {
            if (temperatura[i] > max) {
                max = temperatura[i];
                diaMax = i;
            }
        }

        switch (diaMax) {
            case 0 : System.out.println("Día más caluroso: Lunes");
            case 1 : System.out.println("Día más caluroso: Martes");
            case 2 : System.out.println("Día más caluroso: Miércoles");
            case 3 : System.out.println("Día más caluroso: Jueves");
            case 4 : System.out.println("Día más caluroso: Viernes");
            case 5 : System.out.println("Día más caluroso: Sábado");
            case 6 : System.out.println("Día más caluroso: Domingo");
        }
    }

     /** imprimirTemperatura tiene una lista de los 7 dias los cuales se imprimir para pedirle al usuario 
      * los valores y asi hacer los promedios**/
    public static void imprimirTemperatura(){
        Scanner sc = new Scanner(System.in);
        double[] temperatura = new double[7];
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        System.out.println("\n");
        for (int i = 0; i < 7; i++) { //ya que son 7 dias, los recorre de 0 a 6
            System.out.print("Temperatura del " + dias[i] + ": "); //le pido al usuario que ingrese el valor
            temperatura[i] = sc.nextDouble();
        }

        //llamo a mi funcion de promedio y tambien a diasPorEncima
        double prom = promedio(temperatura);
        System.out.println("\nPromedio: " + prom);
        System.out.println("Días por encima: " + diasPorEncima(temperatura, prom));

        //dia mas caluroso
       diaMasCaluroso(temperatura);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        System.out.println("\nEste programa recibe 7 temperaturas de toda la semana y devuelve");
        System.out.println("Promedio, el dia mas caluroso, asi como los dias que han pasado entre el dia mas caluroso");

        do {
             //llamo a mi funcion 
            imprimirTemperatura();
            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Desea repetir el programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
       sc.close();
       System.out.println("\nGracias por usar el pgrama");
    }
}