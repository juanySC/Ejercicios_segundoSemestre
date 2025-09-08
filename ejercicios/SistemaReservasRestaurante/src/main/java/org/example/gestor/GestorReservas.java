package org.example.gestor;

import org.example.cliente.Cliente;
import org.example.mesa.Mesa;
import org.example.reserva.Reserva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    //atributos
    //como seran listas las que tenga y no solo uno, hago un array
    private List<Mesa> mesita;
    private List<Cliente> clientito;
    private List<Reserva> reservita;

    //constructor

    public GestorReservas() {
        this.mesita = new ArrayList<>();
        this.clientito = new ArrayList<>();
        this.reservita = new ArrayList<>();
    }

    //metodos
    /**registrarMesa llama al objeto Mesa y lo añade a la lista**/
    public void registrarMesa(Mesa mesa){
        this.mesita.add(mesa);
    }

    /**registrarCliente llama al objeto cliente y lo añade a la lista**/
    public void registrarCliente(Cliente cliente){
        this.clientito.add(cliente);
    }

    /**BuscarMesaPorId por su id o nombre.
     * @param idMesa El id o nombre del cliente a buscar.
     * @return El objeto cliente si se encuentra, o null si no existe**/
    public Mesa buscarMesaPorId(String idMesa) {
        for (Mesa mesa : mesita) {
            if (mesa.getId().equals(idMesa)) {
                return mesa;
            }
        }
        return null;
    }

    /**buscarClientePorIdONombre por su id o nombre.
     * @param idOpcionCliente El id o nombre del cliente a buscar.
     * @return El objeto cliente si se encuentra, o null si no existe**/
    public Cliente buscarClientePorIdONombre(String idOpcionCliente) {
        for (Cliente cliente : clientito) {
            // Se busca por ID o por nombre
            if (cliente.getId().equals(idOpcionCliente) || cliente.getNombre().equalsIgnoreCase(idOpcionCliente)) {
                return cliente;
            }
        }
        return null;
    }
    /**crearReserva ayuda a pasar los parametros de mesa, cliente, horario,
    * duracion, capacidad, solapamiento y limite**/
    public void crearReserva(Mesa mesa, Cliente cliente, LocalDateTime fechaHoraInicio, int minutos, int tamanioGrupo){

        //el cliente, mesa y hora no sean nulo
        if (mesa != null || cliente != null || fechaHoraInicio!= null){
            System.out.println("La reserva va bien");
        } else {
            System.out.println("Requisitos no completos");
        }

        //tamaño del grupo
        if (tamanioGrupo <= mesa.getCapacidad()){
            System.out.println("Cumple con el tamaño de mesa");
        } else{
            System.out.println("Se excede la cantidad de clientes por mesa");
        }

        //horario
        // Usamos el método getHour() para obtener la hora de la fecha/hora.
        int horarioAtencion = fechaHoraInicio.getHour();
        if (horarioAtencion >= 11 && horarioAtencion <= 22){
            System.out.println("Entra en el horario de atencion");
        } else {
            System.out.println("Horario no permitido");
        }

        //solapamiento
        for (Reserva reservaExistente: reservita) {
            //obtengo el numero de mesa, el id, revisa cada mesa existente con el for
            //equals es comparar si la mesa antigua es igual a la misma que se quiere reserva?
            if (reservaExistente.getMesa().getId().equals(mesa.getId())){
                System.out.println("La mesa esta libre");
                //primero obtengo los minutos de esa mesa reservada
                // le sumo 15 = 90 ´+ 15 y se compara con la fecha de inicio
                // Este es un método de la clase LocalDateTime que te permite sumarle minutos a una fecha y hora.
                LocalDateTime finReserva = reservaExistente.getFechaHoraInicio().plusMinutes(reservaExistente.getMinutos()+15);

                //verifico si la mesa antigua y la que me piden son la misma
                //isBefore(): Este método responde a la pregunta: "¿Esta fecha y hora está antes que otraFecha?". Si es así, devuelve true
                //isAfter(); Este método responde a la pregunta: "¿Esta fecha y hora está después que otraFecha?". Si es así, devuelve true.
                boolean noSolapa = finReserva.isBefore(reservaExistente.getFechaHoraInicio()) || fechaHoraInicio.isAfter(finReserva);

                // Si no se solapa, continuamos con la siguiente reserva
                if (noSolapa) {
                    continue;
                } else {
                    //  muestra un error y salimos del método
                    System.out.println("Error: La mesa ya está reservada en ese horario.");
                    return;
                }
            }
        }

        //se crea la nueva reserva
        int reservasDelDia = 0;
        for (Reserva r : reservita) {
            // Comparamos los clientes por su ID y la fecha por el día
            if (r.getCliente().getId().equals(cliente.getId()) && r.getFechaHoraInicio().toLocalDate().isEqual(fechaHoraInicio.toLocalDate())) {
                reservasDelDia++;
            }
        }
        if (reservasDelDia >= 2) {
            System.out.println("Error: El cliente ya tiene 2 reservas para este día.");
            return;
        }

        // Si todas las validaciones pasan, se crea la reserva
        String idReserva = String.format("R-%03d", reservita.size() + 1);
        Reserva nuevaReserva = new Reserva(cliente, mesa, fechaHoraInicio, minutos, tamanioGrupo);
        nuevaReserva.setId(idReserva);
        reservita.add(nuevaReserva);

        System.out.println("Su reservación ha sido exitoso, el ID de reserva: " + idReserva);

    }

    /**Muestra una lista de todas las mesas registradas**/
    public void listarMesas() {
        if (mesita.isEmpty()) {
            System.out.println("No hay mesas registradas.");
            return;
        }
        System.out.println("\nMesas Registradas");
        for (Mesa mesa : mesita) {
            System.out.println(mesa.toString());
        }
    }

    /**Muestra una lista de todos los clientes registrados**/
    public void listarClientes() {
        if (clientito.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\n Clientes Registrados");
        for (Cliente cliente : clientito) {
            System.out.println(cliente.toString());
        }
    }

    /**Muestra una lista de todas las reservas creadas.**/
    public void listarReservas() {
        //isEmty devuelve un valor booleano
        if (reservita.isEmpty()) {
            System.out.println("No hay reservas creadas.");
            return;
        }
        System.out.println("\nReservas Creadas ");
        for (Reserva reserva : reservita) {
            System.out.println(reserva.toString());
        }
    }

}
