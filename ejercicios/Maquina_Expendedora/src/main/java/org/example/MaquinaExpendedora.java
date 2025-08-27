package org.example;

import java.util.HashMap;
import java.util.Map;

public class MaquinaExpendedora {
    public double saldoInsertado;
    public double totalVentas;
    public Map<String, Producto> catalogo;

    // Constructor
    public MaquinaExpendedora() {
        this.saldoInsertado = 0.0;
        this.totalVentas = 0.0;
        this.catalogo = new HashMap<>();
    }

    // Agregar productos al catálogo
    public void agregarProducto(Producto p) {
        catalogo.put(p.getCodigo(), p);
    }

    // Insertar dinero
    public void insertarDinero(double monto) {
        if (monto > 0) {
            saldoInsertado += monto;
            System.out.println("Saldo insertado: Q" + saldoInsertado);
        } else {
            System.out.println("Monto inválido.");
        }
    }

    // Seleccionar producto
    public String seleccionar(String codigo) {
        Producto p = catalogo.get(codigo);
        if (p == null) {
            return "Producto no encontrado.";
        }
        if (!p.hayStock()) {
            return " Producto agotado.";
        }
        if (saldoInsertado < p.getPrecio()) {
            return "Saldo insuficiente. Inserte más dinero.";
        }

        // Venta exitosa
        p.venderUna();
        saldoInsertado -= p.getPrecio();
        totalVentas += p.getPrecio();
        return "✅ Entregado: " + p.getNombre();
    }

    // Devolver cambio
    public double devolverCambio() {
        double cambio = saldoInsertado;
        saldoInsertado = 0;
        return cambio;
    }

    // Listar catálogo
    public void listarProductos() {
        System.out.println("\n--- Catálogo de productos ---");
        for (Producto p : catalogo.values()) {
            System.out.println(p);
        }
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}
