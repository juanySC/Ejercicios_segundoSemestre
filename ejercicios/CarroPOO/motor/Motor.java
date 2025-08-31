/*1.Clase Motor
Atributos: eficienciaKmL (double, km por litro),encendido (boolean).

Métodos: encender(), apagar(), isEncendido(),getEficienciaKmL().
*/
package motor;

public class Motor {
    //atributos
    private double eficienciaKmL;
    private boolean encendido;

    //constructor
    //solo coloco eficiencia porque se supone que el motor siempre esta apagado al inicio
    public Motor(double eficienciaKmL){ 
        this.eficienciaKmL = eficienciaKmL;
        this.encendido = false;
    }

    //metodos
    /**encender me ayuda a saber si el motor esta encendido y si es así
     * entonces me devuelve una confirmación**/
    public void encender(){
        this.encendido = true;
    }

    /**apagar si el motor esta encendido utilizo este metodo para cambiarlo
     * de estado y apagarlo**/
    public void apagar(){
        this.encendido = false;
    }

    //getters y setters
    public boolean isEncendido(){
        return this.encendido;
    }

    public double getEficienciaKmL(){
        return this.eficienciaKmL;
    }
   
}
