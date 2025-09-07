/*Reserva: id, cliente, mesa, fecha-hora de inicio, duración en
minutos, tamaño del grupo.*/
package org.example.reserva;

import org.example.cliente.Cliente;
import org.example.mesa.Mesa;

import java.time.LocalDateTime;

public class Reserva {
    //atributos
    private String id ;
    private Cliente cliente;
    private Mesa mesa;
    private LocalDateTime fechaHoraInicio;
    private int minutos;
    private int tamañoGrupo;

    //constructor

    public Reserva(Cliente cliente, Mesa mesa, LocalDateTime fechaHoraInicio, int minutos, int tamañoGrupo) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.fechaHoraInicio = fechaHoraInicio;
        this.minutos = minutos;
        this.tamañoGrupo = tamañoGrupo;
    }


    //metodos
    //getters and setters
}
