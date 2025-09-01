
import java.util.Scanner;

import motor.Motor;
import tanque.Tanque;
import carro.Carro;

public class main {

    public static void main(String[] args) {
        //voy a leer entradas de usuario
        Scanner sc = new Scanner(System.in);

        //CLASE MOTOR
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

        //CLASE TANQUE

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

        sc.nextLine(); //limpio el buffer

        //CLASE CARRO
        //personalizo el carro
        System.out.println("\nIntroduce la placa del carro: ");
        String placa = sc.nextLine();
        System.out.println("Introduce la marca del carro: ");
        String marca = sc.nextLine();
        System.out.println("Introduce el modelo del carro: ");
        String modelo = sc.nextLine();
        System.out.println("Introduce el año del carro: ");
        int anio = sc.nextInt();
        System.out.println("Introduce la velocidad maxima del carro (km/h): ");
        double velocidadMaxima = sc.nextDouble();
        sc.nextLine(); //limpio el buffer

        //creo mi instancia de carro
        Carro miCarro = new Carro(placa, marca, modelo, anio, velocidadMaxima, miMotor, miTanque);

        //obtengo los datos del carro y los muestro
        System.out.println("El carro creado es:"+miCarro.getMarca()+ " y "+miCarro.getPlaca());

        //llamo a los metodos del carro 
        System.out.println("\nEl carro esta encendido?... "+miMotor.isEncendido());
        miCarro.encender();
       

        //distancia que deseo recorrer
        System.out.println("\n¿Que distancia deseas recorrer en km?: ");
        double distancia = sc.nextDouble();
        sc.nextLine(); 

        //ahora conduzco 
        miCarro.conducir(distancia);

        //actualizo el nivel del tanque despues de que se conduce
        System.out.println("\nNivel actual del tanque despues de conducir: " + miTanque.getNivelLitros() + " L");
        System.out.println("Odometro del carro: " + miCarro.getOdometro() + " km");

        //apago el carro
        miCarro.apagar();
        System.out.println("El carro esta encendido?..."+miMotor.isEncendido());
        sc.close();
    }
   
}
