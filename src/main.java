import util.JsonPropio;
import vehiculos.Auto;
import vehiculos.Moto;
import usuarios.Contacto;
import usuarios.Admin;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Diego Rubio Haro", 21, "5616936324", "admin", "admin2908");

        try {
            // Cargar datos de autos y motos desde JSON
            String jsonAutos = JsonPropio.readJsonPropio("data/autos.json");
            String jsonMotos = JsonPropio.readJsonPropio("data/motos.json");
            List<Auto> autos = JsonPropio.parseAutos(jsonAutos);
            List<Moto> motos = JsonPropio.parseMotos(jsonMotos);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            while (true) {
                System.out.println("--------------------  OPCIONES CONCESIONARIA  --------------------");
                System.out.println("------     1. Ingresar/Admin    2. Rentar    3. Salir       ------");
                System.out.println("------------------------------------------------------------------");
                System.out.print("------  R: ");

                int opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                System.out.print("\033[H\033[2J");
                System.out.flush();

                if (opcion == 1) {

                    System.out.println("--------------------  OPCIONES ADMINISTRADOR  -----------------------------");
                    System.out.println("------                                                              -------");
                    System.out.println("------  1. Agregar Cliente   2. Eliminar Cliente   3. Ver clientes  -------");
                    System.out.println("------                    4. Autos   5. Carros                      -------");
                    System.out.println("------                                                              -------");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.print("------  R: ");
                    int opcion2 = sc.nextInt();

                    switch (opcion2) {
                        case 1:

                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;

                        default:
                            break;
                    }

                } else if (opcion == 2) {
                    System.out.println("\nPara rentar un vehículo, primero debes registrarte.");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");

                    int edad;
                    while (true) {
                        if (sc.hasNextInt()) {
                            edad = sc.nextInt();
                            sc.nextLine();
                            if (edad >= 18)
                                break;
                            System.out.println("Debes ser mayor de edad para rentar. Inténtalo de nuevo.");
                        } else {
                            System.out.println("Por favor, ingresa un número válido para la edad.");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    Contacto cliente = new Contacto(nombre, edad, telefono, false);
                    admin.agregarPersona(cliente);
                    System.out.println(cliente);

                    // Llamamos a rentar desde Contacto
                    cliente.rentar(autos, motos);

                } else if (opcion == 3) {
                    System.out.println("Saliendo del sistema...");
                    break; //
                } else {
                    System.out.println("ERROR: SELECCIONA UNA OPCIÓN VÁLIDA");
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer los archivos JSON: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
