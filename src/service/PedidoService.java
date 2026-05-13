package service;

import exception.StockInsuficienteException;
import java.util.ArrayList;
import model.LineaPedido;
import model.Pedido;
import model.Producto;

/**
 * Clase de servicio encargada de gestionar los pedidos del sistema.
 * 
 * Permite agregar productos a un pedido, validar stock disponible,
 * descontar stock y listar los pedidos registrados.
 */
public class PedidoService {

    private ArrayList<Pedido> pedidos;

    /**
     * Constructor del servicio de pedidos.
     * Inicializa la lista de pedidos.
     */
    public PedidoService() {
        pedidos = new ArrayList<>();
    }

    /**
     * Agrega una linea a un pedido, validando previamente la cantidad
     * solicitada y el stock disponible del producto.
     * 
     * Si la operacion es valida, se agrega la linea al pedido y se descuenta
     * la cantidad correspondiente del stock del producto.
     *
     * @param pedido pedido al que se agregara la linea
     * @param producto producto que se desea agregar al pedido
     * @param cantidad cantidad solicitada del producto
     * @throws StockInsuficienteException si el producto no tiene stock suficiente
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero
     */
    public void agregarLineaAlPedido(Pedido pedido, Producto producto, int cantidad)
            throws StockInsuficienteException {

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }

        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException(
                    "Stock insuficiente para el producto: " + producto.getNombre()
            );
        }

        LineaPedido linea = new LineaPedido(producto, cantidad);
        pedido.agregarLinea(linea);

        producto.setStock(producto.getStock() - cantidad);
    }

    /**
     * Guarda un pedido en la lista de pedidos registrados.
     *
     * @param pedido pedido a guardar
     */
    public void guardarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido guardado correctamente.");
    }

    /**
     * Lista todos los pedidos registrados en el sistema.
     * Si no existen pedidos, muestra un mensaje informativo.
     */
    public void listarPedidos() {

        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos cargados.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            System.out.println("--------------------");
        }
    }
}