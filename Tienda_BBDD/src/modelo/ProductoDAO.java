package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConexionBBDD;

public class ProductoDAO {

	public ArrayList<ProductoDTO> obtenerTodosLosProductos() {

		ArrayList<ProductoDTO> lista = new ArrayList<>();

		try {

			Connection conexion = ConexionBBDD.getConexion();

			String sql = "SELECT * FROM producto";

			PreparedStatement ps = conexion.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");
				int idCategoria = rs.getInt("id_categoria");
				ProductoDTO producto = new ProductoDTO(id, nombre, precio, stock, idCategoria);
				lista.add(producto);
			}
			conexion.close();
			return lista;
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<ProductoDTO> buscarProductoPorPrecio(double precioMaximo) {
		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "select * from producto where precio < ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setDouble(1, precioMaximo);
			ResultSet rs = ps.executeQuery();

			ArrayList<ProductoDTO> lista = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");
				int idCategoria = rs.getInt("id_categoria");

				ProductoDTO producto = new ProductoDTO(id, nombre, precio, stock, idCategoria);
				lista.add(producto);

			}

			conexion.close();
			return lista;

		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ProductoDTO> buscarProductoPorPrecioyNombre(double precioMaximo, String nombreProducto) {
		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "select * from producto where precio > ? and nombre LIKE ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setDouble(1, precioMaximo);
			ps.setString(2, '%' + nombreProducto + '%');
			ResultSet rs = ps.executeQuery();

			ArrayList<ProductoDTO> lista = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");
				int idCategoria = rs.getInt("id_categoria");

				ProductoDTO producto = new ProductoDTO(id, nombre, precio, stock, idCategoria);
				lista.add(producto);

			}

			conexion.close();
			return lista;

		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<ProductoDTO> obtenerProductosConCategoria() {
		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "SELECT p.id, p.nombre, p.precio, p.stock, p.id_categoria,  c.nombre AS nombre_categoria \r\n"
					+ "FROM tienda.producto p \r\n" + "JOIN tienda.categoria c ON p.id_categoria = c.id;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			ArrayList<ProductoDTO> lista = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");
				int idCategoria = rs.getInt("id_categoria");
				String nombreCategoria = rs.getString("nombre_categoria");

				ProductoDTO producto = new ProductoDTO(id, nombre, precio, stock, idCategoria, nombreCategoria);
				lista.add(producto);

			}

			conexion.close();
			return lista;

		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public boolean insertarProducto(ProductoDTO producto) {
		try {
			Connection conexion = ConexionBBDD.getConexion();

			String sql = "INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);

			ps.setString(1, producto.getNombre());
			ps.setDouble(2, producto.getPrecio());
			ps.setInt(3, producto.getStock());
			ps.setInt(4, producto.getIdCategoria());

			int filasAfectadas = ps.executeUpdate();
			conexion.close();

			return filasAfectadas > 0;
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			return false;
		}
	}

	public boolean borrar(int id) {
		String sql = "DELETE FROM producto WHERE id = ?";
		try {
			Connection conexion = ConexionBBDD.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			int filasAfectadas = ps.executeUpdate();
			conexion.close();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			System.out.println("Error al borrar producto: " + e.getMessage());
			return false;
		}
	}

	public boolean actualizar(ProductoDTO producto) {

		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "UPDATE producto SET " + "nombre = CASE WHEN ? = '' THEN nombre ELSE ? END, "
					+ "precio = CASE WHEN ? = 0 THEN precio ELSE ? END, "
					+ "stock = CASE WHEN ? = 0 THEN stock ELSE ? END, "
					+ "id_categoria = CASE WHEN ? = 0 THEN id_categoria ELSE ? END " + "WHERE id = ?;";
			PreparedStatement ps = conexion.prepareStatement(sql);

			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getNombre());

			ps.setDouble(3, producto.getPrecio());
			ps.setDouble(4, producto.getPrecio());

			ps.setInt(5, producto.getStock());
			ps.setInt(6, producto.getStock());

			ps.setInt(7, producto.getIdCategoria());
			ps.setInt(8, producto.getIdCategoria());

			ps.setInt(9, producto.getId());

			int numFilas = ps.executeUpdate();
			conexion.close();

			return numFilas > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public double obtenerPrecioPorId(int id) {
		String sql = "SELECT precio FROM Producto Where id=?;";
		double precio = 0;
		try {
			Connection conexion = ConexionBBDD.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				precio = rs.getDouble("precio");
			}
			conexion.close();
			return precio;
		} catch (SQLException e) {
			System.out.println("Error al borrar producto: " + e.getMessage());
			return precio;
		}
	}
}
