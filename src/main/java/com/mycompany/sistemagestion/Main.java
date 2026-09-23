
package com.mycompany.sistemagestion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();
        int opcion = 0;
        
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE INVENTARIO ===");
            System.out.println("1. Registrar Producto (Crear)");
            System.out.println("2. Mostrar Productos (Leer)");
            System.out.println("3. Modificar Precio (Actualizar)");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID único del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    
                    double precio = -1;
                    while (precio < 0) {
                        System.out.print("Ingrese el precio: ");
                        precio = scanner.nextDouble();
                        if (precio < 0) {
                            System.out.println("Error: El precio no puede ser negativo.");
                        }
                    }

                    Producto nuevo = new Producto(id, nombre, precio);
                    if (gestor.crearProducto(nuevo)) {
                        System.out.println("¡Producto registrado con éxito!");
                    } else {
                        System.out.println("Error: Ya existe un producto con el ID " + id);
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PRODUCTOS ---");
                    if (!gestor.obtenerProductos().isEmpty()){
                        for (Producto p : gestor.obtenerProductos()) {
                            System.out.println(p);
                        }
                    } else {
                        System.out.println("El inventario está vacío.");
                    }
                    break;


                case 3:
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int idAct = scanner.nextInt();
                    
                    double nuevoPrecio = -1;
                    while (nuevoPrecio < 0) {
                        System.out.print("Ingrese el nuevo precio: ");
                        nuevoPrecio = scanner.nextDouble();
                        if (nuevoPrecio < 0) {
                            System.out.println("Error: El precio no puede ser negativo.");
                        }
                    }

                    if (gestor.actualizarPrecio(idAct, nuevoPrecio)) {
                        System.out.println("¡Precio actualizado correctamente!");
                    } else {
                        System.out.println("Error: No se encontró un producto con ese ID.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idDel = scanner.nextInt();

                    if (gestor.eliminarProducto(idDel)) {
                        System.out.println("¡Producto eliminado del inventario!");
                    } else {
                        System.out.println("Error: No se encontró un producto con ese ID.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Elija entre 1 y 5.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}