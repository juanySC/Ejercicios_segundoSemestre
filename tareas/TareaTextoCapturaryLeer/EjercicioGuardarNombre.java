import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;

public class EjercicioGuardarNombre {
    public static void main(String[] args) {
        //atributos
        Scanner sc = new Scanner(System.in);
        final String FIN = "FIN";
        //creo una lista para guardar los nombres
        List<String> nombresIngresados = new ArrayList<>();
        String nombre;
        
        //bienvenida e instrucciones
        System.out.println("\nHola, por favor ingresa un nombre");
        System.out.println("el texto se acaba cuando ingrese hasta que escriba FIN");

        //hare un blucle para que se rompa cuando se escriba FIN
        do {
        //obteniendo los nombres
        
        nombre = sc.nextLine();

        if (!nombre.equalsIgnoreCase(FIN)) {
            //ahora los guardo 
            nombresIngresados.add(nombre);
            System.out.println("Nombre guardado, ingrese otro nombre o escriba FIN");

        }

        } while (!nombre.equalsIgnoreCase(FIN));

        //ahora solo compurebo que si lo capture
        System.out.println("Los nombre ingresados:" + nombresIngresados);

        //ahora usando 
        try (FileWriter escribir = new FileWriter("nombres.txt")) {
            for (String n : nombresIngresados) {
                escribir.write(n + "\n");
            }
            System.out.println("Nombres guardados en nombres.txt");
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No se pudieron guardar los nombres"+ e.getMessage());
        }
    }
}