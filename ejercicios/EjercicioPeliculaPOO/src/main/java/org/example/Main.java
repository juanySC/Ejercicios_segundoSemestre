package org.example;

import org.example.pelicula.Genero;
import org.example.pelicula.Pelicula;
import org.example.plataforma.Calidad;
import org.example.plataforma.Idioma;
import org.example.plataforma.Plataforma;
import org.example.util.ScannerUtils;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String NOMBRE_PLATAFORMA = "MESO VIDEO";
    public static final String VERSION = "1.0.0";
    //para el menu
    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO= 2;
    public static final int BUSCARTITULO = 3;
    //nuevo
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int BUSCAR_POR_MAYORDURACION = 5;
    public static final int BUSCAR_POR_MENORDURACION = 6;
    public static  final int POPULARES_MAYORESA4 = 10;
    public static final int VER_POPULARES = 7;
    public static final int ELIMINAR = 8;
    public static final int SALIR = 9;

    public static void main(String[] args) {

        //llamando la plataforma
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

        System.out.println(NOMBRE_PLATAFORMA + "V"+VERSION);
        cargarPeliculas(plataforma);

        //llamando a mi duracion de peliculas

        System.out.println("Mas de: "+plataforma.getDuracion()+" minutos de contenido");
        //plataforma.mostrarTitulos();

        while (true){
            //hasta que
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar titulo
                    4. Buscar por genero
                    5, Mayor duracion
                    6. Menor duracion
                    7. Buscar populares por calificacion
                    8. Eliminar
                    9. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR-> {
                    String nombre = ScannerUtils.capturarTexto("Nombre de pelicula");
                    //Genero genero = Genero.valueOf(ScannerUtils.capturarTexto("Género del contenido"));
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");
                    Idioma idioma = ScannerUtils.capturarIdioma("Idioma del contenido");
                    Calidad calidad = ScannerUtils.capturarCalidad("Calidad del contenido ");

                    //agregamos una excepcion
                    try {
                        plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion, idioma, calidad));
                    } catch (Exception e){
                        //que atrape la excepcion qu enosostos ya creamos

                        //throw  new RuntimeException(e);
                        System.out.println(e.getMessage());
                    }

                }
                case MOSTRAR_TODO -> {
                    //plataforma.mostrarTitulos();
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach((String titulo) -> System.out.println(titulo) );
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
                case BUSCAR_POR_GENERO -> {
                    //Genero generoBuscado = Genero.valueOf(ScannerUtils.capturarTexto("Genero del contenido a buscar: "));
                    Genero generoBuscado = ScannerUtils.capturarGenero("Genero a buscar");
                   //devuelve la lista o sea lo imprime                            //busca el genero que se busca
                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    //imprimo
                    //10 peliculas enocntradas para el genero accion
                    System.out.println("\n"+ contenidoPorGenero.size() + "encontrados para el genero: "+ generoBuscado);

                    //recorro
                    contenidoPorGenero.forEach((Pelicula contenido)
                            -> System.out.println(contenido.obtenerFichaTecnica() + " \n"));
                }
                case VER_POPULARES -> {
                    //llamo a mifuncion que esta en la platadorma
                    List<Pelicula> contenidoPopulares = plataforma.getPopulares();

                    contenidoPopulares.forEach((Pelicula contenido) ->
                            System.out.println(contenido.obtenerFichaTecnica()));
                } case POPULARES_MAYORESA4 -> {
                    List<Pelicula> contenidoPopular = plataforma.getPopulares();
                    contenidoPopular.forEach((Pelicula contenido) -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case BUSCAR_POR_MAYORDURACION -> {
                    Pelicula peliculaMayorDuracion = plataforma.peliculaLarga();
                    System.out.println(peliculaMayorDuracion != null? ("La pelicula mas larga es: " + peliculaMayorDuracion.obtenerFichaTecnica()): "No existe una pelicula con mayor duracion que el resto");
                }
                case BUSCAR_POR_MENORDURACION-> {
                    Pelicula peliculaMenorDuracion = plataforma.peliculaLarga();
                    System.out.println(peliculaMenorDuracion != null? ("La pelicula mas larga es: " + peliculaMenorDuracion.obtenerFichaTecnica()): "No existe una pelicula con mayor duracion que el resto");
                }
                case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Nombre del titulo a eliminar");

                    //guardar una pelicula
                    Pelicula contenido = plataforma.buscarPorTitulo(nombreAEliminar);

                    if (contenido!= null){
                        plataforma.eliminar(contenido);
                        System.out.println(nombreAEliminar + "eliminado");
                    } else {
                        System.out.println("No existe dentro de la plataforma");
                    }
                }
                case SALIR -> System.exit(0);
            }
        }

    }

    /**cargarPelicula solo puede usarse en esta clase main, SIMULA UNA BASE DEDATOS**/
    private static  void cargarPeliculas(Plataforma plataforma){
        //ouedo pasarle el objeto directamente
        plataforma.agregar(new Pelicula("Shrek", 90, Genero.ACCCION, 4.5, Idioma.ESPANIOL, Calidad.CL_420));
        plataforma.agregar(new Pelicula("Matrix", 136, Genero.ANIMADA,4.8, Idioma.FRANCES, Calidad.CL_1080));
        plataforma.agregar(new Pelicula("Forrest Gump", 142, Genero.ACCCION, 4.9, Idioma.KICHE, Calidad.CL_720));
        plataforma.agregar(new Pelicula("Gladiador", 155, Genero.ACCCION, 4.7, Idioma.ESPANIOL, Calidad.CL_720));
        plataforma.agregar(new Pelicula("Buscando a Nemo", 100, Genero.ANIMADA, 4.6, Idioma.ESPANIOL, Calidad.CL_1080));
        plataforma.agregar(new Pelicula("Titanic", 195, Genero.ACCCION, 4.3, Idioma.INGLES, Calidad.CL_720));
        plataforma.agregar(new Pelicula("El Rey León", 88, Genero.ANIMADA, 4.8, Idioma.ESPANIOL, Calidad.CL_1080));
        plataforma.agregar(new Pelicula("Interestelar", 169, Genero.CIENCIA, 4.9, Idioma.KICHE, Calidad.CL_420));
        plataforma.agregar(new Pelicula("Coco", 105, Genero.TERROR, 4.7, Idioma.KICHE, Calidad.CL_420));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, Genero.ACCCION, 4.6, Idioma.FRANCES, Calidad.CL_1080));
        plataforma.agregar(new Pelicula("Inception", 148, Genero.CIENCIA, 4.9, Idioma.INGLES, Calidad.CL_720));
        plataforma.agregar(new Pelicula("Toy Story", 81, Genero.COMEDIA, 4.5, Idioma.INGLES, Calidad.CL_420));
        plataforma.agregar(new Pelicula("Joker", 122, Genero.TERROR, 4.4, Idioma.FRANCES, Calidad.CL_720));


    }
}