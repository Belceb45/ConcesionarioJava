package usuarios;


public class Persona {
    private String nombre;
    private int edad;
    private String telefono;
    
    public Persona(String nombre, int edad, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }   
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "----------\nUser: \n"+nombre + "\n" + edad + "\n" + telefono;
    }
}
