package org.example;
import java.util.Scanner;

public class CajeroAutomatico {
    static double saldo = 5000;

    public static void consultarSaldo() {
        System.out.println("Saldo actual: Q" + saldo);
    }

    public static void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: Q" + saldo);
        } else {
            System.out.println("Monto inválido.");
        }
    }

    public static void retirar(double monto) {
        if (monto % 100 != 0) {
            System.out.println("Error: El retiro debe ser múltiplo de 100.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: Q" + saldo);
        }
    }

    public static void cajero() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double monto;

        do {
            System.out.println("\n1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2 :
                    System.out.print("Ingrese monto a depositar: ");
                    monto = sc.nextDouble();
                    sc.nextLine();
                    depositar(monto);
                    break;
                case 3:
                    System.out.print("Ingrese monto a retirar: ");
                    monto = sc.nextDouble();
                    sc.nextLine();
                    retirar(monto);
                case 4:
                    System.out.println("Gracias por usar el cajero.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    public static void main(String[] args) {
        cajero();
    }
}
