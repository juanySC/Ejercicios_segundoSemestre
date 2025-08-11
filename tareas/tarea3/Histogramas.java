/*Lee 15 notas (0-10) en int[].- Para cada valor posible (0- 10) cuenta cuántas veces aparece y 
dibuja líneas de asteriscos: 5: *****.- Usa un array de frecuencias y un doble for.*/
import java.util.Scanner;

public class Histogramas {

    // Función que lee 15 notas del usuario y las devuelve en un arreglo
    static int[] leerNotas() {
        Scanner sc = new Scanner(System.in);
        int[] notas = new int[15];
        System.out.println("Ingresa 15 notas (0-10):");

        for (int i = 0; i < notas.length; i++) {
            int nota = sc.nextInt();
            if (nota >= 0 && nota <= 10) {
                notas[i] = nota;
            } else {
                System.out.println("Nota inválida. Ingresa un número entre 0 y 10.");
                i--; // Repetir el intento
            }
        }

        return notas;
    }

    // Función que cuenta cuántas veces aparece cada nota
    static int[] contarFrecuencias(int[] notas) {
        int[] frecuencia = new int[11]; // 0 al 10 ya que solo permito este rango
        for (int nota : notas) {
            frecuencia[nota]++;
        }
        return frecuencia;
    }

    // Función que imprime el histograma con asteriscos
    static void mostrarHistograma(int[] frecuencia) {
        System.out.println("\nHistograma:");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < frecuencia[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        do {
            int[] notas = leerNotas(); 
            int[] frecuencia = contarFrecuencias(notas); 
            mostrarHistograma(frecuencia); 

            //le pregunto al usuario si desea continuar
            System.out.println("¿Deseas repetir el programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el prorgrama");
    }
}
