/*Atributos privados: titulo:String, nota:String, createdAt:LocalDateTime.

Constructor mínimo que reciba titulo y opcionalmente nota.

createdAt se establece automáticamente la fecha de creación.

Constante de clase static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

Getters/Setters:

setTitulo(...) no permite null ni vacío.

setNota(...) admite null → se guarda como "".

getCreatedAtFormatted() devuelve createdAt con FMT.*/

package nota;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Nota {
    //atributos
    private String titulo;
    private String nota;
    private LocalDateTime createdAt;
    public static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    //constructor
     public Nota(String titulo, String nota) {
        
        this.titulo = titulo.trim();
        //si mi nota no hay nada, se guarda solo "" y si la nota tiene valor se le asigna a nota
        this.nota = (nota == null) ? "" : nota; 
        //obtengo mi fehca de hoy
        this.createdAt = LocalDateTime.now(); 
    }

    //metodos

    /**getCreatedAtFormatted devuelve la fecha de la creacion y tambien la nta
    **/
    public String getCreatedAtFormatted() {
        return createdAt.format(FMT);
    }

    //getters and setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        //mi cadena vacia
        if (titulo == null) {
            this.titulo = "";
            //trim son los espacios vaicios
        } else if (titulo.trim().isEmpty()) {
            this.titulo = "";
        } else {
            this.titulo = titulo.trim();
        }
    }
    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        //si la nota esta vacia o es null la nota solo se guarda como un espacio
        // ""
         if (nota == null) {
            this.nota = "";
        } else {
            //si hay nota se lo asigno 
            this.nota = nota;
        }
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
   

   
    //toString para obtener la informacion
   @Override
    public String toString() {  
        //es para saber si esta vacio la nota
    String estadoNota = nota.isEmpty() ? " " : nota;
    return String.format("%s Titulo creado: %s  Nota: %s", 
        titulo, 
        getCreatedAtFormatted(), 
        estadoNota);
    }

}
