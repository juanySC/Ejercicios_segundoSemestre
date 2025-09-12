/*Formatear fechas
Muestra la fecha actual en diferentes formatos:
dd/MM/yyyy
EEEE, MMMM dd yyyy (ej. “Wednesday, September 10 2025”)*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FormatearFechas {
    public static void main(String[] args) {
        String continuar;
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa muestra las fehcas en distintos formatos");
        do {
            LocalDate fechaHoy = LocalDate.now();

            //le indico el patron en que se presenta la fecha
            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy");

            //imprimo los resultado
            //.format cual sera la referencia
            System.out.println("\nLa fecha de hoy en el primer formato es: "+fechaHoy.format(formato1));
            System.out.println("La fecha de hoy en el segundo formato es: "+fechaHoy.format(formato2));

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas ingresar otra fecha? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
    }
}
