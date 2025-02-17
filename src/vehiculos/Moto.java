package vehiculos;

public class Moto extends Vehiculo {

    protected String tipo;
    protected int cilindrada;

    public Moto(String marca, String modelo, int año, int precio, int kilometros, String velocidad, int caballos,String tipo, int cilindrada) {
        super(marca, modelo, año, precio, kilometros, velocidad, caballos);
        this.tipo = tipo;
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        try {
            if (cilindrada <= 0) {
                throw new IllegalArgumentException("La cilindrada debe ser mayor a 0");
            }
            this.cilindrada = cilindrada;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Dejo la cilindrada por default en 125cc
            this.cilindrada = 125;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void arrancar() {
        try {
            if (cilindrada > 125 && cilindrada < 500) {
                System.out.println("Moto acelerando de forma normal... 🏍");
            } else if (cilindrada >= 1000) {
                System.out.println("Moto acelerando como un cohete 🚀");
            } else if (cilindrada <= 0) {
                throw new IllegalStateException("La cilindrada no puede ser 0 o negativa");
            } else {
                System.out.println("Moto arrancando suavemente...");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error al arrancar: " + e.getMessage());
        }
    }

    @Override
    public void frenar() {
        try {
            if (tipo == null) {
                throw new NullPointerException("El tipo de moto no puede ser null");
            }

            if ("deportiva".equalsIgnoreCase(tipo)) {
                System.out.println("Tu moto tiene ABS, frenarás rápido y sin perder el control. 👍");
            } else {
                System.out.println("Frenando moto de manera normal...");
            }
        } catch (NullPointerException e) {
            System.out.println("Error al frenar: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo: " + tipo + "\nCilindrada: " + cilindrada + " cc";
    }
}