/*a.Pregunta color del semáforo ("verde", "amarillo", "rojo") y
si el botón de peatón está pulsado (true/false).
b.Con switch y if anidado decide:
c.Verde & botón false → “Sigue caminando”.
d.Amarillo & botón true → “Espera”.
e.Rojo & botón true → “Cruza con cuidado”.
f.Resto → “Detente”.
*/
import java.util.Scanner;

public class SemaforoPeatonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //entrada por teclado
        String continuarUsuario; //servira para saber si el usuario desea repetir el programa
        String color;
        boolean boton = true;

        System.out.println("\nEste programa simula el semaforo e indica si el peaton puede o no cruzar la calle");
        System.out.println("Colores: verde, amarillo y rojo");
        
        //para repetir el programa una vez
        do {
            System.out.println("\nIngresa el color del semaforo: ");
            color = sc.nextLine().toLowerCase(); //por si el usuario escribe en mayuscula o minuscula
            System.out.println("El boton esta presionado ? true/false ");
            boton = sc.nextBoolean();
            sc.nextLine(); //para que no lo tome vacio y avanze el programa

            //logica
            switch (color) {
            case "verde": //como estoy recibiendo string es doble comilla
                if (!boton){
                    System.out.println("\nSigue caminando");
                }else{
                    System.out.println("Detente");
                }    
                break;
            case "amarillo":
                if (boton){
                    System.out.println("\nEspera");
                }else{
                    System.out.println("\nDetente");
                }   
                break;
            case "rojo":
                if (boton){
                System.out.println("\nCruza con cuidado");
                }else{
                    System.out.println("\nDetente");
                }   
                break;        
            default:
                System.out.println("\nDetente");
        }

            //le pregunto al usuario si desea repetir el programa
            System.out.println("\n¿Deseas repetir el programa? s/n");
            continuarUsuario = sc.nextLine();
        } while (continuarUsuario.equalsIgnoreCase("s"));
        
        sc.close();
        System.out.println("Gracias por usar el programa");
    }
}
