/*Mesa: id, capacidad, (opcional: ubicación).*/
package org.example.mesa;

public class Mesa {
    //atributos
    private String id;
    private int capacidad;

    //constructor

    public Mesa(String id,int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }
    //metodos
    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    //toString para que me devuelva la informacion de la clase

    @Override
    public String toString() {
        return "Mesa{" +
                "id='" + id + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
