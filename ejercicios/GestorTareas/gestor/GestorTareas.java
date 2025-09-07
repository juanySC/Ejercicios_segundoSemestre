/*mantiene una lista de tareas y ofrece operaciones
CRUD básicas y consultas.*/
package gestor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import tarea.Tarea;

public class GestorTareas {
    //atributos
    private List<Tarea> tareas;
    private int contadorId;
    private String ultimoError;

    //constructor
    public GestorTareas(){
        this.contadorId = 1; //comience en 1
        this.tareas = new ArrayList<>(); //creando la lista vacia
        this.ultimoError = ""; //el mensaje que le dare
    }

    //metodos

    /**
     * Crea una nueva tarea y la añade a la lista de tareas.
     * @param titulo El título de la tarea, no puede esta vacio
     * @param descripcion La descripción de la tarea
     * @return El objeto Tarea creado si la operación es exitosa, o null si falla.
     */
    public Tarea crearTarea(String titulo, String descripcion){
        //1.- Crea una nueva cadena de texto a partir de la original, pero eliminando 
        //todos los espacios en blanco que pueda tener al principio y al final. 
        //2.-  Este método comprueba si la cadena de texto está vacía después de que se eliminaron los espacios
        // devuelve un true
        if (titulo == null || titulo.trim().isEmpty()) {
            ultimoError = "No se puede crear la tarea sin el titulo";
            return null;//no me devuelve nada
        } 

        //genero el id unico
        String idGenerado =  String.format("T%03d", contadorId);
        contadorId++; //para que vaya cambiando el id

        //instancia de tarea
        Tarea tareita = new Tarea(titulo, descripcion);
        tareita.setId(idGenerado);
        this.tareas.add(tareita);

        //limpia el error
        this.ultimoError = "";
        return tareita;
    }

    /**
     * Busca por id las tareas en la lista que hemos creado de tareas
     * @param id servira para hacer la comparacion y buscar el id
     * @return el id si conindice o nulo sino encuentra ninguna similar 
     */
    public Tarea buscarTarea(String id){
        //buscar en el arreglo
        for (Tarea tarea : this.tareas) { //recorro mi arraylist
            if ( tarea.getId().equals(id) ) { //comparo mis ids
                return tarea;
            }    
        }
         return null;
    }

    /**
     * Ayuda a eliminar tareas de la lista creada
     * @param id servira para hacer la comparacion y buscar el id
     * @return el id si conindice devuelvo que fue eliminada o no 
     */
    public boolean eliminarTarea(String id){
        //llamo a mi metodo buscar y solo obtengo si el id se condigui o no
        //instancio una variable
        Tarea tareaEliminar = buscarTarea(id);

        //buscar en el arreglo
       if (tareaEliminar!= null) {
         this.tareas.remove(tareaEliminar);
         return true;
       }

       return false;
    }

    /**completarTarea recorre el listado y me lo muestra, llamada al 
     * metodo marcarCompleta de la clase Tarea**/
    public boolean completarTarea(String id){
        Tarea completado = buscarTarea(id);
        if (completado != null) {
           completado.marcarCompleta(); //llamo a mi metodo de tarea
           return true;
        }

        return false; //no encontro la tarea
    }

    /**anternarEstado recorre el listado y me lo muestra, llamada al 
     * metodo alternarEstado de la clase Tarea**/
    public boolean alternarEstado(String id){
        Tarea alternar = buscarTarea(id);
        if (alternar != null) {
            alternar.alternarEstado(); //llamo a mi metodo de tarea
            return true;
        }

        return false;
    }


    /**listarTarea recorre el listado y me lo muestra**/
    public void listarTarea(){
        for (Tarea tarea : this.tareas) {
            System.out.println(tarea.toString());
        }
    }

    /**listarPendiente recorre el listado y me lo muestra**/
    public void listarPendiente(){
        for (Tarea tarea : this.tareas) {
            if (tarea.isCompletada() == false) {
                System.out.println(tarea.toString());
            }
           
        }
    }

    /**listarCompletadas recorre el listado y me lo muestra**/
    public void listarCompletadas(){
        for (Tarea tarea : this.tareas) {
            if (tarea.isCompletada() == true) {
                System.out.println(tarea.toString());
            }
           
        }
    }

    //getters and setters
     public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public int getContadorId() {
        return contadorId;
    }

    public void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public String getUltimoError() {
        return ultimoError;
    }

    public void setUltimoError(String ultimoError) {
        this.ultimoError = ultimoError;
    }

    
}
