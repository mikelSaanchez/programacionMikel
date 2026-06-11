package controlador;

import java.util.ArrayList;

import modelo.DetallePedidoDTO;
import modelo.PedidoDAO;
import modelo.ProductoDAO;

public class PedidoController {

	public boolean realizarPedido(ArrayList<DetallePedidoDTO> detalles) {
		ProductoDAO productoDao = new ProductoDAO();

		for (DetallePedidoDTO pedido : detalles) {
			double precio = productoDao.obtenerPrecioPorId(pedido.getIdProducto());
			pedido.setPrecioUnitario(precio);
		}

		PedidoDAO pedidoDao = new PedidoDAO();
		return pedidoDao.realizarPedido(detalles);
	}

}
