package repasojava;

public class Cola implements AccionesEstructura<Pizza> {

    private Pizza[] hornoPizzas;

    public Cola(int longitud) {
        this.hornoPizzas = new Pizza[longitud];
    }

    @Override
    public boolean push(Pizza elemento) {
        int numElementos = getNumElementos();
        if (numElementos < hornoPizzas.length - 1) {
            if (numElementos == 0) {
                hornoPizzas[0] = elemento;
                return true;
            } else {
                hornoPizzas[numElementos] = elemento;
                return true;
            }
        }
        return false;
    }

    @Override
    public Pizza pop() {
        if (esVacia()) {
            Pizza devolver = hornoPizzas[0];
            ordenar();
            return devolver;
        }
        return null;
    }

    @Override
    public boolean esVacia() {
        return getNumElementos() != 0;
    }

    @Override
    public int getNumElementos() {
        int numElementos = 0;
        for (int i = 0; i < hornoPizzas.length; i++) {
            Pizza hornoPizza = hornoPizzas[i];
            if (hornoPizza != null) {
                numElementos++;
            }
        }
        return numElementos;
    }

    private void ordenar() {
        for (int i = 0; i < (getNumElementos()); i++) {
            int j = i + 1;
            hornoPizzas[i] = hornoPizzas[j];
        }
    }

}
