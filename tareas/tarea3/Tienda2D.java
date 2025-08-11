/*Declara String[][] stock = new String[3][4] y pídele al usuario los nombres de productos.- Función void
mostrarTabla(String[][]) que imprima la matriz en formato fila × columna.- Permite buscar un nombre; si
existe, muestra [fila,columna], de lo contrario “No disponible”.*/
import java.util.Scanner;

public class Tienda2D {

    public static void mostrarTabla(String[][] stock) {
        for (String[] fila : stock) {
            for (String producto : fila) {
                System.out.print((producto != null ? producto : "-") + "\t");
            }
            System.out.println();
        }
    }

    public static void producto(){
        Scanner sc = new Scanner(System.in);
        String[][] stock = new String[3][4];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
                System.out.print("Producto [" + i + "][" + j + "]: ");
                stock[i][j] = sc.next();
            }

        mostrarTabla(stock);

        System.out.print("\nBuscar producto: ");
        String buscar = sc.next();

        boolean encontrado = false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                if (stock[i][j].equalsIgnoreCase(buscar)) {
                    System.out.println("Encontrado en: [" + i + "," + j + "]");
                    encontrado = true;
                }

        if (!encontrado) System.out.println("\nNo disponible");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        System.out.println("\nEste programa simula una tienda y visa el producto ");
       
        do {
            producto();

            //le pregunto al usuario si desea repetir al programa
            System.out.println("\n¿Deseas repetir el programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("\nGracias por usar el programa");
    }
}

