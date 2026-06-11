package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConexionBBDD;

public class CategoriaDAO {

	public ArrayList<CategoriaDTO> obtenerTodosLosCategorias() {

		ArrayList<CategoriaDTO> listaCategorias = new ArrayList<>();

		try {

			Connection conexion = ConexionBBDD.getConexion();

			String sql = "SELECT * FROM categoria";

			PreparedStatement ps = conexion.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				CategoriaDTO categoria = new CategoriaDTO(id, nombre);
				listaCategorias.add(categoria);
			}
			conexion.close();
			return listaCategorias;
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public boolean insertar(CategoriaDTO categoria) {
		try {
			Connection conexion = ConexionBBDD.getConexion();

			String sql = "INSERT INTO categoria (nombre) VALUES (?)";
			PreparedStatement ps = conexion.prepareStatement(sql);

			ps.setString(1, categoria.getNombre());

			int filasAfectadas = ps.executeUpdate();
			conexion.close();

			return filasAfectadas > 0;
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			return false;
		}
	}

	public boolean borrar(int id) {
		String sql = "DELETE FROM categoria WHERE id = ?";
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

	public boolean actualizar(CategoriaDTO categoria) {

		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "UPDATE categoria SET nombre = CASE WHEN ? = '' THEN nombre ELSE ? END WHERE id = ?;";
			PreparedStatement ps = conexion.prepareStatement(sql);

			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getNombre());
			
			ps.setInt(3, categoria.getId());

			int numFilas = ps.executeUpdate();
			conexion.close();

			return numFilas > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
