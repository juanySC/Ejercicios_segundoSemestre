/*a.Lee un número entero.
b.Muestra “Par” si el número es divisible por 2; de lo
contrario, “Impar”.*/
import java.util.Scanner;

public class MultiploTresClasificacion{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //para que me revisa la entrada desde el teclado
        //creo un nuevo objeto en la memoria.
        int numero; //me ayudara en la entrada que haga el usuario
        String continuarUsuario; //entrada para ver si continua con el programa

        System.out.println("\nEste programa nos indica si un número es par o impar");

        //repito el ciclo por lo menos una vez
        do {
            System.out.println("\nIngrese un número entero: ");
            numero = sc.nextInt(); //lo leo en entero
            sc.nextLine(); //para que el programa siga corriendo con normalidad
                            //si no lo toma como entrada vacía.Resultado: continuarUsuario obtiene una cadena vacía ("") sin que el usuario escriba nada.

            //logica del programa
            if (numero %2 == 0 ) { //utilizo residuo si es distinto de 0 es impar
                System.out.println("\nEl número es par : "+numero);
            } else {
                System.out.println("\nEl número es impar");
            }

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas repetir el programa: s/n ");
            continuarUsuario = sc.nextLine();
        } while (continuarUsuario.equalsIgnoreCase("s"));

        System.out.println("Gracias por usar el programa!");
        sc.close(); //liberar recursos

    }
}