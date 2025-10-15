import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeerYProcesarArchivo {

    public static void main(String[] args) {
        // atributos
        int contadorProductos;
        double sumaPrecios;
        double precioPromedio;
        String productoMasCaro;
        //creando listas para el nombr ey precios
        List<String> nombresProductos = new ArrayList<>();
        List<Double> preciosProductos = new ArrayList<>();
       

        //lecyuta

        try {
           List<String> lineas = Files.readAllLines(Path.of("productos.txt"));
            for (String linea : lineas) {
            // Aquí procesas cada línea
            System.out.println(linea);
            }

            //System.out.println("Contenido del archivo:" + lineas);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
