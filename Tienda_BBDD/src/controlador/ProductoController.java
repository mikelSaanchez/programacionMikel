package controlador;

import java.util.ArrayList;

import modelo.ProductoDAO;
import modelo.ProductoDTO;

public class ProductoController {

	public ArrayList<ProductoDTO> obtenerTodosLosProductos() {
		ProductoDAO dao = new ProductoDAO();
		ArrayList<ProductoDTO> lista = dao.obtenerTodosLosProductos();
		return lista;
	}

	public ArrayList<ProductoDTO> buscarProductoPorPrecio(double precioMaximo) {
		ProductoDAO dao = new ProductoDAO();
		ArrayList<ProductoDTO> lista = dao.buscarProductoPorPrecio(precioMaximo);
		return lista;
	}

	public ArrayList<ProductoDTO> buscarProductoPorPrecioyNombre(double precioMaximo, String nombreProducto) {
		ProductoDAO dao = new ProductoDAO();
		ArrayList<ProductoDTO> lista = dao.buscarProductoPorPrecioyNombre(precioMaximo, nombreProducto);
		return lista;
	}

	public ArrayList<ProductoDTO> obtenerProductosConCategoria() {
		ProductoDAO dao = new ProductoDAO();
		ArrayList<ProductoDTO> lista = dao.obtenerProductosConCategoria();
		return lista;
	}

	public boolean insertar(ProductoDTO producto) {
		ProductoDAO dao = new ProductoDAO();
		boolean insertado = dao.insertarProducto(producto);
		return insertado;
	}

	public boolean borrar(int id) {
		ProductoDAO dao = new ProductoDAO();
		boolean borrado = dao.borrar(id);
		return borrado;
	}

	public boolean actualizarProducto(ProductoDTO producto) {
		ProductoDAO dao = new ProductoDAO();
		return dao.actualizar(producto);
	}
}
