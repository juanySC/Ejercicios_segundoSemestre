/*Lee n puntuaciones hasta que el usuario ingrese -1 (usa un while).- Ordena el array con inserción en una función
insertionSort(int[]).- Muestra el top-5 y la posición (índice) del jugador con la puntuación concreta que
pregunte el usuario (búsqueda lineal).*/
import java.util.Scanner;

public class PutuacionVideojuego {

    /** insertionSort clasifica desde el mayor al menor**/
    public static void insertionSort(int[] puntuacion, int numero) {
        for (int i = 1; i < numero; i++) {
            int llave = puntuacion[i], j = i - 1;
            while (j >= 0 && puntuacion[j] < llave) {
                puntuacion[j + 1] = puntuacion[j];
                j--;
            }
            puntuacion[j + 1] = llave;
        }
    }

    /** buscar las puntuaciones mas altas para ponerlos en el top5**/
    public static int buscar(int[] puntuacion, int valor, int numero) {
        for (int i = 0; i < numero; i++) if (puntuacion[i] == valor) return i;
        return -1;
    }

    public static void ingreso(){
        Scanner sc = new Scanner(System.in);
        int[] puntuaciones = new int[100];
        int n = 0, val;

        while (true) {
            System.out.print("Ingresa puntuación (-1 para terminar): ");
            val = sc.nextInt();
            if (val == -1) break;
            puntuaciones[n++] = val;
        }

        insertionSort(puntuaciones, n);
        System.out.println("\nTop 5:");
        for (int i = 0; i < Math.min(5, n); i++) System.out.println(puntuaciones[i]);

        System.out.print("\nBuscar puntuación: ");
        val = sc.nextInt();
        int pos = buscar(puntuaciones, val, n);
        System.out.println(pos != -1 ? "Posición: " + pos : "No encontrada");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        System.out.println("\nEste programa recibe puntuaciones y los clasifica");

        do {
            ingreso();

            //le pregunto al usuario si desea 
            System.out.println("\n¿Deseas repetir el programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("\nGracias por usar el programa");

    }
}

