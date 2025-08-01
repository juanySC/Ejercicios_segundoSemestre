//Gestor básico de inventario: presente un menú: 1) Agregar
//existencias 2) Retirar existencias 3) Consultar stock 4) Salir. La
//variable stock se va modificando.
package org.example;
import com.sun.security.jgss.GSSUtil;

import  java.util.Scanner;

public class GestorInventario {

    /**menu ayuda a mostrar al usuariolas opciones disponibles que puede hacer en el inventario **/
    public static void menu(){
        //opciones que tendran para seleccionar
        Scanner sc = new Scanner(System.in);
        String continuar;
        int opcion;

        System.out.println("Este programa es un gestor basico de inventario");

        do {
            System.out.println("Seleccione la opción que desee");
            System.out.println("1. Agregar existencias");
            System.out.println("2. Retirar existencias");
            System.out.println("3. Consultar stock");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            //opciones
            switch (opcion){
                case 1:
                    int valorCantidad;
                    System.out.println("Ingrese la cantidad que desee agregar");
                    valorCantidad = sc.nextInt();
                    sc.nextLine();

                    agregarStock(valorCantidad);
                    break;
                case 2:
                    int valorRetirado;
                    System.out.println("Ingrese la cantidad que desee agregar");
                    valorRetirado= sc.nextInt();
                    sc.nextLine();

                    retirarExistencia(valorRetirado);
                    break;
                case 3:
                    mostrarStock();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no disponible, intente de nuevo");
            }

            //le pregunto al usuario si quiere repetir
            System.out.println("¿Deseas repetir el programa? s/n ");
            continuar = sc.nextLine();
        }while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el programa");
    }

    /**agregarStock nos ayuda a agregar nuevos elementos
     * @param cantidad  dato numerico que indica cuantos elementos se agregan a la lista**/
    public static int agregarStock(int cantidad){
        return cantidad;
    }

    /**retirarExistencia nos ayuda a eliminar ciertos elementos de la lista
     * @param cantidad  dato numerico que indica cuantos elementos se eliminan**/
    public static int retirarExistencia(int cantidad){
        return cantidad;
    }

    /**mostrarStock solo imprime lo que esta en existencias actuales**/
    public static void mostrarStock(){

    }

    public static void main(String[] args) {
        //llamo  a mi menu para que se muestre
        menu();
    }
}
