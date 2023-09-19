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

    public Pizza[] copiaHorno() {
        Pizza[] copia = new Pizza[getNumElementos()];
        for (int i = 0; i < copia.length; i++) {
            copia[i] = hornoPizzas[i];
        }
        return copia;
    }

    public Pizza[] encenderHorno() {
        Cola auxClasica = new Cola(getNumElementos());
        Cola auxCalzone = new Cola(getNumElementos());

        for (int i = 0; i < getNumElementos(); i++) {
            Pizza hornoPizza = hornoPizzas[i];
            if (hornoPizza instanceof Clasica) {
                Pizza insertar = pop();
                auxClasica.push(insertar);
                i--;
            } else if (hornoPizza instanceof Calzones) {
                Pizza insertar = pop();
                auxCalzone.push(insertar);
                i--;
            }

        }
        Pizza[] aux = auxCalzone.copiaHorno();
        for (int i = 0; i < aux.length; i++) {
            hornoPizzas[i] = aux[i];
        }
        aux = auxClasica.copiaHorno();
        int posicionMin = getNumElementos();
        for (int i = 0; i < aux.length; i++) {
            hornoPizzas[posicionMin] = aux[i];
            posicionMin++;
        }
        Pizza devolverPizza[] = copiaHorno();
        for (int i = 0; i < hornoPizzas.length; i++) {
            hornoPizzas[i] = null;
        }
        return devolverPizza;
    }
}
