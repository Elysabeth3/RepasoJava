package repasojava;

public abstract class Pizza {
    private int id;
    private static int idPosible = 0;
    private double precio;
    private int segundosHorno;
    
    public Pizza(double precio, int segundosHorno) {
        id = idPosible++;
        this.precio = precio;
        this.segundosHorno = segundosHorno;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSegundosHorno() {
        return segundosHorno;
    }

    public void setSegundosHorno(int segundosHorno) {
        this.segundosHorno = segundosHorno;
    }

    @Override
    public String toString() {
        String cadena = "La Pizza " + getClass().getSimpleName();
        cadena += " tiene el codigo: " + this.id + " El precio es de: " + this.precio +" Euros y tardara en el Horno unos: " + this.segundosHorno +" segundos";
        return cadena;
    }
    
    
}
