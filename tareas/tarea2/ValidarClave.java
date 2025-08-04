/*Validador de contraseñas: pida repetidamente una contraseña
hasta que cumpla:- 8 caracteres mínimo- al menos una
mayúscula, una minúscula y un dígito- no contener espacios.
Informe cada fallo específico.
*/
package org.example;
import java.util.Scanner;

public class ValidarClave {

    /**cumpleContrasenia nos ayuda a identificar si cumple con los 4 requisitos que se requieren
     * @param contrasenia  ayuda a comparar la cadena de texto si tiene todos los requisitos**/
    public static boolean cumpleContrasenia(String contrasenia){
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;
        char caracter;

        //recorro cada caracter de la contraeña
        for (int i = 0; i <contrasenia.length() ; i++) {
            caracter = contrasenia.charAt(i); //va  a recorrer cada caracter
            if (Character.isUpperCase(caracter)) { //es un método estático que determina si un carácter dado es una letra mayúscula
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) { // es un método estático que determina si un carácter dado es una letra minúscula
                tieneMinuscula = true;
            } else if (Character.isDigit(caracter)) { //determina si exoste algun numero
                tieneNumero = true;
            } else if ("!@#$%^&*".indexOf(caracter) != -1) {
                tieneSimbolo = true;
            }
        }

        //si cumple con los requisitos
        boolean longitudCorrecta = contrasenia.length() >= 8; //8 caracteres minimo
        boolean sinEspacios = !contrasenia.contains(" ");

        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneSimbolo && longitudCorrecta && sinEspacios;
    }

    /**erroresContrasenia nos ayuda a identificar las caracterisitcas que hicieron falta
     * @param contrasenia  ayuda a comparar la cadena de texto con los requisitos y los faltantes**/
    public static void erroresContrasenia(String contrasenia){
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;

        for (int i = 0; i < contrasenia.length(); i++) {
            char caracter = contrasenia.charAt(i);
            if (Character.isUpperCase(caracter)) tieneMayuscula = true;
            else if (Character.isLowerCase(caracter)) tieneMinuscula = true;
            else if (Character.isDigit(caracter)) tieneNumero = true;
            else if ("!@#$%^&*".indexOf(caracter) != -1) tieneSimbolo = true;
        }

        //si no cumple con alguna de la socndiciones entonces devuelve un mensaje
        if (!tieneMayuscula) System.out.println("Falta una letra mayúscula.");
        if (!tieneMinuscula) System.out.println("Falta una letra minúscula.");
        if (!tieneNumero) System.out.println(" Falta un número.");
        if (!tieneSimbolo) System.out.println("Falta un símbolo especial (!@#$%^&*).");
        if (contrasenia.length() < 8) System.out.println(" Debe tener mínimo 8 caracteres.");
        if (contrasenia.contains(" ")) System.out.println("No debe contener espacios."); //contains = ayuda a verificar si tiene un espacio en blanco
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String continuarUsuario;
        String cadena;
        boolean esCorrecta;

        do{

            System.out.println("Bienvenido al validador de contraseñas seguras.");

            do {
                System.out.print("\nIngrese su contraseña: ");
                cadena = sc.nextLine();

                esCorrecta = cumpleContrasenia(cadena);

                if (esCorrecta) {
                    System.out.println("Contraseña válida");
                } else {
                    System.out.println("Contraseña inválida.");
                    erroresContrasenia(cadena);
                }

            } while (!esCorrecta);

            //le pregunto al usuario si desea repetir el programa
            System.out.println("¿Deseas repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        }while(continuarUsuario.equalsIgnoreCase("s"));
        sc.close();
        System.out.println("Gracias por usar el programa");
    }
}
