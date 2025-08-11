package org.example;

import java.time.LocalDate;

public class Pelicula {
    public String tituto;
    public String descripcion;
    public int duracion;
    public String genero;
    public LocalDate fechaEstreno;
    public double calificacion;
    public boolean disponible;

    public void reproducir(){
        System.out.println("Resproduciendo "+this.tituto); //this: al mismo contexto de la clase
    }

    public String obtenerFichaTecnica(){
        return tituto + "(" + fechaEstreno + ")\n"+
                "genero: "+genero + "\n" +
                "Calificación" + calificacion + "/5";
    }

    public void calificar(double calificacion){
        if (calificacion>= 0 && calificacion <= 5){
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular(){
        return calificacion>=4; //true
    }
}

