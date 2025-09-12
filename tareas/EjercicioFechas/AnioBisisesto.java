/*7. Validar si un año es bisiesto
Pide un año (int).
Usa Year.of(año).isLeap() para verificar si es bisiesto.*/

import java.time.Year;
import java.util.Scanner;

public class AnioBisisesto {
    public static void main(String[] args) {
        String continuar;
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa compara si un año es bisiesto");

        do {
            System.out.println("\nIngresa un año por favor (ej: 2025)");
            int anio = sc.nextInt();
            sc.nextLine();

            //java tiene algo llamado Year.of(año).isLeap() = true or false
            if (Year.of(anio).isLeap()) {
                System.out.println("El año es bisisesto " + anio);
            } else {
                System.out.println("El año no es bisiesto " + anio);
            }
            
            //le pregunto al usuario si desea ingresar otra vez
            System.out.println("\n¿Deseas ingresar otro año? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
    }
}
