/*a.Pide el peso del paquete en kg y si el destino es nacional
(true) o internacional (false).
b.Reglas:
i.Peso ≤ 2 kg → $5 (nac.) ó $15 (int.)
ii.2 < peso ≤ 5 kg → $10 (nac.) ó $25 (int.)
iii.Peso > 5 kg → $20 (nac.) ó $50 (int.)
c.Usa if-else con operadores lógicos (&&)*/
import java.util.Scanner;
public class TarifaEnvio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean destinoNacional = true; //para saber si es nacional o internacional
        float pesoPaquete; //me ayudara a determinar el precio segun el peso
        String continuarUsuario; //

        System.out.println("\nEste programa calcula la tarifa de envio del paquete");

        //para que se repita el programa por lo menos una vez
        do {
            System.out.println("\nIngrese en kg el peso del paquete: ");
            pesoPaquete = sc.nextFloat();
            sc.nextLine();
            System.out.println("Ingrese si el destino es nacional? true/faslse ");
            destinoNacional = sc.nextBoolean();
            sc.nextLine();

            //logica del codigo para verificar pago y si en envio nacional
            if ((pesoPaquete <= 2) && (destinoNacional)) { //envio nacional = true
                System.out.println("\nEl precio es: $5");
            } else if ((pesoPaquete <= 2) && (!destinoNacional)) { //envio nacional = false
                System.out.println("\nEl precio es: $15");
            } else if ((pesoPaquete > 2 && pesoPaquete <= 5) && (destinoNacional)) {
                System.out.println("\nEl precio es: $10");
            } else if ((pesoPaquete > 2) && (pesoPaquete <= 5) && (!destinoNacional)) {
                System.out.println("\nEl precio es: $25");
            } else if ((pesoPaquete > 5) && (destinoNacional)) {
                System.out.println("\nEl precio es: $20");
            } else {
                System.out.println("\nEl precio es: $50");
            }
            
            //le pregunto al usuario si desea continuar
            System.out.println("¿Desea ingresar otro paquete para saber el precio? s/n");
            continuarUsuario = sc.nextLine();
        } while (continuarUsuario.equalsIgnoreCase("s"));

    }
}
