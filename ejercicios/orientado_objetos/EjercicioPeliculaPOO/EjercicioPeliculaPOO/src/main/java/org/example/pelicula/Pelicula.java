package org.example.pelicula;

import java.time.LocalDate;

//NO primitivos se comportan como objetos
public class Pelicula {
    //construir
    public String titulo;
    public String descripcion;
    public int duracion; // cuanto dura en minutos
    public String genero;
    public LocalDate fechaEstreno;
    public double calificacion;
    public boolean disponible;

    //creacion de metodos

    /**reproducir: imprime en la terminal el titulo**/
    public void reproducir(){
        System.out.println("Reproduciendo : "+this.titulo);
    }

    /**obtenerFichaTecnica: ayuda a obtener el titulo, fecha de estreno, genero y calificacion**/
    public String obtenerFichaTecnica(){
        return this.titulo + "\n(" + this.fechaEstreno + ")" +
                "\ngenero: "+this.genero + "\nCalificación: "+ this.calificacion;
    }

    /**calificar: comparo un parametro para ver si cumple un rango, si es asi si le asigna la calificacion
     * al de la estructura se le asigan el valor**/
    public void calificar(double calificacion){
        if((calificacion >= 0) && (calificacion <= 5)){
            //le asigna la calificacion al objeto solo si esta entre 0 a 5
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular(){
        //solo si la calificacion es mayor a 4 entonces es true, de caso contrario no
        return this.calificacion >= 4;
    }
}
