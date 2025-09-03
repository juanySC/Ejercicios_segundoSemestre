package org.example.pelicula;
import java.time.LocalDate;


public class Pelicula {

    //Atributos
    private String titulo;
    private String desripcion;
    private int duracion;
    private String genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;

    public Pelicula (String titulo, int duracion, String genero){

        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = LocalDate.now();
        this.disponible = false;
    }

    public Pelicula(String titulo, int duracion, String genero, double calificacion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.calificacion = calificacion;
    }

    //Métodos
    public void reproducir (){
        System.out.println("Reproduciendo: " + this.titulo);
    }

    public String obtenerFichaTecnica () {
        return this.titulo + "(" + this.fechaEstreno + ")\n " +
                " genero: " + this.genero +
                " Calificación: " + this.calificacion;
    }

    public void calificar (double calificacion){
        if( calificacion >= 0 && calificacion <= 5){
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular (){
        return this.calificacion >= 4;
    }



    public String getTitulo() {
        return titulo;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
