package org.example;

import org.example.pelicula.Pelicula;
import org.example.plataforma.Plataforma;
import org.example.util.ScannerUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String NOMBRE_PLATAFORMA = "MESO VIDEO";
    public static final String VERSION = "1.0.0";
    //para el menu
    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO= 2;
    public static final int BUSCARTITULO = 3;
    public static final int ELIMINAR = 4;
    public static final int SALIR = 5;

    public static void main(String[] args) {

        //llamando la plataforma
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

        System.out.println(NOMBRE_PLATAFORMA + "V"+VERSION);
        cargarPeliculas(plataforma);
        //plataforma.mostrarTitulos();

        while (true){
            //hasta que
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar titulo
                    4. Eliminar
                    5. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR-> {
                    String nombre = ScannerUtils.capturarTexto("Nombre de pelicula");
                    String genero = ScannerUtils.capturarTexto("Género del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                }
                case MOSTRAR_TODO -> {
                    plataforma.mostrarTitulos();
                }
                case BUSCARTITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Ingrese el titulo  a buscar");

                    Pelicula peliculaEcontrada = plataforma.buscarPorTitulo(nombreBuscado);

                    //validacion si lo encuentra nos imprima el contenid
                    if (peliculaEcontrada != null){
                        System.out.println(peliculaEcontrada.obtenerFichaTecnica());
                    }else {
                        System.out.println(peliculaEcontrada + "Pelicula no encontrada en la plataforma");
                    }
                }
                case ELIMINAR -> {

                }
            }
        }

        //----------------------Otra pelicula METOOD ESTATICO ----------------------------

        //ahora llamandopero por metodos estaticos


        Pelicula pelicula2 = new Pelicula(nombre, duracion, genero);
        Pelicula pelicula1 = new Pelicula(nombre, duracion, genero);

        plataforma.agregar(pelicula1);
        plataforma.agregar(pelicula2); //eso hara que se vaya a mi arraylist para que se cree la lista
        System.out.println("Numero de elementos en la plataforma " + plataforma.getContenido().size()); //deme la lista y obtengo el tamaño del contenido

        plataforma.eliminar(pelicula1);
        //pelicula2.calificar(calificacion);
        //mostrando todo
       // System.out.println(pelicula2.obtenerFichaTecnica());

        plataforma.mostrarTitulos(); //para que me muestre el contenido de las platadormas
    }

    /**cargarPelicula solo puede usarse en esta clase main, SIMULA UNA BASE DEDATOS**/
    private static  void cargarPeliculas(Plataforma plataforma){
        //ouedo pasarle el objeto directamente
        plataforma.agregar(new Pelicula("Shrek", 90, "animado"));
        plataforma.agregar(new Pelicula("El Rey León", 88, "animado"));
        plataforma.agregar(new Pelicula("Titanic", 195, "drama"));
        plataforma.agregar(new Pelicula("Avatar", 162, "ciencia ficción"));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, "acción"));
        plataforma.agregar(new Pelicula("Toy Story", 81, "animado"));
        plataforma.agregar(new Pelicula("Forrest Gump", 142, "drama"));
        plataforma.agregar(new Pelicula("Jurassic Park", 127, "aventura"));
        plataforma.agregar(new Pelicula("The Matrix", 136, "ciencia ficción"));
        plataforma.agregar(new Pelicula("Gladiador", 155, "acción"));
        plataforma.agregar(new Pelicula("Buscando a Nemo", 100, "animado"));
        plataforma.agregar(new Pelicula("Los Increíbles", 115, "animado"));
        plataforma.agregar(new Pelicula("Frozen", 102, "animado"));
        plataforma.agregar(new Pelicula("Rápidos y Furiosos 7", 137, "acción"));
        plataforma.agregar(new Pelicula("Coco", 105, "animado"));
        plataforma.agregar(new Pelicula("Interstellar", 169, "ciencia ficción"));
        plataforma.agregar(new Pelicula("La La Land", 128, "musical"));
        plataforma.agregar(new Pelicula("Pulp Fiction", 154, "crimen"));
        plataforma.agregar(new Pelicula("El Padrino", 175, "drama"));
        plataforma.agregar(new Pelicula("Batman: El Caballero de la Noche", 152, "acción"));
        plataforma.agregar(new Pelicula("Up", 96, "animado"));
        plataforma.agregar(new Pelicula("El Viaje de Chihiro", 125, "animado"));
        plataforma.agregar(new Pelicula("Pantera Negra", 134, "acción"));
        plataforma.agregar(new Pelicula("Deadpool", 108, "acción"));
        plataforma.agregar(new Pelicula("Los Juegos del Hambre", 142, "aventura"));
        plataforma.agregar(new Pelicula("El Hobbit", 169, "aventura"));
        plataforma.agregar(new Pelicula("Piratas del Caribe", 143, "aventura"));
        plataforma.agregar(new Pelicula("Moana", 107, "animado"));
        plataforma.agregar(new Pelicula("El Origen", 148, "ciencia ficción"));
        plataforma.agregar(new Pelicula("El Gran Hotel Budapest", 99, "comedia"));

        plataforma.agregar(new Pelicula("Encanto", 102, "animado"));
        plataforma.agregar(new Pelicula("Soul", 100, "animado"));
        plataforma.agregar(new Pelicula("Luca", 95, "animado"));
        plataforma.agregar(new Pelicula("Red", 100, "animado"));
        plataforma.agregar(new Pelicula("La Bella y la Bestia", 84, "animado"));
        plataforma.agregar(new Pelicula("Aladdín", 90, "animado"));
        plataforma.agregar(new Pelicula("Cars", 117, "animado"));
        plataforma.agregar(new Pelicula("Los Minions", 91, "animado"));
        plataforma.agregar(new Pelicula("Madagascar", 86, "animado"));
        plataforma.agregar(new Pelicula("Cómo Entrenar a tu Dragón", 98, "animado"));
        plataforma.agregar(new Pelicula("Zootopia", 108, "animado"));
        plataforma.agregar(new Pelicula("El Libro de la Selva", 106, "aventura"));
        plataforma.agregar(new Pelicula("La Momia", 124, "aventura"));
        plataforma.agregar(new Pelicula("Guardianes de la Galaxia", 121, "ciencia ficción"));
        plataforma.agregar(new Pelicula("Capitán América: Civil War", 147, "acción"));
        plataforma.agregar(new Pelicula("Doctor Strange", 115, "ciencia ficción"));
        plataforma.agregar(new Pelicula("La Mujer Maravilla", 141, "acción"));
        plataforma.agregar(new Pelicula("Logan", 137, "acción"));
        plataforma.agregar(new Pelicula("Harry Potter y la Piedra Filosofal", 152, "fantasía"));
        plataforma.agregar(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 178, "fantasía"));


    }
}