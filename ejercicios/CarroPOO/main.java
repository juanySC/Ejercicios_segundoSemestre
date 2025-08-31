
import java.util.Scanner;

import motor.Motor;
import tanque.Tanque;

public class main {

    public static void main(String[] args) {
        //voy a leer entradas de usuario
        Scanner sc = new Scanner(System.in);

        //clase motor
        System.out.print("\nIntroduce la eficiencia del motor (km/L): ");
        double eficiencia = sc.nextDouble();

        //creo mi instancia motor
        Motor miMotor = new Motor(eficiencia);
        //verifico si esta encendido o apago el moyor 
        System.out.println("\nEl motor esta encendido?: " + miMotor.isEncendido());
        System.out.println("Motor encendido...");
        //llamo a mi metodo
        miMotor.encender();
        //lo apago
        System.out.println("El motor esta encendido? "+miMotor.isEncendido());

        //clase tanque

        System.out.println("\nIntroduce la capacidad del tanque en Litros: ");
        double capacidad = sc.nextDouble();

        //creo mi instancia de tanque
        Tanque miTanque = new Tanque(capacidad); //parametro loq ue le pido al usuario
        System.out.println("\n¿cual es el nivel inicial del tanque?" +miTanque.getNivelLitros()+"litros");

        //solicitar lo que se va a recagar
        System.out.println("\n¿con cuantos litros deseas llenar?: ");
        double litrosRecargar = sc.nextDouble();

        //lo recargo con el metodo
        double litrosCargados = miTanque.recargar(litrosRecargar);
        System.out.println("\nSe cargaron: "+litrosCargados+"litros");
        System.out.println("El nivel actual del tanque es:" +miTanque.getNivelLitros()+"litros");

        //los litros que desea consumir
        System.out.println("\n¿cuantos litros desea consumir?: ");
        double litrosConsumir = sc.nextDouble();

        //ahora hago una condicional 
        System.out.println("Consumiendo " + litrosConsumir + " litros...");
        
        try {
            miTanque.consumir(litrosConsumir);
            System.out.println("Nivel actual del tanque: " + miTanque.getNivelLitros() + " L");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al consumir: " + e.getMessage());
        }

        sc.close();
    }
   
}
