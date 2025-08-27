package org.example.plataforma;

import org.example.pelicula.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    //atributo
    private String nombre;
    private List<Pelicula> contenido;

    //constructores

    //cuando creemos una isntancia de plataforma, tenemos que pasarle un nombre y el listado de peliculas
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>(); //el contenido es un array vacio para que yo incluya la pelicula
    }

    //metodos

    /**
     * agregar a una lista de la pelicula al this. contenido que le voy asignar un valor
    *  @param  elemento me ayuda asignarle un elemento al contenido, o sea se hara una lista*/
    public void agregar(Pelicula elemento){
        //add me sirve agregar un elemento al contenido
        this.contenido.add(elemento);
    }
}
