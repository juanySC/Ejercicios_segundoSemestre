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
    private int tamanioGrupo;

    //constructor

    public Reserva(Cliente cliente, Mesa mesa, LocalDateTime fechaHoraInicio, int minutos, int tamanioGrupo) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.fechaHoraInicio = fechaHoraInicio;
        this.minutos = minutos;
        this.tamanioGrupo = tamanioGrupo;
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

    public int getTamanioGrupo() {
        return tamanioGrupo;
    }

    public void setTamanioGrupo(int tamanioGrupo) {
        this.tamanioGrupo = tamanioGrupo;
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
                ", tamañoGrupo=" + tamanioGrupo +
                '}';
    }
}
