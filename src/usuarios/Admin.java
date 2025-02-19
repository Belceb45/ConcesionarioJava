package usuarios;

import java.util.List;
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

    public void listar(){
        agenda.mostrarUsuarios();
    }

    public void getMotos(List<Moto> motos){

        System.out.println("Listado de Motos Disponibles:");
            for (int i = 0; i < motos.size(); i++) {
                System.out.println("--------------------------------------------\n");
                System.out.print((i + 1) + ". " + motos.get(i));
                System.out.println("\n--------------------------------------------");

            }
    }

    public void getAutos(List<Auto> autos) {
        System.out.println("Listado de Autos Disponibles:");
        for (int i = 0; i < autos.size(); i++) {
            System.out.println("--------------------------------------------\n");
            System.out.print((i + 1) + ". " + autos.get(i));
            System.out.println("\n--------------------------------------------");
        }
    }
}
