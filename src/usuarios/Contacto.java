package usuarios;

import vehiculos.Auto;
import vehiculos.Moto;
import java.util.List;
import java.util.Scanner;

public class Contacto extends Persona {

    private boolean concurrente;

    public Contacto(String nombre, int edad, String telefono, boolean concurrente) {
        super(nombre, edad, telefono);
        this.concurrente = concurrente;
    }

    public boolean isConcurrente() {
        return concurrente;
    }

    public void setConcurrente(boolean concurrente) {
        this.concurrente = concurrente;
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
            System.out.println("Listado de Autos Disponibles:");
            for (int i = 0; i < autos.size(); i++) {
                System.out.println("--------------------------------------------\n");
                System.out.print((i + 1) + ". " + autos.get(i));
                System.out.println("\n--------------------------------------------");
            }

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
            System.out.println("Listado de Motos Disponibles:");
            for (int i = 0; i < motos.size(); i++) {
                System.out.println("--------------------------------------------\n");
                System.out.print((i + 1) + ". " + motos.get(i));
                System.out.println("\n--------------------------------------------");

            }

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

    @Override
    public String toString() {
        return super.toString() + "\nConcurrente: " + concurrente;
    }
}
