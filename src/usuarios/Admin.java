package usuarios;

import java.util.List;
import java.util.Scanner;

import vehiculos.*;

public class Admin extends Persona {

    private String user;
    private String contraseña;
    private Agenda agenda;

    public Admin(String nombre, int edad, String telefono, String user, String contraseña) {
        super(nombre, edad, telefono);
        this.user = user;
        this.contraseña = contraseña;
        this.agenda = new Agenda();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    /* METODOS PROPIOS DE AGENDA QUE SE MANEJAN DESDE ADMIN SIGUIENDO UNA LOGICA */
    // Agregar persona usando agenda desde Admin
    public void agregarPersona(Contacto contacto) {
        agenda.agregar(contacto);
    }

    public void eliminarPersona(String nombre) {
        agenda.eliminarPersona(buscarPorNombre(nombre));
    }

    public Contacto buscarPorNombre(String nombre) {
        return agenda.buscarPorNombre(nombre);
    }

    public Contacto buscarPorTelefono(String telefono) {
        return agenda.buscarPorTelefono(telefono);
    }

    public void listar() {
        agenda.mostrarUsuarios();
    }

    //Metodos para ingresar vehiculos

    //Metodo para ingresar un carro
    public void setAuto(Scanner sc){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        sc.nextLine();
        System.out.print("\nMarca: ");
        String marca=sc.nextLine();
        System.out.print("\nModelo: ");
        String modelo=sc.nextLine();
        System.out.print("\nAño: ");
        int año=sc.nextInt();
        System.out.print("\nPrecio por-dia: ");
        int precio=sc.nextInt();
        System.out.print("\nKilometraje: ");
        sc.nextLine();
        String kilometros=sc.nextLine();
        System.out.print("\nPuertas: ");
        int puertas=sc.nextInt();
        System.out.print("\nDeportivo?: ");
        boolean deportivo=sc.nextBoolean();
        System.out.print("\nVelocidad: ");
        sc.nextLine();
        String velocidad=sc.nextLine();
        System.out.print("\nCaballos de fuerza:");
        int caballos=sc.nextInt();

        Auto auto=new Auto(marca,modelo,año,precio,kilometros,puertas,deportivo,velocidad,caballos);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\nPresiona enter para continuar");;
        sc.nextLine();
        sc.nextLine();
        System.out.println(auto);
        System.out.println("\n\nPresiona enter para continuar");;
        sc.nextLine();
        sc.nextLine();
    }

    //Metodo para ingresar moto
    public void setMoto(){

    }
    // Metodos para mostrar vehiculos

    //Metodo para mostrar las motos disponibles
    public void getMotos(List<Moto> motos) {

        System.out.println("Listado de Motos Disponibles:");
        for (int i = 0; i < motos.size(); i++) {
            System.out.println("--------------------------------------------\n");
            System.out.print((i + 1) + ". " + motos.get(i));
            System.out.println("\n--------------------------------------------");

        }
    }

    //Metodo para mostrar los autos disponibles
    public void getAutos(List<Auto> autos) {
        System.out.println("Listado de Autos Disponibles:");
        for (int i = 0; i < autos.size(); i++) {
            System.out.println("--------------------------------------------\n");
            System.out.print((i + 1) + ". " + autos.get(i));
            System.out.println("\n--------------------------------------------");
        }
    }

    public void rentar(List<Auto> autos, List<Moto> motos) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("-----------------------------------------------------------");
        System.out.println("------            RENTA DE CARROS Y MOTOS            ------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("------         1. Carros           2. Motos           ------");
        System.out.println("-----------------------------------------------------------");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (opcion == 1) {
            getAutos(autos);
            System.out.print("Seleccione el número del auto a rentar: ");
            int seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion > 0 && seleccion <= autos.size()) {
                Auto autoSeleccionado = autos.get(seleccion - 1);
                System.out.println("\n");
                System.out.println("Has rentado el siguiente auto: " + autoSeleccionado);
                System.out.println("\n\n");
            } else {
                System.out.println("Selección inválida.");
            }

        } else if (opcion == 2) {
            getMotos(motos);

            System.out.print("Seleccione el número de la moto a rentar: ");
            int seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion > 0 && seleccion <= motos.size()) {
                Moto motoSeleccionada = motos.get(seleccion - 1);
                System.out.println("\n");
                System.out.println("Has rentado la siguiente moto: " + motoSeleccionada);
                System.out.println("\n\n");
            } else {
                System.out.println("Selección inválida.");
            }

        } else {
            System.out.println("Opción no válida.");
        }

    }
}
