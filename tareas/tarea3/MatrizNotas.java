/*Crea double[][] notas = new double[5][4] (5 estudiantes, 4 evaluaciones).- Funciones: • double promedioEst(int
est, double[][] m) • double promedioEval(int eval, double[][] m)- Usa bucles anidados (for) y if para indicar
quién aprobó (≥ 60)*/

import java.util.Scanner;

public class MatrizNotas {
    public static double promedioEst(int est, double[][] m) {
        double suma = 0;
        for (int i = 0; i < 4; i++) suma += m[est][i];
        return suma / 4;
    }

    public static double promedioEval(int eval, double[][] m) {
        double suma = 0;
        for (int i = 0; i < 5; i++) suma += m[i][eval];
        return suma / 5;
    }

    public static void main(String[] args) {
        String continuar;
        Scanner sc = new Scanner(System.in);
        double[][] notas = {
            {80, 70, 90, 60},
            {55, 65, 50, 70},
            {90, 85, 95, 100},
            {40, 45, 50, 55},
            {70, 75, 80, 85}
        };

        do {
             for (int i = 0; i < 5; i++) {
            double prom = promedioEst(i, notas);
                System.out.println("Estudiante " + i + " promedio: " + prom + (prom >= 60 ? " (Aprobado)" : " (Reprobado)"));
            }

            for (int i = 0; i < 4; i++) {
                System.out.println("Promedio evaluación " + i + ": " + promedioEval(i, notas));
            }
            //pregunto al usuario si desea repetir
            System.out.println("¿Deseas repetir al programa? s/n");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar al programa");
    }
}
