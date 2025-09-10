/* Comparar fechas
Pide una fecha y di si:
está en el pasado,
es hoy,
o está en el futuro (usando isBefore y isAfter)*/
package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class CompararFechas {

    public static void main(String[] args){
        String continuar;
        Scanner sc = new Scanner(System.in);

        //el tipo de formato que quiero que reciba la fecha, en este caso el año va primero
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Este programa comparar fechas, para sabar si es actual o pasado");
        do {

            try {
                System.out.println("Ingrese la fecha que desea: (ej. 2025-09-10)");
                String fecha = sc.nextLine();

                //convierto mi cadena ingresada a un objeto
                //le paso los parametros ingresados por el usuario
                LocalDate conversion1 = LocalDate.parse(fecha, formato);
                LocalDate comparo LocalDate.now();

                if (conversion1.isAfter(comparo)){

                }
            } catch (DateTimeParseException e){
                System.out.println("El formato de la fecha es incorrecto");
            }


            //le pregunto al usuario si desea repetir el programa
            System.out.println("¿Deseas ingresar otras fechas? s/n");
            continuar = sc.nextLine();
        }while (continuar.equalsIgnoreCase("s"));
        sc.close();
    }
}
