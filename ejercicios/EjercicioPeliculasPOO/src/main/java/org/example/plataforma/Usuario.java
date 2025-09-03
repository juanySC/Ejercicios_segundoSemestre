package org.example.plataforma;
import org.example.pelicula.Pelicula;
import java.time.LocalDateTime;

public class Usuario {

    public String nombre;
    public String email;
    public LocalDateTime fechaRegistro;

    public void ver (Pelicula pelicula){
        System.out.println( this.nombre + "Esta viendo...");
        pelicula.reproducir();
    }





}
