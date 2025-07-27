/*a.Pide una nota (0-100).
b.Usa cascada if-else-if para mostrar: A (90-100), B (80-
89), C (70-79), D (60-69), F (< 60).
*/
import java.util.Scanner;

public class ClasificacionNotas{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //para la entrada del usuario desde el teclado
        int nota; //para recibir la nota que el usuario ingrese
        String continuarUsuario; //para saber si desea repetir el programa

        System.out.println("\nEste programa indica en que rango esta la nota de calificacion");
        do {
            System.out.println("\nIngrese una nota (0-100) en numeros enteros: ");
            nota = sc.nextInt();
            sc.nextLine();

            //logica
            if(nota>= 90 && nota<= 100){ //utilizo la condicion "y" para ver si cumple
                System.out.println("\nSu clasificacion es rango: A");
            }else if (nota>= 80 && nota<= 89) {
                System.out.println("\nSu clasificación es rango: B ");
            } else if(nota>= 70 && nota<= 79){
                System.out.println("\nSu clasigicación es rango: C");
            }else if(nota>= 60 && nota<= 69){
                System.out.println("\nSu clasificación es rango: D");
            } else{
                System.out.println("\nSu clasificación de rango es: F");
            }


            //le pregunto al suaurio si desea repetir el programa
            System.out.println("\n¿Deseas ingresar otra nota? s/n ");
            continuarUsuario = sc.nextLine();
        } while (continuarUsuario.equalsIgnoreCase("s"));
        
        sc.close();
        System.out.println("Gracias por usar el programa");       
    }
}