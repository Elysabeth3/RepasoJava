package repasojava;

public interface AccionesEstructura <T> {
    public boolean push (T elemento);
    public T pop();
    public boolean esVacia();
    public int getNumElementos();
}
