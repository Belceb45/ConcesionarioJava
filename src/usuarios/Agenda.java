package usuarios;

import java.util.List;
import java.util.Map;

import util.JsonPropio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new LinkedList<>();
        cargarContactosDesdeJson();
    }

    public List<Contacto> getContactos() {
        return contactos; 
    }

    public void agregar(Contacto contacto) {
        contactos.add(contacto);
        guardarJSON();
    }

    public void eliminarPersona(Contacto contacto) {
        if (contactos.remove(contacto)) {
            guardarJSON(); // Guardar cambios en el archivo JSON
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("El contacto no existe.");
        }
    }
    

    public Contacto buscarPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; // Retorna null si no encuentra el contacto
    }

    public Contacto buscarPorTelefono(String telefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getTelefono().equals(telefono)) {
                return contacto;
            }
        }
        return null;
    }

    public void mostrarUsuarios() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        
        System.out.println("Lista de usuarios registrados:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

      private void guardarJSON() {
        String rutaArchivo = "data/contactos.json";

        // Construir el JSON manualmente
        // Alternativa a la concatenacion con +
        StringBuilder json = new StringBuilder("[\n");
        
        // Iterar sobre la lista de contactos
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            //Vamos construyendo el JSON insertando manualmente sus simbolos y datos del contacto
            json.append("  {\n")
                .append("    \"nombre\": \"").append(c.getNombre()).append("\",\n")
                .append("    \"edad\": ").append(c.getEdad()).append(",\n")
                .append("    \"telefono\": \"").append(c.getTelefono()).append("\"\n")
                .append("  }");
            if (i < contactos.size() - 1) json.append(",\n"); // Agregar coma excepto en el último
        }

        json.append("\n]");//Ultimo salto para cerrar 

        // Pasamos el StringBuilder a fileWriter.write para escribir en el archivo
        try (FileWriter fileWriter = new FileWriter(rutaArchivo)) {
            fileWriter.write(json.toString());
            System.out.println("Contactos guardados en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar contactos en JSON: " + e.getMessage());
        }
    }

    private void cargarContactosDesdeJson() {
        String rutaArchivo = "data/contactos.json";
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) return; // Si no existe, no hay nada que cargar

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            StringBuilder json = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                json.append(linea);
            }

            // Eliminar corchetes y dividir por objetos individuales
            String contenido = json.toString().trim();
            if (contenido.length() <= 2) return; // Archivo vacío

            contenido = contenido.substring(1, contenido.length() - 1); // Quitar '[' y ']'
            String[] contactosJson = contenido.split("},\\s*\\{");

            for (String contactoJson : contactosJson) {
                Map<String, String> datos = JsonPropio.parseJson("{" + contactoJson + "}");
                Contacto contacto = new Contacto(
                    datos.get("nombre"),
                    Integer.parseInt(datos.get("edad")),
                    datos.get("telefono"),
                    Boolean.parseBoolean(datos.get("esAdmin"))
                );
                contactos.add(contacto);
            }
            System.out.println("Contactos cargados correctamente desde JSON.");
        } catch (IOException e) {
            System.err.println("Error al cargar contactos desde JSON: " + e.getMessage());
        }
    }

}

