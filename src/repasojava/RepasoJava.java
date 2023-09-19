package repasojava;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class RepasoJava {

    public static Pizza crearPizza() {
        String cadena;
        double precio;
        int segundosHorno;
        boolean todoOK = false;

        precio = EntradaTeclado.pedirDouble("¿Cuánto cuesta la Pizza?");
        segundosHorno = EntradaTeclado.pedirEntero("¿Cuántos segundos estara en el horno?");
        do {
            cadena = EntradaTeclado.pedirCadena("Introduze el tipo de Pizza (Normal/Calzone)");
            if (cadena.equalsIgnoreCase("Normal")) {
                cadena = EntradaTeclado.pedirCadena("¿Los bordes rellenos de queso? (Si/No)");
                if (cadena.equals("Si")) {
                    return new Clasica(precio, segundosHorno, true);
                } else {
                    return new Clasica(precio, segundosHorno, false);
                }
            } else if (cadena.equalsIgnoreCase("Calzone")) {
                return new Calzones(precio, segundosHorno);
            }
        } while (!todoOK);
        return null;
    }

    public static int menu() {

        int opcion = 0;

        do {
            System.out.println(" -- MENU --");
            System.out.println("1. Insertar Pizza");
            System.out.println("2. Cantidad Porcentual de Pizzas clasicas con borde relleno de queso");
            System.out.println("3. Encender el horno");
            System.out.println("4. Salir");
            opcion = EntradaTeclado.pedirEntero("Introduzca una opcion: ");
        } while ((opcion < 1) || (opcion > 4));

        return opcion;
    }

    public static void main(String[] args) {
        int longitudCola;
        longitudCola = EntradaTeclado.pedirEntero("Introduzca el tamaño de la cola del horno.");

        Cola Horno1 = new Cola(longitudCola);

        int opcion = 0;

        do {
            opcion = menu();

            switch (opcion) {
                case 1 -> {
                    Pizza pizza = crearPizza();
                    if (Horno1.push(pizza)) {
                        System.out.println("Pizza introducida con exito");
                    } else {
                        System.out.println("No se ha podido introducir la pizza");
                    }
                }
                case 2 -> {
                    double porcentaje;
                    int numQueso = 0;
                    Pizza[] colaHorno = Horno1.copiaHorno();
                    for (int i = 0; i < colaHorno.length; i++) {
                        Pizza pizza = colaHorno[i];
                        if (pizza instanceof Clasica) {
                            boolean queso = ((Clasica) pizza).tieneQueso();
                            if (queso) {
                                numQueso++;
                            }
                        }
                    }
                    porcentaje = (100 * numQueso) / colaHorno.length;
                    System.out.println("El porcentaje de pizas con el borde de queso es el: " + porcentaje + "%");
                }
                case 3 -> {
                    Pizza[] colaHorno = Horno1.encenderHorno();
                    try {
                        for (Pizza pizza : colaHorno) {
                            System.out.println(pizza);
                            Thread.sleep((pizza.getSegundosHorno() * 1000));
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                case 4 -> {
                    System.out.println("Saliendo de la aplicacion");
                }
            }
        } while (opcion != 4);

    }

}
