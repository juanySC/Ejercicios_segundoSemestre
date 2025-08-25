package org.example;

import org.example.pelicula.Pelicula;
import org.example.util.ScannerUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String NOMBRE_PLATAFORMA = "MESO VIDEO";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        System.out.println(NOMBRE_PLATAFORMA);
        System.out.println(VERSION);


        /*
                 //instanciar un objeto
       // Pelicula pocoyoPelicula = new Pelicula();

        //ahora entro al atributo
        pocoyoPelicula.titulo = "Pocoyo la pelicula";
        pocoyoPelicula.fechaEstreno = LocalDate.of(2018,10,15);
        pocoyoPelicula.genero = "Infantil";
        pocoyoPelicula.duracion = 120;

        //llamo al metodo que esta en la clase "Pelicula"
        pocoyoPelicula.calificar(3.5);

        pocoyoPelicula.reproducir();

        //mostrar la ficha tecnica
        System.out.println(pocoyoPelicula.obtenerFichaTecnica());long duracionLong = pocoyoPelicula.duracion;
        //casteao = conversion
        int calificacionInt = (int)pocoyoPelicula.calificacion;
        System.out.println(duracionLong +" -------- " +calificacionInt);*/

        //----------------------Otra pelicula METOOD ESTATICO ----------------------------

        //ahora llamandopero por metodos estaticos
        String nombre = ScannerUtils.capturarTexto("Nombre de pelicula");
        String genero = ScannerUtils.capturarTexto("Género del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

        Pelicula pelicula2 = new Pelicula(nombre, duracion, genero, calificacion);
        Pelicula pelicula3 = new Pelicula(nombre, duracion, genero, calificacion);


        //pelicula2.titulo = nombre;
        //pelicula2.fechaEstreno = LocalDate.of(2018, 8, 14);
         //pelicula2.genero = genero;
        pelicula2.calificar(calificacion);
        //pelicula2.duracion = duracion;

        //mostrando todo
        System.out.println("");
        System.out.println(pelicula2.obtenerFichaTecnica());

        //------------------------Usuario----------------------------

        /*//instanciar usuario
        Usuario usuario = new Usuario();
        usuario.nombre = "Fredy";
        usuario.fechaResgistro = LocalDateTime.of(2025, 12, 24, 17, 12, 00);

        //veremos cuando se registro
        System.out.println("\n");
        System.out.println(usuario.fechaResgistro);

        usuario.ver(pocoyoPelicula);*/

    }
}