package org.example.gestor;

import org.example.cliente.Cliente;
import org.example.mesa.Mesa;
import org.example.reserva.Reserva;

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
    //getters and setters
    //toString
}
