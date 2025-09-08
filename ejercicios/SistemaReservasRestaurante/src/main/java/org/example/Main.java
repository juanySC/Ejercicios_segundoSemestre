package org.example;

import org.example.cliente.Cliente;
import org.example.mesa.Mesa;
import org.example.reserva.Reserva;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //CLASE MESA
        System.out.println("\nClase mesa");

        //instancio mi clase
        Mesa mesa = new Mesa("M001",5);
        System.out.println("El numero de reserva es: "+mesa.getId());
        System.out.println("la capacidad de la mesa es: "+mesa.getCapacidad());

        //CLASE CLIENTE
        System.out.println("\nClase cliente");

        //instancio mi clase
        Cliente cliente = new Cliente("Annelis", "1234-5678" );
        System.out.println("Se reservo a nombre de: "+ cliente.getNombre() + " y su numero telefonico es: " + cliente.getTelefono());

        //CLASE RESERVA
        System.out.println("\nClase reserva");
        LocalDateTime hoy = LocalDateTime.now();

        //instancio mi clase
        Reserva reserva = new Reserva(cliente, mesa, hoy, 90,4);
        reserva.setId("R001");

        System.out.println("Su reserva ha sido exitoso: "+reserva.toString());

        //METODO MENU
    }
}