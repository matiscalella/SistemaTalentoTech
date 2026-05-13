package main;

import java.util.Scanner;
import model.Producto;
import service.ProductoService;
import exception.StockInsuficienteException;
import model.Pedido;
import service.PedidoService;

/**
 * Clase encargada de manejar el menu interactivo del sistema.
 * 
 * Permite al usuario gestionar productos y pedidos desde la consola.
 */
public class Menu {

    private Scanner scanner;
    private ProductoService productoService;
    private PedidoService pedidoService;
    private Long contadorPedidos;

    /**
     * Constructor del menu.
     * Inicializa el scanner, los servicios y el contador de pedidos.
     */
    public Menu() {
        scanner = new Scanner(System.in);
        productoService = new ProductoService();
        pedidoService = new PedidoService();
        contadorPedidos = 1L;
    }

    /**
     * Inicia el menu principal del sistema.
     * Muestra las opciones disponibles y ejecuta la accion seleccionada.
     */
    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Crear pedido");
            System.out.println("7. Listar pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    productoService.listarProductos();
                    break;
                case 3:
                    buscarProductoPorId();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    crearPedido();
                    break;
                case 7:
                    pedidoService.listarPedidos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 0);
    }

    /**
     * Solicita los datos de un producto, valida la informacion ingresada
     * y lo agrega al sistema si los datos son correctos.
     */
    private void agregarProducto() {

        System.out.print("Ingrese ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(id, nombre, precio, stock);

        String error = productoService.validarDatosProducto(producto);

        if (error != null) {
            System.out.println("ERROR: " + error);
            return;
        }

        boolean agregado = productoService.agregarProducto(producto);

        if (agregado) {
            System.out.println("Producto agregado correctamente.");
        }
    }

    /**
     * Busca un producto por su ID y muestra el resultado por consola.
     */
    private void buscarProductoPorId() {

        System.out.print("Ingrese ID del producto: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Producto producto = productoService.buscarPorId(id);

        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Solicita los nuevos datos de un producto existente y actualiza
     * su informacion si el producto fue encontrado.
     */
    private void actualizarProducto() {

        System.out.print("Ingrese ID del producto a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Ingrese nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese nuevo precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese nuevo stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        boolean actualizado = productoService.actualizarProducto(id, nombre, precio, stock);

        if (actualizado) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("Producto no encontrado o datos invalidos.");
        }
    }

    /**
     * Elimina un producto del sistema a partir de su ID.
     */
    private void eliminarProducto() {

        System.out.print("Ingrese ID del producto a eliminar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean eliminado = productoService.eliminarProducto(id);

        if (eliminado) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Crea un pedido nuevo permitiendo agregar uno o mas productos.
     * 
     * Valida la existencia del producto, la cantidad solicitada y el stock
     * disponible antes de agregar cada linea al pedido.
     */
    private void crearPedido() {

        Pedido pedido = new Pedido(contadorPedidos);

        String continuar;

        do {
            System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
            productoService.listarProductos();

            System.out.print("Ingrese ID del producto: ");
            Long idProducto = scanner.nextLong();
            scanner.nextLine();

            Producto producto = productoService.buscarPorId(idProducto);

            if (producto == null) {
                System.out.println("Producto no encontrado.");
            } else {
                System.out.print("Ingrese cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                try {
                    pedidoService.agregarLineaAlPedido(pedido, producto, cantidad);
                    System.out.println("Producto agregado al pedido.");
                } catch (StockInsuficienteException e) {
                    System.out.println("ERROR: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }

            System.out.print("Desea agregar otro producto al pedido? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        if (!pedido.getLineas().isEmpty()) {
            pedidoService.guardarPedido(pedido);
            contadorPedidos++;

            System.out.println("\n=== PEDIDO CREADO ===");
            System.out.println(pedido);
        } else {
            System.out.println("Pedido cancelado. No se agregaron productos.");
        }
    }
}