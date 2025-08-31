
import java.util.Scanner;

import motor.Motor;

public class main {

    public static void main(String[] args) {
        //voy a leer entradas de usuario
        Scanner sc = new Scanner(System.in);

        //clase motor
        System.out.print("Introduce la eficiencia del motor (km/L): ");
        double eficiencia = sc.nextDouble();

        //creo mi instancia motor
        Motor miMotor = new Motor(eficiencia);
        //verifico si esta encendido o apago el moyor 
        System.out.println("El motor esta encendido?: " + miMotor.isEncendido());
        System.out.println("Motor encendido...");
        //llamo a mi metodo
        miMotor.encender();
        //lo apago
        System.out.println("El motor esta encendido? "+miMotor.isEncendido());

        //clase tanque

    }
   
}
