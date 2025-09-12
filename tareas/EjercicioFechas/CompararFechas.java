/* Comparar fechas
Pide una fecha y di si:
está en el pasado,
es hoy,
o está en el futuro (usando isBefore y isAfter)*/

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
                System.out.println("\nIngrese la fecha que desea: (ej. 2025-09-10)");
                String fecha = sc.nextLine();

                //convierto mi cadena ingresada a un objeto
                //le paso los parametros ingresados por el usuario
                LocalDate conversion1 = LocalDate.parse(fecha, formato);
                LocalDate comparo = LocalDate.now(); //obtengo mi fecha actual

                if (conversion1.isBefore(comparo)){
                    System.out.println("La fecha " +conversion1+" es pasada");
                } else if (conversion1.isAfter(comparo)) {
                    System.out.println("La fecha "+conversion1+" es en el futuro");
                } else{
                    System.out.println("La fecha es de hoy" +conversion1);
                }


            } catch (DateTimeParseException e){
                System.out.println("\nEl formato de la fecha es incorrecto");
            }


            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas ingresar otras fechas? s/n");
            continuar = sc.nextLine();
        }while (continuar.equalsIgnoreCase("s"));
        sc.close();
    }
}