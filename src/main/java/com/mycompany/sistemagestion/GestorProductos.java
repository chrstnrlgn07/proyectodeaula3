package com.mycompany.sistemagestion;

import java.util.ArrayList;

public class GestorProductos {
    private final ArrayList<Producto> listaProductos;

    public GestorProductos() {
        this.listaProductos = new ArrayList<>();
    }

    
    public boolean crearProducto(Producto nuevoProducto) {
        for (Producto p : listaProductos) {
            if (p.getId() == nuevoProducto.getId()) {
                return false; 
            }
        }
        listaProductos.add(nuevoProducto);
        return true;
    }

    
    public ArrayList<Producto> obtenerProductos() {
        return listaProductos;
    }

    
    public boolean actualizarPrecio(int id, double nuevoPrecio) {
        for (Producto p : listaProductos) {
            if (p.getId() == id) {
                p.setPrecio(nuevoPrecio);
                return true;
            }
        }
        return false; 
    }

    
    public boolean eliminarProducto(int id) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == id) {
                listaProductos.remove(i);
                return true;
            }
        }
        return false; 
    }
}

