package service;

import java.util.ArrayList;
import model.Producto;

/**
 * Clase de servicio encargada de gestionar los productos del sistema.
 * 
 * Permite agregar, buscar, actualizar, eliminar y validar productos.
 */
public class ProductoService {

    private ArrayList<Producto> productos;

    /**
     * Constructor del servicio de productos.
     * Inicializa la lista de productos.
     */
    public ProductoService() {
        productos = new ArrayList<>();
    }

    /**
     * Agrega un producto a la lista si los datos son validos.
     *
     * @param producto producto a agregar
     * @return true si el producto fue agregado correctamente,
     * false en caso contrario
     */
    public boolean agregarProducto(Producto producto) {

        String error = validarDatosProducto(producto);

        if (error != null) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    /**
     * Lista todos los productos registrados en el sistema.
     * Si no existen productos, muestra un mensaje informativo.
     */
    public void listarProductos() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    /**
     * Busca un producto por su ID.
     *
     * @param id identificador del producto
     * @return producto encontrado o null si no existe
     */
    public Producto buscarPorId(Long id) {

        for (Producto producto : productos) {

            if (producto.getId().equals(id)) {
                return producto;
            }
        }

        return null;
    }

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param id ID del producto a actualizar
     * @param nuevoNombre nuevo nombre del producto
     * @param nuevoPrecio nuevo precio del producto
     * @param nuevoStock nuevo stock del producto
     * @return true si el producto fue actualizado correctamente,
     * false en caso contrario
     */
    public boolean actualizarProducto(Long id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {

        Producto producto = buscarPorId(id);

        if (producto == null) {
            return false;
        }

        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            return false;
        }

        if (nuevoPrecio <= 0) {
            return false;
        }

        if (nuevoStock < 0) {
            return false;
        }

        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setStock(nuevoStock);

        return true;
    }

    /**
     * Elimina un producto de la lista a partir de su ID.
     *
     * @param id ID del producto a eliminar
     * @return true si el producto fue eliminado,
     * false si no fue encontrado
     */
    public boolean eliminarProducto(Long id) {

        Producto producto = buscarPorId(id);

        if (producto != null) {
            productos.remove(producto);
            return true;
        }

        return false;
    }

    /**
     * Valida internamente un producto.
     *
     * @param producto producto a validar
     * @return true si los datos son validos,
     * false en caso contrario
     */
    private boolean validarProducto(Producto producto) {

        if (producto == null) {
            return false;
        }

        if (producto.getId() == null || producto.getId() <= 0) {
            return false;
        }

        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            return false;
        }

        if (producto.getPrecio() <= 0) {
            return false;
        }

        if (producto.getStock() < 0) {
            return false;
        }

        return true;
    }

    /**
     * Valida los datos de un producto y devuelve mensajes descriptivos
     * en caso de error.
     *
     * @param producto producto a validar
     * @return mensaje de error o null si el producto es valido
     */
    public String validarDatosProducto(Producto producto) {

        if (producto == null) {
            return "El producto es nulo.";
        }

        if (producto.getId() == null || producto.getId() <= 0) {
            return "El ID debe ser mayor a cero.";
        }

        if (buscarPorId(producto.getId()) != null) {
            return "Ya existe un producto con ese ID.";
        }

        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            return "El nombre no puede estar vacio.";
        }

        if (producto.getPrecio() <= 0) {
            return "El precio debe ser mayor a cero.";
        }

        if (producto.getStock() < 0) {
            return "El stock no puede ser negativo.";
        }

        return null;
    }
}