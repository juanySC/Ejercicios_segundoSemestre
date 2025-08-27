package org.example;

public class Producto {
    public String codigo; // inmutable
    public String nombre;
    public double precio;
    public int stock;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos
    public boolean hayStock() {
        return stock > 0;
    }

    public boolean venderUna() {
        if (hayStock()) {
            stock--;
            return true;
        }
        return false;
    }

    public void reponer(int cant) {
        stock += cant;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    // Representación en texto
    @Override
    public String toString() {
        return codigo + " - " + nombre + " (Q" + precio + ") Stock: " + stock;
    }
}
