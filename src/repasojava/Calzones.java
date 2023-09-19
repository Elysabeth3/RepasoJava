package repasojava;

public class Calzones extends Pizza {
    private static final double porcentajeExtra = 0.05;
    
    public Calzones(double precio, int segundosHorno){
        super(precio+(precio*porcentajeExtra), segundosHorno);
    }
    
}
