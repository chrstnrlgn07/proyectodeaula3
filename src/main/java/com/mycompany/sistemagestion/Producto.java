package com.mycompany.sistemagestion;

public final class Producto {
    private int id;
    private String nombre;
    private double precio;

   
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        setPrecio(precio);
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio;
    }
}