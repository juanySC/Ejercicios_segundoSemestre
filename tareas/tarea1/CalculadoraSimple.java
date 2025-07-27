/*a.Pide dos double y un operador (+, -, *, /).
b.Con switch, realiza la operación; si es división y el divisor
es 0, muestra “Error: división por cero”.*/

import java.util.Scanner;

public class CalculadoraSimple{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //lee la entrada del teclado
        String continuarUsuario;
        double numeroUno, numeroDos, resultado;
        char operacionAritmerica; //para recibir +, -, *, /

        System.out.println("\nEl programa es una calculadora simple");

        //para que el programa se ejecute una vez
        do {
            System.out.println("\nIngrese el primer número entero o decimal: ");
            numeroUno = sc.nextDouble();
            sc.nextLine(); //para que lea la entrada y no lo deje vacio
            System.out.println("Ingrese el segundo número entero o decimal: ");
            numeroDos = sc.nextDouble();
            sc.nextLine();
            System.out.println("\nIngrese uno de los siguientes simbolos: ");
            System.out.println("+, -, *, /");
            operacionAritmerica = sc.next().charAt(0); //solo toma el primer simbolo 
            sc.nextLine();

            //logica
            switch (operacionAritmerica) {
                case '+': //como es caracter es comilla simple
                    resultado = numeroUno + numeroDos;
                    System.out.println("\nLa suma de "+numeroUno +" y "+numeroDos+" es: "+resultado);
                    break;
                case '-':
                    resultado = numeroUno + numeroDos;
                    System.out.println("\nLa resta de "+numeroUno +" y "+numeroDos+" es: "+resultado);
                    break;
                case '*':
                    resultado = numeroUno * numeroDos;
                    System.out.println("\nLa multiplicacion de "+numeroUno +" y "+numeroDos+" es: "+resultado);
                    break;
                case '/':
                    resultado = numeroUno /numeroDos;
                    //condicion
                    if (numeroDos != 0) {
                        System.out.println("\nLa división de "+numeroUno +" y "+numeroDos+" es: "+resultado);
                    } else {
                        System.out.println("\nError: division por cero");
                    }
                    break;        
                default:
                    System.out.println("\nLa operación no existe, intente de nuevo");
                    break;
            }

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        } while (continuarUsuario.equalsIgnoreCase("s"));
        
        sc.close();
        System.out.println("\nGracias por usar el programa");
    }
}