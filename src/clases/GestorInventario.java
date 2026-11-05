package clases;

import java.util.ArrayList;
import java.util.List;

public class GestorInventario {

    private final List<Producto> inventario;

    public GestorInventario() {
        inventario = new ArrayList<>();
    }

    // Registrar un producto
    public boolean registrarProducto(Producto producto) {
        if (producto == null || buscarProducto(producto.getId()) != null) {
            return false;
        }

        inventario.add(producto);
        return true;
    }

    // Mete todos los productos en un arraylist
    public List<Producto> listarProductos() {
        return new ArrayList<>(inventario);
    }

    // Buscar un producto por su ID
    public Producto buscarProducto(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    // Actualizar los datos de un producto
    public boolean actualizarProducto(
            int id,
            String nombre,
            String categoria,
            double precio,
            String fechaVencimiento) {

        Producto producto = buscarProducto(id);

        if (producto == null || nombre == null || nombre.isBlank()
                || categoria == null || categoria.isBlank()
                || fechaVencimiento == null || fechaVencimiento.isBlank()
                || precio < 0 || !Double.isFinite(precio)) {
            return false;
        }

        producto.setNombre(nombre);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        producto.setFechaVencimiento(fechaVencimiento);

        return true;
    }

    // Eliminar un producto
    public boolean eliminarProducto(int id) {
        Producto producto = buscarProducto(id);

        if (producto == null) {
            return false;
        }

        inventario.remove(producto);
        return true;
    }

    // Descontar unidades del inventario
    public boolean venderProducto(int id, int cantidad) {
        Producto producto = buscarProducto(id);

        if (producto == null || cantidad <= 0
                || cantidad > producto.getCantidad()) {
            return false;
        }

        producto.setCantidad(producto.getCantidad() - cantidad);
        return true;
    }

    // Reponer unidades del inventario
    public boolean reponerProducto(int id, int cantidad) {
        Producto producto = buscarProducto(id);

        if (producto == null || cantidad <= 0
                || cantidad > Integer.MAX_VALUE - producto.getCantidad()) {
            return false;
        }

        producto.setCantidad(producto.getCantidad() + cantidad);
        return true;
    }
    
    public int obtenerSiguienteId() {
    int mayorId = 0;

        for (Producto producto : inventario) {
            if (producto.getId() > mayorId) {
                mayorId = producto.getId();
            }
        }

        return mayorId + 1;
    }
}
