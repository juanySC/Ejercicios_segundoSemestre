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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getTamañoGrupo() {
        return tamañoGrupo;
    }

    public void setTamañoGrupo(int tamañoGrupo) {
        this.tamañoGrupo = tamañoGrupo;
    }


    //toString par aobtener la informacion de la clase

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", mesa=" + mesa +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", minutos=" + minutos +
                ", tamañoGrupo=" + tamañoGrupo +
                '}';
    }
}
