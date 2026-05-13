package main;

/**
 * Clase principal del sistema.
 * Contiene el metodo main que inicia la ejecucion del programa.
 */
public class Main {

    /**
     * Metodo principal que inicia el menu interactivo del sistema.
     *
     * @param args argumentos de linea de comandos
     */
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.iniciar();
    }
}