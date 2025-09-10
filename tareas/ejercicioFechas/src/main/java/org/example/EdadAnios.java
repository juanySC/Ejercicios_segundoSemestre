/*. Edad en años
Pide la fecha de nacimiento del usuario (LocalDate).
Calcula y muestra su edad en años exactos con Period.between().*/
package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EdadAnios {
    public static void main(String[] args){
        //variables
        String continuar;
        Scanner sc = new Scanner(System.in);

        //el tipo de formato que quiero que reciba la fecha, en este caso el año va primero
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Este programa calcula la edad en base a la fecha del nacimiento ");
        do {
            System.out.println("Ingrese su fecha de nacimientro (ej. 2025-09-10)");
            String fechaNacimiento = sc.nextLine();

            //fecha actual
            LocalDate fechaHoy = LocalDate.now();

            try {
                //convierto mi cadena ingresada a un objeto
                //le paso los parametros ingresados por el usuario
                LocalDate conversion = LocalDate.parse(fechaNacimiento, formato);
                //lo muestro
                System.out.println("La fecha uno ha sido ingresada correcta: "+conversion);


                //calculando la fecha
                Period periodoCal = Period.between(conversion, fechaHoy);
                //ahora obtengo los años
                int anios = periodoCal.getYears();
                System.out.println("\nLa edad calculada es: "+anios);

            } catch (DateTimeParseException e){
                System.out.println("La fecha ingresada no cumple el formato esperando");
            }

            //le pregunto al usuario si desea
            System.out.println("\n¿Deseas ingresar otra fecha? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
    }
}
