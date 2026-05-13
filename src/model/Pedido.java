package model;

import java.util.ArrayList;

/**
 * Clase que representa un pedido del sistema.
 * 
 * Un pedido contiene una lista de lineas de pedido y permite
 * calcular el total acumulado de todos los productos agregados.
 */
public class Pedido {

    private Long id;
    private ArrayList<LineaPedido> lineas;

    /**
     * Constructor vacio.
     * Inicializa la lista de lineas del pedido.
     */
    public Pedido() {
        lineas = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param id identificador del pedido
     */
    public Pedido(Long id) {
        this.id = id;
        this.lineas = new ArrayList<>();
    }

    /**
     * Obtiene el ID del pedido.
     *
     * @return ID del pedido
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica el ID del pedido.
     *
     * @param id nuevo ID del pedido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la lista de lineas del pedido.
     *
     * @return lista de lineas
     */
    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    /**
     * Modifica la lista de lineas del pedido.
     *
     * @param lineas nueva lista de lineas
     */
    public void setLineas(ArrayList<LineaPedido> lineas) {
        this.lineas = lineas;
    }

    /**
     * Agrega una linea al pedido.
     *
     * @param linea linea a agregar
     */
    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    /**
     * Calcula el total del pedido sumando los subtotales
     * de todas las lineas.
     *
     * @return total del pedido
     */
    public double calcularTotal() {

        double total = 0;

        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }

        return total;
    }

    /**
     * Devuelve una representacion textual del pedido.
     *
     * @return informacion completa del pedido
     */
    @Override
    public String toString() {

        String resultado = "Pedido #" + id + "\n";

        for (LineaPedido linea : lineas) {
            resultado += linea + "\n";
        }

        resultado += "TOTAL: $" + calcularTotal();

        return resultado;
    }
}