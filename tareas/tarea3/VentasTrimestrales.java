/*
 * Este programa calcula la mejor venta de cada trimestre y la mejor venta del año a partir
 * de una lista de ventas mensuales.
 */

import java.util.Scanner;

public class VentasTrimestrales {

    /**
     * Esta función encuentra el valor más alto en un arreglo de ventas.
     *
     * @param segmento Un arreglo de tipo double que representa las ventas de un periodo (ej. un trimestre).
     * @return El valor de la venta más alta encontrada en el arreglo.
     */
    static double maximo(double[] segmento) {
        double max = segmento[0]; // Se inicializa 'max' con el primer valor del arreglo.
        for (int i = 1; i < segmento.length; i++) {
            // Si el valor actual es mayor que 'max', 'max' se actualiza con este nuevo valor.
            if (segmento[i] > max) {
                max = segmento[i];
            }
        }
        return max; // Se devuelve el valor máximo encontrado.
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;
        double[] ventas = {101.5, 97.2, 88.4, 110.3, 99.9, 100.1, 95.5, 120.0, 105.6, 89.4, 91.7, 115.2};
        double mejorDelAnio = 0; // Variable para almacenar la mejor venta del año

        do {
             for (int i = 0; i < ventas.length; i += 3) {
            // Se crea un nuevo arreglo 'trimestre' con los 3 meses correspondientes.
            double[] trimestre = {ventas[i], ventas[i + 1], ventas[i + 2]};

            // Se llama a la función maximo() para encontrar la mejor venta del trimestre.
            double mejor = maximo(trimestre);

            // Se imprime la mejor venta del trimestre actual.
            // (i / 3) + 1 calcula el número de trimestre:
            // Para i = 0 -> (0 / 3) + 1 = 1 (Trimestre 1)
            // Para i = 3 -> (3 / 3) + 1 = 2 (Trimestre 2), etc.
            System.out.println("Mejor venta del trimestre " + ((i / 3) + 1) + ": " + mejor);

            // Se compara la mejor venta del trimestre con la mejor venta del año hasta ahora.
            // Si la venta trimestral es mayor, se actualiza 'mejorDelAnio'.
            if (mejor > mejorDelAnio) {
                mejorDelAnio = mejor;
            }
        }

        // Al finalizar el bucle, se imprime la mejor venta total del año.
        System.out.println("Mejor venta del año: " + mejorDelAnio);

        //le pregunto al usuario si desea continuar
        System.out.println("Deseas repetir el programa? s/n");
        continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
       sc.close();
       System.out.println("Gracias por usar el programa");
       
    }
}
