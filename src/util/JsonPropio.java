package util;

import vehiculos.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
        if (!json.contains("[") || !json.contains("]"))
            return autos; // JSON mal formado

        //
        json = json.substring(json.indexOf("[") + 1, json.lastIndexOf("]")).trim();
        String[] autosData = json.split("},\\s*\\{"); // Separar cada auto

        for (String autoJson : autosData) {
            Map<String, String> autoMap = parseJson("{" + autoJson + "}");
            Auto auto = VehiculosFab.createAuto(autoMap);
            if (auto != null)
                autos.add(auto);
        }

        return autos;
    }

    // Método para leer motos desde JSON
    public static List<Moto> parseMotos(String json) {
        List<Moto> motos = new ArrayList<>();
        if (!json.contains("[") || !json.contains("]"))
            return motos;

        json = json.substring(json.indexOf("[") + 1, json.lastIndexOf("]")).trim();
        String[] motosData = json.split("},\\s*\\{");

        for (String motoJson : motosData) {
            Map<String, String> motoMap = parseJson("{" + motoJson + "}");
            Moto moto = VehiculosFab.createMoto(motoMap);
            if (moto != null)
                motos.add(moto);
        }

        return motos;
    }

    // Metodos para almacenar nuvos vehiculos en JSON

    public static void guardarAutos(List<Auto> autos, String filepath) {
        System.out.println(filepath);
        List<Auto> autosExistentes = new ArrayList<>();

        // leer autos existentes del JSON
        try {
            String jsonData = readJsonPropio(filepath);
            autosExistentes = parseAutos(jsonData);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        }

        // Agregar los nuevos autos solo si no existen
        for (Auto auto : autos) {
            if (!autosExistentes.contains(auto)) {
                autosExistentes.add(auto);
            }
        }

        //  Construir el JSON con StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        for (int i = 0; i < autosExistentes.size(); i++) {
            Auto auto = autosExistentes.get(i);
            sb.append("  {\n");
            sb.append("    \"marca\": \"").append(auto.getMarca()).append("\",\n");
            sb.append("    \"modelo\": \"").append(auto.getModelo()).append("\",\n");
            sb.append("    \"anio\": ").append(auto.getAño()).append(",\n");
            sb.append("    \"precio\": ").append(auto.getPrecio()).append(",\n");
            sb.append("    \"kilometraje\": \"").append(auto.getKilometros()).append("\",\n");
            sb.append("    \"puertas\": ").append(auto.getNumPuertas()).append(",\n");
            sb.append("    \"deportivo\": ").append(auto.isDeportivo()).append(",\n");
            sb.append("    \"velocidad\": \"").append(auto.getVelocidad()).append("\",\n");
            sb.append("    \"caballos\": ").append(auto.getCaballos()).append("\n");
            sb.append("  }");

            if (i < autosExistentes.size() - 1)
                sb.append(",\n"); // Agregar coma excepto en el último
            else
                sb.append("\n");
        }

        sb.append("]\n");

        // Guardar el JSON
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(sb.toString());
            System.out.println("Auto guardado en JSON correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar autos en JSON: " + e.getMessage());
        }
    }

    

}
