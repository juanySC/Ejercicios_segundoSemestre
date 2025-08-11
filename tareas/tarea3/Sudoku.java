/*Dado int[][] grid = { ... }, escribe boolean filaValida(int f), boolean colValida(int c) y
 boolean subcuadrosValidos().- Emplea for, if-else, arrays auxiliares de conteo y termina
con boolean estaCorrecto().*/

import java.util.Scanner;

public class Sudoku {

    static int[][] grid = {
        {1, 2, 3, 4},
        {3, 4, 1, 2},
        {2, 1, 4, 3},
        {4, 3, 2, 1}
    };

    static boolean filaValida(int f) {
        boolean[] visto = new boolean[5]; // índice 1 a 4
        for (int i = 0; i < 4; i++) {
            int val = grid[f][i];
            if (val < 1 || val > 4 || visto[val]) return false;
            visto[val] = true;
        }
        return true;
    }

    static boolean colValida(int c) {
        boolean[] visto = new boolean[5];
        for (int i = 0; i < 4; i++) {
            int val = grid[i][c];
            if (val < 1 || val > 4 || visto[val]) return false;
            visto[val] = true;
        }
        return true;
    }

    static boolean subcuadrosValidos() {
        for (int fila = 0; fila < 4; fila += 2) {
            for (int col = 0; col < 4; col += 2) {
                boolean[] visto = new boolean[5];
                for (int i = fila; i < fila + 2; i++) {
                    for (int j = col; j < col + 2; j++) {
                        int val = grid[i][j];
                        if (val < 1 || val > 4 || visto[val]) return false;
                        visto[val] = true;
                    }
                }
            }
        }
        return true;
    }

    static boolean estaCorrecto() {
        for (int i = 0; i < 4; i++) {
            if (!filaValida(i) || !colValida(i)) return false;
        }
        return subcuadrosValidos();
    }
    
    // Nueva función para imprimir el Sudoku
    static void imprimirSudoku() {
        System.out.println("Tabla de Sudoku:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(); // Salto de línea después de cada fila
        }
        System.out.println(); // Un salto de línea extra para mejor formato
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        do {
            imprimirSudoku(); // Llamar a la nueva función
            System.out.println("¿Sudoku correcto?: " + estaCorrecto());

            //le pregunto al usuario si desea ejectuar el progrmaa de nuevo
            System.out.println("¿Deseas repetir el programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por utilizar el pgrama");
        
    }
}