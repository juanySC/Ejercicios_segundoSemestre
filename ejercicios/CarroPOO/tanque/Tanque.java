/*Clase Tanque
Atributos: capacidadLitros (double, final), nivelLitros
(double).
Métodos: recargar(double) -> double (retorna litros
efectivamente cargados),
consumir(double) (lanza excepción si no hay suficiente),
getNivelLitros().*/
package tanque;

public class Tanque {
    //atributos
    private final double capacidadLitros; //si pongo el valor aqui entonces ya no lo podre modificar
    private double nivelLitros;

    //constructor
    public Tanque( double capacidadLitros){
        this.capacidadLitros = capacidadLitros; //le asignare un valor
        this.nivelLitros = 0.0; //el tanque esta vacio
    }

    //metodos
    /**
     * recargar me ayudara a recragar el tanque con cirtos litros y tendra condicionales
     * para saber si puedo recargar o no, asi como recargar todo lo que yo le pido o solo 
     * el espacio disponible
     * @param litros me ayudara a saber cuantos litros quiero recargar
     * @return litros que recargo
    **/
    public double recargar(double litros){
        if (litros <= 0) return 0; //porque no tiene sentido recargar 0 o valores negativos
        //me ayudara a saber si tengo o no espacio disponible
        double espacioDisponible = capacidadLitros - nivelLitros;
        if (litros <=espacioDisponible ){
            nivelLitros = nivelLitros + litros;
        }else{
            //me da la oportunidad de solo recargar el espacio disponible
            nivelLitros = capacidadLitros; 
        }
        
        //actualizo el nivel de litros
        nivelLitros = nivelLitros + litros;

        return litros; //retorno los litros que recargue
    }

    public void consumir(double litros){

    }
        
    //getters y setters
    public double getNivelLitros(){
        return this.nivelLitros;
    }
}
   

