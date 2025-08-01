/*Conversor de unidades de longitud: el usuario elige (por código)
entre m ↔ cm ↔ in ↔ ft y proporciona el valor. Use switch para
las combinaciones permitidas (4 en total).*/
package org.example;
import java.util.Scanner;

public class UnidadesDeLongitud {

    /**
     * conversionBase nos ayuda a transformar sin importar la conversion inicial
     * a una conversion en  metros para poder realizar las demas operaciones
     * @param numero de entrada para convertirlo a metros
     * @param opcion de la entrada del ususario, para saber que tipo de conversion
     *               se maneja
     * **/
    public static double conversionBase(double numero, char opcion){
        //hare casos dependiendo la entrada del usuario
        switch (opcion){
            case 'm':
                return numero;
            //no coloco break ya que hay un return y termina de buscar si encuentra el caso
            case 'c':
                return numero / 100;
            case 'i':
                return numero*0.0254;
            case 'f':
                return numero*0.3048;
            default:
                return -1; //es una forma común de indicar un error o un valor inválido
        }
    }

    /**
     * conversionBase nos ayuda a transformar sin importar la conversion inicial
     * a una conversion en  metros para poder realizar las demas operaciones
     * @param numeroBase de entrada para convertir de metros a los demas tipos de conversion
     * @param opcion de la entrada del ususario, para saber que tipo de conversion desea
     *               trasformarlo
     * **/
    public static double convertirValorFinal(double numeroBase, char opcion){
        //ahora convierto de metros a las otras 3 opociones
        switch (opcion){
            case 'm':
                return numeroBase;
            case 'c':
                return numeroBase * 100;
            case 'i':
                return numeroBase*39.3701;
            case 'f':
                return numeroBase*3.28084;
            default:
                return -1;
        }
    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String continuarUsuario;
    double valorInicial, valorConversion;
    char opcionEntrada, opcionSalida;

    System.out.println("\nEste programa es un conversor de unidades de longitud");

    do{
        System.out.println("\nIngrese la opcion que desee con un caracter");
        System.out.println("m (metro)- c (centimetro)- i (pulgada)- f (pie) ");
        opcionEntrada = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("\nIngrese el valor numerico: ");
        valorInicial = sc.nextDouble();
        sc.nextLine();
        //ahora le solicito a que unidad desea llevarlo
        System.out.println("\n¿A que unidad desea transformarlo? ");
        System.out.println("m (metro)- c (centimetro)- i (pulgada)- f (pie) ");
        opcionSalida = sc.next().charAt(0);
        sc.nextLine();

        //hago una validacion de si elige mal o escribe una letra incorreta


        //primero lo convierto a metros
        double base = conversionBase(valorInicial, opcionEntrada);
        // hago la conversion
        double resultadoConversion = convertirValorFinal(base, opcionSalida);

        System.out.println("\nEl resutlado de la conversion es: "+resultadoConversion);

        //le pregunto al usuario si desea repetir el programa
        System.out.println("\n¿Desea repetir el programa? s/n ");
        continuarUsuario = sc.nextLine();
    }while (continuarUsuario.equalsIgnoreCase("s"));

    sc.close();
        System.out.println("Gracias por usar el programa");
    }
}
