package vista;

import java.util.ArrayList;

import controlador.PedidoController;
import controlador.ProductoController;
import modelo.DetallePedidoDTO;
import modelo.ProductoDTO;
import utils.Lecturas;

public class VistaPedido {

	public void menuPedido() {
		boolean salir = false;
		do {
			System.out.println("\n PEDIDO  ");
			System.out.println("1. Crear pedido");
			System.out.println("9. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 9);
			switch (opcion) {
			case 1:
				System.out.println("\n CREAR PEDIDO  ");
				crearPedido();
				break;
			case 9:
				salir = true;
				break;
			}
		} while (!salir);
	}

	private void crearPedido() {
		ProductoController productoController = new ProductoController();
		ArrayList<ProductoDTO> lista = productoController.obtenerTodosLosProductos();

		System.out.println("\n  Producto disponibles  ");
		for (ProductoDTO producto : lista) {
			System.out.println(producto.getId() + "-" + producto.getNombre() + "-" + producto.getPrecio() + "-"
					+ producto.getStock() + "-" + producto.getIdCategoria());
		}
		System.out.println("\n  Realización pedido  ");
		ArrayList<DetallePedidoDTO> listaPedido = new ArrayList<DetallePedidoDTO>();
		boolean continuar = false;
		do {
			int idProducto = Lecturas.leerEntero("Introduzca el id del producto a pedir: ");
			int cantidad = Lecturas.leerEntero("Introduzca la cantidad del producto anterior que desee: ");
			DetallePedidoDTO nuevoPedido = new DetallePedidoDTO(idProducto, cantidad);
			listaPedido.add(nuevoPedido);
			continuar = Lecturas.leerSiNo("¿Desea añadir más productos al pedido? (S/N): ");
		} while (continuar);
		PedidoController pedidoController = new PedidoController();
		pedidoController.realizarPedido(listaPedido);
	}
}
