package org.example;

import org.example.pelicula.Pelicula;
import org.example.utilidades.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //instanciar un objeto
        Pelicula pocoyoPelicula = new Pelicula();

        //ahora entro al atributo
        pocoyoPelicula.titulo = "Pocoyo la pelicula";
        pocoyoPelicula.fechaEstreno = LocalDate.of(2018,10,15);
        pocoyoPelicula.genero = "Infantil";
        pocoyoPelicula.duracion = 120;

        //llamo al metodo que esta en la clase "Pelicula"
        pocoyoPelicula.calificar(3.5);
        pocoyoPelicula.reproducir();

        //mostrar la ficha tecnica
        System.out.println(pocoyoPelicula.obtenerFichaTecnica());

        long duracionLong = pocoyoPelicula.duracion;
        //casteao = conversion
        int calificacionInt = (int)pocoyoPelicula.calificacion;
        System.out.println(duracionLong +" -------- " +calificacionInt);

        //instanciar usuario
        Usuario usuario = new Usuario();
        usuario.nombre = "Fredy";
        usuario.fechaResgistro = LocalDateTime.of(2025, 12, 24, 17, 12, 00);

        //veremos cuando se registro
        System.out.println("\n");
        System.out.println(usuario.fechaResgistro);

        usuario.ver(pocoyoPelicula);

    }
}