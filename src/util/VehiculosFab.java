package util;

import java.util.Map;

import vehiculos.Auto;
import vehiculos.Moto;

public class VehiculosFab {
    // Método para crear un Auto a partir de un mapa de datos
    public static Auto createAuto(Map<String, String> data) {
        try {
            return new Auto(
                    data.getOrDefault("marca", "Desconocida"),
                    data.getOrDefault("modelo", "Desconocido"),
                    Integer.parseInt(data.getOrDefault("año", "0")),
                    Integer.parseInt(data.getOrDefault("precio", "0")),
                    data.getOrDefault("kilometros", "0 km"),
                    Integer.parseInt(data.getOrDefault("puertas", "4")),
                    Boolean.parseBoolean(data.getOrDefault("deportivo", "false")),
                    data.getOrDefault("velocidad", "0 km/h"),
                    Integer.parseInt(data.getOrDefault("caballos", "0")));
        } catch (NumberFormatException e) {
            System.out.println("Error al crear Auto: " + e.getMessage());
            return null;
        }
    }

    // Método para crear una Moto a partir de un mapa de datos
    public static Moto createMoto(Map<String, String> data) {
        try {
            return new Moto(
                    data.getOrDefault("marca", "Desconocida"),
                    data.getOrDefault("modelo", "Desconocido"),
                    Integer.parseInt(data.getOrDefault("año", "0")),
                    Integer.parseInt(data.getOrDefault("precio", "0")),
                    data.getOrDefault("kilometros", "0 km"),
                    data.getOrDefault("velocidad", "0 km/h"),
                    Integer.parseInt(data.getOrDefault("caballos", "0")),
                    data.getOrDefault("tipo", "Desconocido"),
                    Integer.parseInt(data.getOrDefault("cilindrada", "0")));
        } catch (NumberFormatException e) {
            System.out.println("Error al crear Moto: " + e.getMessage());
            return null;
        }
    }

    
}
