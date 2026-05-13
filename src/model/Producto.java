package model;

/**
 * Clase que representa un producto del sistema.
 * 
 * Contiene informacion basica como ID, nombre, precio y stock.
 * Esta clase funciona como base para otros tipos de productos,
 * como Bebida y Comida.
 */
public class Producto {

    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor vacio.
     */
    public Producto() {
    }

    /**
     * Constructor con parametros.
     *
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param stock cantidad disponible en stock
     */
    public Producto(Long id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return ID del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica el ID del producto.
     *
     * @param id nuevo ID del producto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del producto.
     *
     * @param nombre nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Modifica el precio del producto.
     *
     * @param precio nuevo precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el stock disponible del producto.
     *
     * @return stock disponible
     */
    public int getStock() {
        return stock;
    }

    /**
     * Modifica el stock del producto.
     *
     * @param stock nuevo stock disponible
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representacion textual del producto.
     *
     * @return informacion completa del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}