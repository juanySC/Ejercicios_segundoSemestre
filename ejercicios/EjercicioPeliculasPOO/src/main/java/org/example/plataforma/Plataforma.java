package org.example.plataforma;

import org.example.pelicula.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {

    //Atributos
    private String nombre;
    private List<Pelicula> contenido;

    //Contructor
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    //Metodos
    public void agregar(Pelicula pelicula){
        this.contenido.add(pelicula);
    }

    public void eliminar (Pelicula pelicula){
        this.contenido.remove(pelicula);
    }

    public void monstrarTitulos(){
        for(Pelicula pelicula : contenido){
            System.out.println(pelicula.getTitulo());
        }
    }

    public Pelicula buscarPorTitulo (String titulo){
        for (Pelicula pelicula: contenido){
            if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
                return pelicula;
            }
        }
        return  null;
    }

    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }

    public void setContenido(List<Pelicula> contenido) {
        this.contenido = contenido;
    }
}
