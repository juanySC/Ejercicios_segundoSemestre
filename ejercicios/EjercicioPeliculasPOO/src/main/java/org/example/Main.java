package org.example;

import org.example.pelicula.Pelicula;
import org.example.plataforma.Plataforma;
import org.example.plataforma.Usuario;
import org.example.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static final String  NOMBRE_PLATAFORMA = "MESO VIDEO";
    public static final String VERSION = "1.0.0";

    public static final  int AGREGAR = 1;
    public static final  int MOSTRAR_TODO = 2;
    public static final  int BUSCARTITULO = 3;
    public static final  int ELIMINAR = 4;
    public static final  int SALIR = 5;


    public static void main(String[] args) {

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);

        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
        
                Ingrese una de las siguientes opciones:
                1. Agregar contenido
                2. Mostrar todo
                3. Buscar Titulos
                4. eliminar 
                5.Salir
        """);

            switch (opcionElegida){
                case AGREGAR -> {
                    String nombre = ScannerUtils.capturarTexto("nombre de pelicula");
                    String genero = ScannerUtils.capturarTexto("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duracion del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("calificacion del contenido");

                    plataforma.agregar(new Pelicula(nombre,duracion,genero,calificacion));
                }
                case MOSTRAR_TODO -> plataforma.monstrarTitulos();
                case BUSCARTITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Ingrese el nombre a buscar");

                    Pelicula peliculaEncontrada = plataforma.buscarPorTitulo(nombreBuscado);

                    if(peliculaEncontrada != null){
                        System.out.println( peliculaEncontrada.obtenerFichaTecnica());
                    }else {
                        System.out.println(nombreBuscado + "no existe en la plataforma");
                    }
                }
                case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("nombre del contenido a elminiar");

                    Pelicula contenido = plataforma.buscarPorTitulo(nombreAEliminar);

                    if (contenido != null){
                        plataforma.eliminar(contenido);
                        System.out.println(nombreAEliminar + "eliminado ");
                    }else {
                        System.out.println(nombreAEliminar + "no existe dentro de la plaforma");
                    }
                }
                case SALIR -> System.exit(0);


            }

        }

    }

    private static void cargarPeliculas(Plataforma plataforma){
        plataforma.agregar(new Pelicula("Shrek",90,"animado"));
        plataforma.agregar(new Pelicula("Toy Story",81,"animado"));
        plataforma.agregar(new Pelicula("Buscando a Nemo",100,"animado"));
        plataforma.agregar(new Pelicula("Los Increíbles",115,"animado"));
        plataforma.agregar(new Pelicula("Coco",105,"animado"));
        plataforma.agregar(new Pelicula("Ratatouille",111,"animado"));
        plataforma.agregar(new Pelicula("Up",96,"animado"));
        plataforma.agregar(new Pelicula("Intensamente",95,"animado"));
        plataforma.agregar(new Pelicula("Frozen",102,"animado"));
        plataforma.agregar(new Pelicula("Moana",107,"animado"));
        plataforma.agregar(new Pelicula("Encanto",109,"animado"));

        plataforma.agregar(new Pelicula("El Rey León",88,"animado"));
        plataforma.agregar(new Pelicula("Aladdín",90,"animado"));
        plataforma.agregar(new Pelicula("Mulán",88,"animado"));
        plataforma.agregar(new Pelicula("Tarzán",92,"animado"));
        plataforma.agregar(new Pelicula("Hércules",93,"animado"));
        plataforma.agregar(new Pelicula("La Bella y la Bestia",84,"animado"));
        plataforma.agregar(new Pelicula("Pocahontas",81,"animado"));
        plataforma.agregar(new Pelicula("Blancanieves",83,"animado"));
        plataforma.agregar(new Pelicula("La Sirenita",83,"animado"));
        plataforma.agregar(new Pelicula("Dumbo",64,"animado"));

        plataforma.agregar(new Pelicula("Madagascar",86,"animado"));
        plataforma.agregar(new Pelicula("Kung Fu Panda",92,"animado"));
        plataforma.agregar(new Pelicula("Cómo entrenar a tu dragón",98,"animado"));
        plataforma.agregar(new Pelicula("Los Croods",95,"animado"));
        plataforma.agregar(new Pelicula("Trolls",92,"animado"));
        plataforma.agregar(new Pelicula("Megamente",95,"animado"));
        plataforma.agregar(new Pelicula("Sing",110,"animado"));
        plataforma.agregar(new Pelicula("Zootopia",108,"animado"));
        plataforma.agregar(new Pelicula("Monsters Inc.",92,"animado"));
        plataforma.agregar(new Pelicula("Monsters University",104,"animado"));

        plataforma.agregar(new Pelicula("Cars",117,"animado"));
        plataforma.agregar(new Pelicula("Cars 2",106,"animado"));
        plataforma.agregar(new Pelicula("Cars 3",102,"animado"));
        plataforma.agregar(new Pelicula("Wall-E",98,"animado"));
        plataforma.agregar(new Pelicula("Valiente",93,"animado"));
        plataforma.agregar(new Pelicula("El Buen Dinosaurio",100,"animado"));
        plataforma.agregar(new Pelicula("Bolt",96,"animado"));
        plataforma.agregar(new Pelicula("Big Hero 6",102,"animado"));
        plataforma.agregar(new Pelicula("Ralph el demoledor",101,"animado"));
        plataforma.agregar(new Pelicula("Wifi Ralph",112,"animado"));

        plataforma.agregar(new Pelicula("Luca",95,"animado"));
        plataforma.agregar(new Pelicula("Soul",100,"animado"));
        plataforma.agregar(new Pelicula("Elementos",103,"animado"));
        plataforma.agregar(new Pelicula("Red",100,"animado"));
        plataforma.agregar(new Pelicula("Frozen 2",103,"animado"));
        plataforma.agregar(new Pelicula("Pinocho",92,"animado"));
        plataforma.agregar(new Pelicula("Alicia en el país de las maravillas",75,"animado"));
        plataforma.agregar(new Pelicula("Peter Pan",77,"animado"));
        plataforma.agregar(new Pelicula("101 Dálmatas",79,"animado"));
        plataforma.agregar(new Pelicula("Bambi",70,"animado"));

    }

}
