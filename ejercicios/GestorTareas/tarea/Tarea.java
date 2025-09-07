package tarea;

public class Tarea {
    //atributos
    private String id;
    private String titulo;
    private String descripcion;
    private boolean completada;

    //constructor
    public Tarea(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }
    //metodos
    /**marcarCompleta solo hace que el estado de la tarea pase a verdadero**/
    public void marcarCompleta(){
        this.completada = true;
    }

     /**marcarPendiente solo hace que el estado de la tarea pase a falso porque
      * no se ha realizado nada con esto todavia**/
    public void marcarPendiente(){
         this.completada = false;
    }

     /**alterarEstado me ayuda a pasar el estado inverso en el que este
      * verdadero = falso (pendiente)
      falso = verdadero (completo)**/
    public void alternarEstado(){
        if (this.completada == true) {
            this.completada = false;
        } else{
            this.completada = true;
        }
    }

    //getters and setters
    public String getId() { //solo lo obtengo porque no lo puedo modificar
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

   //toString para devolver todos los datos de manera ordenada
   
     @Override
    public String toString() {
        return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", completada=" + completada
                + "]";
    }
   

}
