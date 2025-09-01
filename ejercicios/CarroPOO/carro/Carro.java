/*3.Clase Carro (compone Motor y Tanque)
Atributos: placa (String, final), marca, modelo, anio,
velocidadActual, velocidadMaxima, odometro.

Atributos de relación: motor: Motor, tanque: Tanque.

Métodos: encender(), apagar(), acelerar(int), frenar(int),
recargar(double) -> double (delegar en tanque),
conducir(double km) -> double (consume combustible
según eficiencia; retorna km realmente recorridos)*/
package carro;

//importo mis clases de tanque y motor
import motor.Motor;
import tanque.Tanque;

public class Carro {
    //atributos
    private final String placa;
    private String marca;
    private String modelo;
    private int anio;
    private double velocidadActual;
    private double velocidadMaxima;
    private double odometro;

    //llamo a los atributos de las clases
    private Motor motor;
    private Tanque tanque;

    //constructor
    public Carro(String placa, String marca, String modelo, int anio, double velocidadMaxima, Motor motor, Tanque tanque) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadActual = 0;
        this.velocidadMaxima = velocidadMaxima;
        this.odometro = 0;
        this.motor = motor;
        this.tanque = tanque;
    }

    //metodos
    /** enceder metodo que me dira si el carro esta encendido**/
    public void encender(){
        this.motor.encender();
        System.out.println("El carro esta encendido...");
    }

    /**apagar me dira si el carro se apaga**/
    public void apagar(){
        this.motor.apagar();
        velocidadActual = 0; //porque al apagarse no tiene nada de velocidad y no se mueve
        System.out.println("El carro esta apagado...");
    }

    /**
     * Acelera el carro, aumentando la velocidad actual.
     * @param incremento La cantidad en que aumenta la velocidad.
     */
    public void acelerar(int incremento){
        if (motor.isEncendido()) {
            //incremeto
            this.velocidadActual = this.velocidadActual + incremento;
            //hago una comparacion para actualizar cual es la velcidad que llevo
            if (velocidadActual > velocidadMaxima) {
                this.velocidadActual = this.velocidadMaxima; //se le asigana el valor
            }
        } else{
            System.out.println("El motor esta apagado, no se puede acelerar");
        }
    }

     /**
     * Frena el carro, disminuyendo la velocidad actual.
     * @param decremento La cantidad en que disminuye la velocidad.
     */
    public void frenar(int decremento){
        this.velocidadActual = this.velocidadActual - decremento;
        if (this.velocidadActual < 0) {
            this.velocidadActual = 0; //porque no se puede negativo
        } 

        System.out.println("El carro esta freannado, la velocidad actal es de "+this.velocidadActual+ "km/h");
    }

    /**
     * recargar combustible en el tanque del carro
     *pero esta en la clase tanque
     * @param litros La cantidad de litros a recargar
     * @return Los litros efectivamente
     */
    public double recargar(double litros){
        return this.tanque.recargar(litros);
    }

     /**
     * conducir consumiendo combustible y actualizando el odómetro.
     * @param km es la distancia que recorre en kilometros
     * @return devuelve los km recorridos
     */
    public double conducir(double km){
        if (!motor.isEncendido()) {
            System.out.println("El motor esta apagado, no puede conducir");
            return 0;
        }

        if (km <= 0) {
            System.out.println("La distancia tiene que ser mayor a cero");
            return 0;
        }

        //logica para que el carro se mueva y consuma combustible
        double litrosMoverse = km/ motor.getEficienciaKmL();//calculo los litros que necesito para moverme
        double KmRecorridos = 0;
        
        try {
            tanque.consumir(litrosMoverse);
            //se puede mover
            this.odometro = this.odometro + km; //actualizo el tablero
            KmRecorridos= km; //actualizo los km recorridos
            System.out.println("El carro se movio " + km + " km.");
            return KmRecorridos;
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
            //solo recorremos los km con el combustibke que nos dan
            double kmDisponibles = tanque.getNivelLitros() * motor.getEficienciaKmL();
            KmRecorridos = kmDisponibles;
            //se va a mover lo que le quede
            this.odometro = this.odometro + kmDisponibles; //actualizo el tablero
            //actualizo el tanque en consumir y llamo al metodo
            tanque.consumir(tanque.getNivelLitros()); //consumo lo que me queda
            System.out.println("Se recorrio solo " + kmDisponibles + " km por falta de combustible.");
        }
        return KmRecorridos;
    }

    //getters y setters

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }
    
    public double getOdometro() {
        return odometro;
    }
    
    public double getNivelCombustible() {
        return tanque.getNivelLitros();
    }
    
}
