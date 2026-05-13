package model;

/**
 * Clase que representa una linea dentro de un pedido.
 * 
 * Cada linea contiene un producto, una cantidad y permite
 * calcular el subtotal correspondiente.
 */
public class LineaPedido {

    private Producto producto;
    private int cantidad;

    /**
     * Constructor vacio.
     */
    public LineaPedido() {
    }

    /**
     * Constructor con parametros.
     *
     * @param producto producto asociado a la linea
     * @param cantidad cantidad solicitada del producto
     */
    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el producto asociado a la linea.
     *
     * @return producto de la linea
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Modifica el producto asociado a la linea.
     *
     * @param producto nuevo producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la cantidad solicitada del producto.
     *
     * @return cantidad del producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Modifica la cantidad solicitada del producto.
     *
     * @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal de la linea del pedido.
     *
     * @return subtotal calculado en base al precio y cantidad
     */
    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    /**
     * Devuelve una representacion textual de la linea del pedido.
     *
     * @return informacion completa de la linea
     */
    @Override
    public String toString() {
        return "LineaPedido{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", subtotal=" + calcularSubtotal() +
                '}';
    }
}