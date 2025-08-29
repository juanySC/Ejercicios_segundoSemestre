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
        double espacioDisponible = this.capacidadLitros - this.nivelLitros;
        double recargoEfectivo = 0;

        if (litros > espacioDisponible ){
            //me da la oportunidad de solo recargar el espacio disponible
            recargoEfectivo = espacioDisponible;
        } else{
            recargoEfectivo = litros;
        }
        
        //actualizo el nivel de litros
        this.nivelLitros = this.nivelLitros + recargoEfectivo;

        return recargoEfectivo; //retorno los litros que recargue
    }

    public void consumir(double litros){
        if (litros <= 0) return; //porque no tiene sentido consumir si es menos o igual a 0
        //verifico si hay suficiente combustible
        if (this.nivelLitros > litros){ 
            //si tengo suficiente litro entonces puedo consumir los litros que deseo
            this.nivelLitros = nivelLitros - litros;
        } else{
            //le mando un mensaje que no hay suficiente combustible
            throw new IllegalArgumentException("No hay suficiente combustible en el tanque");
        }
    }
        
    //getters y setters
    public double getNivelLitros(){
        return this.nivelLitros;
    }
}
   

