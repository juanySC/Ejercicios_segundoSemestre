package org.example;

import org.example.cliente.Cliente;
import org.example.gestor.GestorReservas;
import org.example.mesa.Mesa;
import org.example.reserva.Reserva;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**Muestra el menú principal y gestiona las acciones del usuario**/
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        GestorReservas gestor = new GestorReservas();
        int opcion = -1;

        do {
            System.out.println("\n--- SISTEMA DE GESTION DE RESERVAS ---");
            System.out.println("1. Registrar Mesa");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Crear Reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                opcion = -1; // Mantener el bucle
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\nRegistrar Mesa");
                    System.out.print("Ingrese ID de la mesa: ");
                    String idMesa = scanner.nextLine();
                    System.out.print("Ingrese capacidad de la mesa: ");
                    int capacidadMesa = scanner.nextInt();
                    scanner.nextLine();
                    gestor.registrarMesa(new Mesa(idMesa, capacidadMesa));
                    gestor.listarMesas();
                    break;
                case 2:
                    System.out.println("\nRegistrar Cliente");
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese telefono del cliente: ");
                    String telefonoCliente = scanner.nextLine();
                    gestor.registrarCliente(new Cliente(nombreCliente, telefonoCliente));
                    gestor.listarClientes();
                    break;
                case 3:
                    System.out.println("\nCrear Reserva");
                    // Paso 1: Pedir al usuario que elija un cliente y buscarlo
                    gestor.listarClientes();
                    System.out.print("Ingrese el ID o nombre del cliente: ");
                    String idOpcionCliente = scanner.nextLine();
                    Cliente clienteSeleccionado = gestor.buscarClientePorIdONombre(idOpcionCliente);
                    if (clienteSeleccionado == null) {
                        System.out.println("Error: Cliente no encontrado.");
                        break;
                    }

                    // Paso 2: Pedir al usuario que elija una mesa y buscarla
                    gestor.listarMesas();
                    System.out.print("Ingrese el ID de la mesa: ");
                    String idOpcionMesa = scanner.nextLine();
                    Mesa mesaSeleccionada = gestor.buscarMesaPorId(idOpcionMesa);
                    if (mesaSeleccionada == null) {
                        System.out.println("Error: Mesa no encontrada.");
                        break;
                    }

                    // Paso 3: Pedir detalles de la reserva
                    System.out.print("Ingrese el anio de la reserva: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese el mes de la reserva: ");
                    int mes = scanner.nextInt();
                    System.out.print("Ingrese el dia de la reserva: ");
                    int dia = scanner.nextInt();
                    System.out.print("Ingrese la hora de inicio (0-23): ");
                    int hora = scanner.nextInt();
                    System.out.print("Ingrese la duracion en minutos: ");
                    int duracion = scanner.nextInt();
                    System.out.print("Ingrese el tamanio del grupo: ");
                    int tamanio = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    LocalDateTime fechaHora = LocalDateTime.of(anio, mes, dia, hora, 0);
                    gestor.crearReserva(mesaSeleccionada, clienteSeleccionado, fechaHora, duracion, tamanio);
                    gestor.listarReservas();
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }
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
        mostrarMenu();
    }
}