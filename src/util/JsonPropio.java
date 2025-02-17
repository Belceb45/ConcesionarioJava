package util;
import vehiculos.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JsonPropio {

    // Método para leer el archivo JSON y devolverlo como un String
    public static String readJsonPropio(String filepath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    // Método para convertir un JSON en un mapa clave-valor
    public static Map<String, String> parseJson(String json) {
        Map<String, String> map = new HashMap<>();

        // Limpiamos el JSON (quitamos llaves y saltos de línea)
        json = json.replaceAll("[{}\"]", "").trim();
        String[] pairs = json.split(",");

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                map.put(key, value);
            }
        }
        return map;
    }

    // Método para leer autos desde JSON
    public static List<Auto> parseAutos(String json) {
        List<Auto> autos = new ArrayList<>();
        if (!json.contains("[") || !json.contains("]")) return autos; // JSON mal formado

        json = json.substring(json.indexOf("[") + 1, json.lastIndexOf("]")).trim();
        String[] autosData = json.split("},\\s*\\{"); // Separar cada auto

        for (String autoJson : autosData) {
            Map<String, String> autoMap = parseJson("{" + autoJson + "}");
            Auto auto = VehiculosFab.createAuto(autoMap);
            if (auto != null) autos.add(auto);
        }

        return autos;
    }

    // Método para leer motos desde JSON
    public static List<Moto> parseMotos(String json) {
        List<Moto> motos = new ArrayList<>();
        if (!json.contains("[") || !json.contains("]")) return motos;

        json = json.substring(json.indexOf("[") + 1, json.lastIndexOf("]")).trim();
        String[] motosData = json.split("},\\s*\\{");

        for (String motoJson : motosData) {
            Map<String, String> motoMap = parseJson("{" + motoJson + "}");
            Moto moto = VehiculosFab.createMoto(motoMap);
            if (moto != null) motos.add(moto);
        }

        return motos;
    }
}
