/*Completa int[] rotarDerecha(int[] arr, int k) que mueva los elementos k posiciones a la derecha 
(sin usar arrays auxiliares grandes).- Demuestra la función con un array de 10 números.*/
public class RotacionCircular {

    // Función que rota el arreglo k veces a la derecha
    static int[] rotarDerecha(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Por si k > n
        for (int r = 0; r < k; r++) {
            int ultimo = arr[n - 1]; // Guardamos el último
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1]; // Desplazamos hacia la derecha
            }
            arr[0] = ultimo; // Ponemos el último en la primera posición
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3; // Número de rotaciones

        System.out.println("Original:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }

        rotarDerecha(arreglo, k);

        System.out.println("\nRotado " + k + " posiciones a la derecha:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
