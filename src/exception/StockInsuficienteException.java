package exception;

/**
 * Excepcion personalizada que se lanza cuando no hay stock suficiente
 * para agregar un producto a un pedido.
 */
public class StockInsuficienteException extends Exception {

    /**
     * Constructor de la excepcion.
     *
     * @param mensaje mensaje descriptivo del error
     */
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}