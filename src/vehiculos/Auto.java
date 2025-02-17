package vehiculos;

public class Auto extends Vehiculo {
    
    private int numPuertas;
    private boolean deportivo;
   
    public Auto(String marca, String modelo, int año, int precio,int kilometros, int numPuertas, boolean deportivo,String velocidad,int caballos) {
        super(marca, modelo, año, precio,kilometros,velocidad,caballos);
        this.numPuertas = numPuertas;
        this.deportivo = deportivo;
        
    }
   
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    public boolean isDeportivo() {
        return deportivo;
    }
    public void setDeportivo(boolean deportivo) {
        this.deportivo = deportivo;
    }


    @Override
    public void arrancar(){
        if (deportivo) {
            System.out.println("Acelerando 5-100 en 6 segundos................");
        }else{
            System.out.println("Acelerando.................");
        }
    }

    @Override
    public void frenar(){
        System.out.println("Frenando............");
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de puertas: " + numPuertas + "\nDeportivo: " + (deportivo ? "Sí" : "No");
    }

    
}
