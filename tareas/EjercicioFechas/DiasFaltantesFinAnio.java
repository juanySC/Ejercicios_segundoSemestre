/*. Contar días faltantes para fin de año
Obtén la fecha de hoy.
Calcula cuántos días faltan para el 31 de diciembre del mismo año.*/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DiasFaltantesFinAnio {
    public static void main(String[] args){
        String continuar;
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa indica cuantos dias faltan para el 31 de diciembre");
        do {
            //obteniendo la fecha de hoy
            LocalDate fechaHoy = LocalDate.now();
            //obtengo el año actual
            LocalDate finAnio = LocalDate.of(2025,12,31);

            //ahora hago la resta para los dias
            //que calcula la cantidad de días completos entre dos fechas
            //ChronoUnit.DAYS = formato en dias, meses, años
            //between recibe dos parametros de fecha, calcula la cantidad de unidades
            long diasRestantes = ChronoUnit.DAYS.between(fechaHoy,finAnio);
            System.out.println("Los dias que faltan para el 2025-12-31 son " +diasRestantes);

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas repetir el programa? s/n");
            continuar = sc.nextLine();
        }while (continuar.equalsIgnoreCase("s"));
    }
}