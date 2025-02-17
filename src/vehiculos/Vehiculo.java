package vehiculos;

//Clase generica abstracta
public abstract class Vehiculo {

    // Atributos
  
    protected String marca;
    protected String modelo;
    protected String velocidad;
    protected String kilometros;
    protected int precio;
    protected int año;
    protected int caballos;

    // Constructor
    public Vehiculo(String marca, String modelo, int año, int precio, String kilometros, String velocidad,int caballos) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.kilometros = kilometros;
        this.velocidad = velocidad;
        this.caballos = caballos;
    }

    // Metodos Getters y Setters
   
    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    // Metodos abstractos
    public abstract void arrancar();

    public abstract void frenar();

    @Override
    public String toString() {
        return "Modelo: " + modelo + "\nMarca: " + marca + "\nAño: " + año + "\nVelocidad: " + velocidad
                + "\nPrecio c/dia: $" + precio + "\nKilometros: " + kilometros + "\nCaballos de fuerza: " + caballos;
    }
}
