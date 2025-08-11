/*Pide al usuario un texto (sin espacios) y llena una matriz cuadrada mínima (NxN) por filas.
- Función void cifrar(char[][] m, int despl) desplaza cada letra +despl
posiciones ASCII usando if para envolver de ‘Z’ a ‘A’.- Muestra la matriz original y la cifrada.*/
import java.util.Scanner;

public class CifradoCesar {

    /** llenarMatriz  se encarga de llenar una matriz con un texto.
    // Recibe el texto y el tamaño de la matriz..**/
    public static char[][] llenarMatriz(String texto, int n) {
        char[][] matriz = new char[n][n]; // Creamos la matriz del tamaño n x n.
        int idx = 0; // Un contador para recorrer el texto.
        
        // Recorremos la matriz para llenarla.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Si aún hay caracteres en el texto, los ponemos en la matriz.
                if (idx < texto.length()) {
                    matriz[i][j] = texto.charAt(idx++);
                } else {
                    // Si el texto se acaba, rellenamos el resto con 'X'.
                    matriz[i][j] = 'X';
                }
            }
        }
        return matriz; // Devolvemos la matriz llena.
    }

    /** imprimirMatriz: se encarga de imprimir una matriz de caracteres.
    recibe la matriz y un título para la impresión.**/
    public static void imprimirMatriz(char[][] matriz, String titulo) {
        int n = matriz.length;
        System.out.println(titulo); // Imprimimos el título que le pasamos.

        // Recorremos la matriz e imprimimos cada elemento.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila.
        }
        System.out.println(); // Un salto de línea extra para mejor formato.
    }

    // El resto de la función para cifrar. No la movimos porque ya está bien separada.
    static void cifrar(char[][] m, int despl) {
        int n = m.length;
        imprimirMatriz(m, "\nMatriz cifrada:"); // Reutilizamos la función de imprimir.
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = m[i][j];
                
                if (c >= 'A' && c <= 'Z') {
                    c += despl;
                    
                    if (c > 'Z') {
                        c = (char) ('A' + (c - 'Z' - 1));
                    }
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;
        do {
            System.out.print("Texto en mayúsculas (sin espacios): ");
        String texto = sc.next().toUpperCase();
        
        // Ahora usamos nuestra nueva función para llenar la matriz.
        int n = (int) Math.ceil(Math.sqrt(texto.length()));
        char[][] matriz = llenarMatriz(texto, n);
        
        // Y usamos la nueva función para imprimir la matriz original.
        imprimirMatriz(matriz, "\nMatriz original:");
        
        System.out.print("\nDesplazamiento: ");
        int despl = sc.nextInt();
        
        // Y finalmente ciframos la matriz.
        cifrar(matriz, despl);

        //le pregunto al usuario si desea continuar
        System.out.println("¿Deseas repetir el programa? s/n");
        continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        
        
        sc.close();
    }
}