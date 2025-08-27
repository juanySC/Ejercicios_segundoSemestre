package org.example;

import org.example.pelicula.Pelicula;
import org.example.plataforma.Plataforma;
import org.example.util.ScannerUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String NOMBRE_PLATAFORMA = "MESO VIDEO";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        //llamando la plataforma
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

        System.out.println(NOMBRE_PLATAFORMA + "V"+VERSION);
        //----------------------Otra pelicula METOOD ESTATICO ----------------------------

        //ahora llamandopero por metodos estaticos
        String nombre = ScannerUtils.capturarTexto("Nombre de pelicula");
        String genero = ScannerUtils.capturarTexto("Género del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

        Pelicula pelicula2 = new Pelicula(nombre, duracion, genero, calificacion);
        plataforma.agregar(pelicula2); //eso hara que se vaya a mi arraylist para que se cree la lista
        System.out.println("Numero de elementos en la plataforma " + plataforma.getContenido().size()); //deme la lista y obtengo el tamaño del contenido

        //pelicula2.calificar(calificacion);
        //mostrando todo
       // System.out.println(pelicula2.obtenerFichaTecnica());


    }
}