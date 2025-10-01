/*Atributo privado: List<Nota> notas = new ArrayList<>();

Métodos públicos:

boolean agregar(Nota n) → no acepta títulos duplicados (mismo título, ignorando mayúsculas/minúsculas).

List<Nota> listar() → copia inmodificable (no la lista interna).

boolean eliminar(String titulo) → elimina por título (case-insensitive).*/

package agenda;
import nota.Nota;
import java.util.*;

public class Agenda {
    //llamo a mis notas como objeto ya que lo pondre en una lista
    private final List<Nota> notasLista = new ArrayList<>();

    //metodos
    public boolean agregar(Nota notita) {
        //agrego mi nota si el titutlo es diferente si no regreso un false
        for (Nota nota : notasLista) {
            //equalsIgnoreCase me ayuda a ignorar las mayusuclas y minisculas
            if (nota.getTitulo().equalsIgnoreCase(notita.getTitulo())) {
                return false;
            }
        }

        //con add agrego mis notas a la lista
        notasLista.add(notita);
        return true; //e agrego correctamente
    }

    public List<Nota> listar() {
        //es la creacion de una copia de la lista original 
        return new ArrayList<>(notasLista);
    }

    public boolean eliminar(String titulo) {
        //recorr mi lista de notas
        //size me ayuda a ver el tamaño de la lista
        for (int i = 0; i < notasLista.size(); i++) {
            //comparo los titulos e ignoro las mayusculas y minisculas  
            if (notasLista.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                //quito de la lsita el indice que conicide con el titulo
                notasLista.remove(i);
                return true;
            }
        }
        return false;
    }
}
