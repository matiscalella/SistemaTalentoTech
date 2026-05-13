package model;

/**
 * Clase que representa una comida del sistema.
 * 
 * Hereda de Producto y agrega informacion especifica
 * relacionada a las calorias y si es vegetariana.
 */
public class Comida extends Producto {

    private int calorias;
    private boolean vegetariana;

    /**
     * Constructor vacio.
     */
    public Comida() {
    }

    /**
     * Constructor con parametros.
     *
     * @param id identificador del producto
     * @param nombre nombre de la comida
     * @param precio precio de la comida
     * @param stock cantidad disponible en stock
     * @param calorias cantidad de calorias
     * @param vegetariana indica si la comida es vegetariana
     */
    public Comida(Long id, String nombre, double precio, int stock,
                   int calorias, boolean vegetariana) {

        super(id, nombre, precio, stock);

        this.calorias = calorias;
        this.vegetariana = vegetariana;
    }

    /**
     * Obtiene la cantidad de calorias.
     *
     * @return calorias de la comida
     */
    public int getCalorias() {
        return calorias;
    }

    /**
     * Modifica la cantidad de calorias.
     *
     * @param calorias nueva cantidad de calorias
     */
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    /**
     * Indica si la comida es vegetariana.
     *
     * @return true si es vegetariana, false en caso contrario
     */
    public boolean isVegetariana() {
        return vegetariana;
    }

    /**
     * Modifica si la comida es vegetariana.
     *
     * @param vegetariana nuevo valor de vegetariana
     */
    public void setVegetariana(boolean vegetariana) {
        this.vegetariana = vegetariana;
    }

    /**
     * Devuelve una representacion textual de la comida.
     *
     * @return informacion completa de la comida
     */
    @Override
    public String toString() {
        return "Comida{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", stock=" + getStock() +
                ", calorias=" + calorias +
                ", vegetariana=" + vegetariana +
                '}';
    }
}