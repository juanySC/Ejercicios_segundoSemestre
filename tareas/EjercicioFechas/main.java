 /*. Mostrar la fecha actual
Crea un programa que imprima la fecha de hoy (LocalDate.now()).
Agrega el día de la semana (getDayOfWeek()).*/
import java.time.DayOfWeek;
import java.time.LocalDate;


public class main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Este programa te indica la fecha de hoy y el dia");
        //declaro mi localDate y el .now me sirve para tomar la fecha actual
        LocalDate fechaActual = LocalDate.now();
        System.out.println("\nLa fecha de hoy es: "+ fechaActual);
        //creo mi variable
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("\nEl día de hoy es: "+ diaSemana);


    }
}
