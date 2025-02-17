import util.JsonPropio;
import vehiculos.Auto;
import vehiculos.Moto;
import usuarios.Contacto;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contacto usuario = null;

        try {
            // Cargar datos de autos y motos desde JSON
            String jsonAutos = JsonPropio.readJsonPropio("data/autos.json");
            String jsonMotos = JsonPropio.readJsonPropio("data/motos.json");
            List<Auto> autos = JsonPropio.parseAutos(jsonAutos);
            List<Moto> motos = JsonPropio.parseMotos(jsonMotos);

            do {
                System.out.println("--------------------  OPCIONES CONCESIONARIA  --------------------");
                System.out.println("------          1. Ingresar/Admin    2. Rentar               ------");
                System.out.println("------------------------------------------------------------------");
                System.out.print("------  R: ");

                int opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                if (opcion == 1) {
                    System.out.println("Funcionalidad de administración en desarrollo...");

                } else if (opcion == 2) {
                    if (usuario == null) {
                        System.out.println("\nPara rentar un vehículo, primero debes registrarte.");
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = sc.nextLine();

                        if (edad < 18) {
                            System.out.println("Debes ser mayor de edad para rentar.");
                            continue;
                        }

                        usuario = new Contacto(nombre, edad, telefono, false);
                        System.out.println("Registro exitoso.");
                    }

                    // Llamamos a rentar desde Contacto
                    usuario.rentar(autos, motos);

                } else {
                    System.out.println("ERROR: SELECCIONA UNA OPCIÓN VÁLIDA");
                }

            } while (true);

        } catch (IOException e) {
            System.err.println("Error al leer los archivos JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
