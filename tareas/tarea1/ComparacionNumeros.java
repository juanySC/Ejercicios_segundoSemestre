/*a.Solicita dos enteros a y b.
b.Imprime si los numeros son iguales, o cual es mayor.*/
import java.util.Scanner;
public class ComparacionNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //creo el objeto para leer lo que el usuario introduzca por teclado
        // crea un nuevo objeto en la memoria
        int numUno, numDos; //las variables que usare para que el usuario ingrese los numeros
        String continuarUsuario; //para saber si desea repetir el programa

        System.out.println("\nEste programa solicita dos numeros y compara si son iguales, o cual sera el mayor");

        //para repetir el programa por lo menos una vez
        do {
            System.out.println("\nIngrese el primer número entero: ");
            numUno = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el segundo número entero: ");
            numDos = sc.nextInt();
            sc.nextLine();

            //logica del programa
            if (numUno == numDos) {
                System.out.println("\nAmbos numeros son iguales ");
                System.out.println("Primer numero: "+numUno+ " Segundo numero: "+numDos);
            } else if (numUno > numDos) {
                System.out.println("\nEl número mayor es el primer número: "+numUno);
            } else {
                System.out.println("\nEl número mayor es el segundo número: "+numDos);
            }

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Desea volver a comparar números? s/n ");
            continuarUsuario = sc.nextLine();
        } while (continuarUsuario.equalsIgnoreCase("s"));

        System.out.println("Gracias por usar el programa");
        sc.close(); //liberar recursos
    }
}
