package repasojava;

public class Clasica extends Pizza {
    private boolean queso;
    
    public Clasica(double precio, int segundosHorno, boolean queso){
        super(precio, segundosHorno);
        this.queso = queso;
    }

    public boolean tieneQueso() {
        return queso;
    }

    @Override
    public String toString() {
        String cadena = super.toString();
        if (queso) {
            cadena += " LLeva queso";
        } else {
            cadena += " No lleva queso";
        }
        return cadena;
    }
    
}
