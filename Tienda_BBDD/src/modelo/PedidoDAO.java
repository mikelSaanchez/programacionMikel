package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConexionBBDD;

public class PedidoDAO {
	public boolean realizarPedido(ArrayList<DetallePedidoDTO> detalles) {
		Connection conexion = null;
		try {
			conexion = ConexionBBDD.getConexion();
			// 1. Desactivamos autoCommit para iniciar la transacción
			conexion.setAutoCommit(false);
			// 2. Calculamos el total del pedido
			double total = 0;
			for (DetallePedidoDTO d : detalles) {
				total += d.getCantidad() * d.getPrecioUnitario();
			}
			// 3. Insertamos el pedido y obtenemos su id
			String sqlPedido = "INSERT INTO pedido (fecha, total) VALUES (CURDATE(), ?)";
			PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, PreparedStatement.RETURN_GENERATED_KEYS);
			psPedido.setDouble(1, total);
			psPedido.executeUpdate();
			// Otenemos el id del pedido recién insertado
			ResultSet keys = psPedido.getGeneratedKeys();
			int idPedido = -1;
			if (keys.next()) {
				idPedido = keys.getInt(1);
			}
			psPedido.close();
			// 4. Para cada producto pedido, insertamos en detalles_pedido y actualizamos el
			// stock
			String sqlDetalle = "INSERT INTO detalle_pedido(id_pedido, id_producto, cantidad, precio_unitario) "
					+ "VALUES (?, ?, ?, ?)";
			String sqlStock = "UPDATE producto SET stock = stock - ? WHERE id = ? AND stock  ?";
			for (DetallePedidoDTO detalle : detalles) {
				// Insertamos el detalle del pedido
				PreparedStatement psDetalle = conexion.prepareStatement(sqlDetalle);
				psDetalle.setInt(1, idPedido);
				psDetalle.setInt(2, detalle.getIdProducto());
				psDetalle.setInt(3, detalle.getCantidad());
				psDetalle.setDouble(4, detalle.getPrecioUnitario());
				psDetalle.executeUpdate();
				psDetalle.close();

				// Reducimos el stock del producto
				// La condición AND stock ? evita que el stock quede negativo

				PreparedStatement psStock = conexion.prepareStatement(sqlStock);
				psStock.setInt(1, detalle.getCantidad());
				psStock.setInt(2, detalle.getIdProducto());
				psStock.setInt(3, detalle.getCantidad());
				int filasActualizadas = psStock.executeUpdate();
				psStock.close();
				// Si no se actualizó el stock, es porque no había suficiente
				if (filasActualizadas == 0) {
					throw new SQLException("Stock insuficiente para el producto " + detalle.getIdProducto());
				}
			}
			// 5. Todo ha ido bien: confirmamos la transacción
			conexion.commit();
			System.out.println("Pedido realizado correctamente.Total: " + total + "€");
			return true;
		} catch (SQLException e) {
			// 6. Algo ha fallado: deshacemos todos los cambios
			System.out.println("Error al realizar el pedido: " + e.getMessage());
			if (conexion != null) {
				try {
					conexion.rollback();

					System.out.println("Cambios revertidos correctamente");
				} catch (SQLException ex) {
					System.out.println("Error en rollback: " + ex.getMessage());
				}
			}
			return false;
		} finally {
			// 7. Siempre restauramos el autoCommit y cerramos la conexión
			if (conexion != null) {
				try {
					conexion.setAutoCommit(true);
					conexion.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar conexión:" + e.getMessage());
				}
			}
		}
	}
}
