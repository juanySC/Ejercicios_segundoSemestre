package org.example;

public class Producto {

        //atributos
        public String codigo;
        public String nombre;
        public double precio;
        public int stock;


    //creando mi constructor
        Producto(String codigo, String nombre, double precio, int stock){
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        //getters and setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

        //metodos
        public static boolean hayStock() {
        return false;
    }

        public void venderUna() {
           if (stock >0){
               stock --;
           }
    }

        public void reponer(int cantidad){
            this.stock += 1;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    }
