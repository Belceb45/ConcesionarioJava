package usuarios;

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

    

    @Override
    public String toString() {
        return super.toString() + "\nConcurrente: " + concurrente;
    }
}
