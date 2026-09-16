package classes;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Crear una lista polimórfica de vehículos
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        // Agregar un Auto y una Moto
        listaVehiculos.add(new Auto("Toyota", "Corolla", 30.0));
        listaVehiculos.add(new Moto("Yamaha", "MT-07", 20.0));

        int diasAlquiler = 5;

        System.out.println("=== SISTEMA DE ALQUILER DE VEHÍCULOS ===");

        // Recorrer la lista y calcular el costo
        for (Vehiculo v : listaVehiculos) {

            double costoTotal = v.calcularCostoAlquiler(diasAlquiler);

            System.out.println(
                "Vehículo: " + v.getMarca() + " " + v.getModelo()
                + " | Costo por " + diasAlquiler + " días: $" + costoTotal
            );
        }
    }
}