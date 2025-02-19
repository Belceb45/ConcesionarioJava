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
        // Admin por default no guardados en JSON
        int opcion;
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Diego Rubio Haro", 21, "5616936324", "admin", "admin2908");

        try {
            // Cargar datos de autos y motos desde JSON
            String jsonAutos = JsonPropio.readJsonPropio("data/autos.json");
            String jsonMotos = JsonPropio.readJsonPropio("data/motos.json");
            List<Auto> autos = JsonPropio.parseAutos(jsonAutos);
            List<Moto> motos = JsonPropio.parseMotos(jsonMotos);
            while (true) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                // MENUS DE OPCIONES
                System.out.println("--------------------  OPCIONES CONCESIONARIA  --------------------");
                System.out.println("------     1. Ingresar/Admin    2. Rentar    3. Salir       ------");
                System.out.println("------------------------------------------------------------------");
                System.out.print("------  R: ");

                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                System.out.print("\033[H\033[2J");
                System.out.flush();

                if (opcion == 1) {

                    boolean otp = true;
                    while (otp) {
                        System.out
                                .println("--------------------  OPCIONES ADMINISTRADOR  -----------------------------");
                        System.out
                                .println("------                                                              -------");
                        System.out
                                .println("------  1. Agregar Cliente   2. Eliminar Cliente   3. Ver clientes  -------");
                        System.out
                                .println("------                    4. Autos   5. Carros   6. Salir           -------");
                        System.out
                                .println("------                                                              -------");
                        System.out
                                .println("---------------------------------------------------------------------------");
                        System.out.print("------  R: ");
                        int opcion2 = sc.nextInt();

                        switch (opcion2) {
                            case 1:
                                sc.nextLine(); // Limpiar buffer
                                System.out.print("Nombre: ");
                                String nombre = sc.nextLine();
                                // Uso equalsIgnoreCase(); para comparar sin importar min/mayusc
                                Contacto contactoExistente = admin.buscarPorNombre(nombre);

                                // Valido si el contacto existe antes de acceder a sus atributos)
                                // trim para eliminar los espacios
                                if (contactoExistente != null
                                        && nombre.trim().equalsIgnoreCase(contactoExistente.getNombre().trim())) {
                                    System.out.println("\nERROR, YA SE HA REGISTRADO");
                                    break;
                                }
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
                                System.out.println("\nYa ha comprado?: ");
                                boolean condicion = sc.nextBoolean();
                                Contacto cliente = new Contacto(nombre, edad, telefono, condicion);
                                admin.agregarPersona(cliente);
                                System.out.println(cliente);
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                sc.nextLine(); // Limpiar buffer
                                System.out.print("Nombre: ");
                                String nom = sc.nextLine();
                                admin.eliminarPersona(nom);
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                admin.listar();
                                System.out.println("\n\nPresiona Enter para continuar.............");
                                sc.nextLine();
                                sc.nextLine();
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("--------------------  OPCIONES AUTOS  --------------------");
                                System.out.println("--- 1. Agregar    2. Eliminar    3. Listar  4. Salir  ----");
                                System.out.println("----------------------------------------------------------");
                                System.out.print("------  R: ");
                                
                                opcion = sc.nextInt();
                                switch (opcion) {
                                    case 1:
                                        admin.setAuto(sc);    
                                        break;
                                    case 2:

                                        break;
                                    case 3:

                                        break;

                                    default:
                                        break;
                                }
                            case 5:
                                break;

                            case 6:
                                otp = false;

                            default:
                                break;
                        }
                    }

                } else if (opcion == 2) {

                    try {
                        System.out.println("\nPara rentar un vehículo, primero debes registrarte.");
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        Contacto contactoExistente = admin.buscarPorNombre(nombre);

                        // Valido si el contacto existe antes de acceder a sus atributos)
                        if (contactoExistente != null
                                && nombre.trim().equalsIgnoreCase(contactoExistente.getNombre().trim())) {
                            System.out.println("\nYA ESTAS REGISTRADO, BIEN!");
                            System.out.println("\n\nPresiona enter para continuar.... ");
                            sc.nextLine();
                            // sc.nextLine();
                            admin.rentar(autos, motos);
                            System.out.println("\nPresiona enter para continuar");
                            sc.nextLine();
                        } else {

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
                            admin.rentar(autos, motos);
                            System.out.println("\nPresiona enter para continuar");
                            sc.nextLine();
                            // sc.nextLine();
                        }

                    } catch (NullPointerException in) {
                        System.out.println("ERROR");
                    }

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
