package controlador;

import java.util.ArrayList;

import modelo.CategoriaDAO;
import modelo.CategoriaDTO;


public class CategoriaController {
	
	public ArrayList<CategoriaDTO> obtenerTodosLasCategorias() {
		CategoriaDAO dao = new CategoriaDAO();
		ArrayList<CategoriaDTO> lista = dao.obtenerTodosLosCategorias();
		return lista;
	} 
	
	public boolean insertar(CategoriaDTO categoria) {
		CategoriaDAO dao = new CategoriaDAO();
		boolean insertado = dao.insertar(categoria);
		return insertado;
	}

	public boolean borrar(int id) {
		CategoriaDAO dao = new CategoriaDAO();
		boolean borrado = dao.borrar(id);
		return borrado;
	}

	public boolean actualizar(CategoriaDTO categoria) {
		CategoriaDAO dao = new CategoriaDAO();
		return dao.actualizar(categoria);
	}
}
