package org.example;

public class WhileLoop {
    //declaro mis variables
    static boolean laLuzDelFoco = false;

    public static void main(String[] args) {
        int i = 1;

        //llamo a mi funcion
        //cambioDeApagadoEncendido();
        //System.out.println(laLuzDelFoco);
        cambioDeApagadoEncendido();


        //ciclo para imprimir 10 veces PrintSOS
        while (laLuzDelFoco && i <= 10) {
            PrintSOS();
            i++;
        }
    }

    //funciones: es static porque lo usaremos en el main
    //es void porque solo vamos a imprimir y no devolver algo
    public static void PrintSOS(){
        System.out.println("...____...");
    }

    public static void cambioDeApagadoEncendido(){
        //operador ternario
        laLuzDelFoco = (laLuzDelFoco)?false: true;
    }
}
