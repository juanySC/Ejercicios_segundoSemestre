/*2. Sumar y restar días
Pide una fecha al usuario (ej. 2025-09-10).
Muestra:
la fecha 10 días después,
y la fecha 15 días antes.*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SumarRestarDias {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;
        //variable
        final int DIASEXTRA = 10;
        final int DIASATRAS = 15;

        //el tipo de formato que quiero que reciba la fecha, en este caso el año va primero
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Este programa suma y resta fechas");
        do {
            String fecha;

            System.out.println("Ingresa la primera fecha: (ej. 2025-09-10)");
            fecha = sc.nextLine();

            try{
            //convierto mi cadena ingresada a un objeto
            //le paso los parametros ingresados por el usuario
            LocalDate conversion = LocalDate.parse(fecha, formato);
            //lo muestri
            System.out.println("La fecha uno ha sido ingresada correcta: "+conversion);

            //le sumo a la fecha +10
                //plusDays nos siver para sumarle  traves de un int los dias a la fecha
                LocalDate fechaFutura = conversion.plusDays(DIASEXTRA);
                System.out.println("\nLa fecha actual dentro de 15 días es: "+ fechaFutura);

                //ahora hago la resta de fechas -15
                //minusDays nos sirve para restarle a traves de un int los dias a la fecha
                LocalDate fechaPasada = conversion.minusDays(DIASATRAS);
                System.out.println("La fecha pasada de 15 días es: "+fechaPasada);


            }catch (DateTimeParseException e){
                //indica que existe un problema en pasar una cadena de texto a una fecha, por algo mal ingresado
                System.out.println("La fecha ingresada no es correcta por el formato");
            }


            System.out.println("\n¿Deseas ingresar otra fecha? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
    }
}