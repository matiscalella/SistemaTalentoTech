package model;

/**
 * Clase que representa una bebida del sistema.
 * 
 * Hereda de Producto y agrega informacion especifica
 * relacionada al volumen y si contiene alcohol.
 */
public class Bebida extends Producto {

    private double litros;
    private boolean alcoholica;

    /**
     * Constructor vacio.
     */
    public Bebida() {
    }

    /**
     * Constructor con parametros.
     *
     * @param id identificador del producto
     * @param nombre nombre de la bebida
     * @param precio precio de la bebida
     * @param stock cantidad disponible en stock
     * @param litros volumen de la bebida en litros
     * @param alcoholica indica si la bebida contiene alcohol
     */
    public Bebida(Long id, String nombre, double precio, int stock,
                   double litros, boolean alcoholica) {

        super(id, nombre, precio, stock);

        this.litros = litros;
        this.alcoholica = alcoholica;
    }

    /**
     * Obtiene el volumen de la bebida.
     *
     * @return litros de la bebida
     */
    public double getLitros() {
        return litros;
    }

    /**
     * Modifica el volumen de la bebida.
     *
     * @param litros nuevo volumen en litros
     */
    public void setLitros(double litros) {
        this.litros = litros;
    }

    /**
     * Indica si la bebida es alcoholica.
     *
     * @return true si contiene alcohol, false en caso contrario
     */
    public boolean isAlcoholica() {
        return alcoholica;
    }

    /**
     * Modifica si la bebida contiene alcohol.
     *
     * @param alcoholica nuevo valor de alcoholica
     */
    public void setAlcoholica(boolean alcoholica) {
        this.alcoholica = alcoholica;
    }

    /**
     * Devuelve una representacion textual de la bebida.
     *
     * @return informacion completa de la bebida
     */
    @Override
    public String toString() {
        return "Bebida{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", stock=" + getStock() +
                ", litros=" + litros +
                ", alcoholica=" + alcoholica +
                '}';
    }
}