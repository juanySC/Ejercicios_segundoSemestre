package org.example;

public class Main {
    public static void main(String[] args) {
        // Crear máquina
        MaquinaExpendedora maquina = new MaquinaExpendedora();

        // Crear productos
        Producto p1 = new Producto("A1", "Coca-Cola", 10.0, 5);
        Producto p2 = new Producto("B2", "Seven up", 8.0, 3);
        Producto p3 = new Producto("C3", "Fanta naranja", 5.0, 10);

        // Cargar productos
        maquina.agregarProducto(p1);
        maquina.agregarProducto(p2);
        maquina.agregarProducto(p3);

        // Mostrar catálogo
        maquina.listarProductos();

        // Simulación de compras
        maquina.insertarDinero(20);
        System.out.println(maquina.seleccionar("A1")); 
        System.out.println(maquina.seleccionar("B2")); 
        System.out.println(maquina.seleccionar("B2")); 
        System.out.println(maquina.seleccionar("B2")); 
        System.out.println(maquina.seleccionar("B2")); 

        // Ver cambio
        System.out.println("Cambio devuelto: Q" + maquina.devolverCambio());

        // Ventas totales
        System.out.println("Ventas totales: Q" + maquina.getTotalVentas());
    }
}
