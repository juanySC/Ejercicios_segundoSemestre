//Gestor básico de inventario: presente un menú: 1) Agregar
//existencias 2) Retirar existencias 3) Consultar stock 4) Salir. La
//variable stock se va modificando.
package org.example;
import com.sun.security.jgss.GSSUtil;

import  java.util.Scanner;

public class GestorInventario {
    static int mercancia = 0;


    /**menu ayuda a mostrar al usuario las opciones disponibles que puede hacer en el inventario **/
    public static void menu(){
        //opciones que tendran para seleccionar
        Scanner sc = new Scanner(System.in);
        String continuar;
        int opcion;

        System.out.println("\nEste programa es un gestor basico de inventario");

        do {
            System.out.println("\nSeleccione la opción que desee");
            System.out.println("1. Agregar existencias");
            System.out.println("2. Retirar existencias");
            System.out.println("3. Consultar stock");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            //opciones
            switch (opcion){
                case 1:
                    System.out.println("\nIngrese la cantidad que desee agregar");
                    int valorCantidad = sc.nextInt();
                    sc.nextLine();

                    agregarStock(valorCantidad);
                    break;
                case 2:
                    System.out.println("\nIngrese la cantidad que desee retirar");
                    int valorRetirado= sc.nextInt();
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
                    System.out.println("\nOpción no disponible, intente de nuevo");
            }

            //le pregunto al usuario si quiere repetir
            System.out.println("\n¿Deseas repetir el programa? s/n ");
            continuar = sc.nextLine();
        }while (continuar.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el programa");
    }

    /**agregarStock nos ayuda a agregar nuevos elementos
     * @param cantidadAgregar  dato numerico que indica cuantos elementos se agregan a la lista**/
    public static int agregarStock(int cantidadAgregar){
        //comparo si los numeros no son negativos
        if (cantidadAgregar>0){
            mercancia += cantidadAgregar;
            System.out.println("Se agregan "+cantidadAgregar+" de unidades");
        } else {
            System.out.println("Cantidad invalida, vuelva a intentarlo");
        }
        return mercancia;
    }

    /**retirarExistencia nos ayuda a eliminar ciertos elementos de la lista
     * @param cantidadRetirar  dato numerico que indica cuantos elementos se eliminan**/
    public static int retirarExistencia(int cantidadRetirar){
        //que no sobrepase a mi numero de existencia
        if ((cantidadRetirar>0) && (cantidadRetirar <=mercancia)){
            mercancia -= cantidadRetirar;
            System.out.println("Se retiran "+cantidadRetirar+" de unidades");
        }else {
            System.out.println("Cantidad invalida, no hay suficiente mercaderia");
        }
        return mercancia;
    }

    /**mostrarStock solo imprime lo que esta en existencias actuales**/
    public static void mostrarStock(){
        //solo imprimo
        System.out.println("La mercancia actual es: "+mercancia);
    }

    public static void main(String[] args) {
        //llamo  a mi menu para que se muestre
        menu();
    }
}
