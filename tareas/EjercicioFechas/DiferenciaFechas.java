/*Diferencia entre dos fechas
Pide dos fechas (ej. inicio y fin de un curso).
Muestra:
el número de días,
y el número de meses entre ambas (Period).
*/

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DiferenciaFechas {
    public static void main(String[] args){
        String continuar;
        Scanner sc = new Scanner(System.in);

        //el tipo de formato que quiero que reciba la fecha, en este caso el año va primero
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Este programa recibe dos fechas u devuelve los dias y meses");
        do {
            System.out.println("Ingrese la primera fecha (ej. 2025-09-10)");
            String fecha1 = sc.nextLine();
            System.out.println("Ingrese la segunda fecha (ej. 2025-09-10)");
            String fecha2 = sc.nextLine();

            try {
                //convierto mi cadena ingresada a un objeto
                //le paso los parametros ingresados por el usuario
                LocalDate conversion1 = LocalDate.parse(fecha1, formato);
                LocalDate conversion2 = LocalDate.parse(fecha2,formato);
                //lo muestro
                System.out.println("La fecha uno ha sido ingresada correcta: "+conversion1);
                System.out.println("La fecha dos ha sido ingresada correcta: "+conversion2);

                //ahora hago la resta de dias
                //Period.between calcula la diferencia entre dos fechas como objetos
                Period periodoCal = Period.between(conversion1, conversion2);
                //ahora obtengo los años
                int mes = periodoCal.getMonths();
                System.out.println("\nLos meses de difencia son: "+mes);
                //obtengo los dias
                int dias = periodoCal.getDays();
                System.out.println("Los dias de diferencia son "+dias);
            } catch (DateTimeParseException e){
                System.out.println("La fecha no esta ingresada en el formato correcto");


            }

            //le pregunto al usuario si desea usar de nuevo el programa
            System.out.println("\n¿Deseas ingresar otras fechas? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
    }
}