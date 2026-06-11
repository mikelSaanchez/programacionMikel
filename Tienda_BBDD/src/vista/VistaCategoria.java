package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controlador.CategoriaController;

import modelo.CategoriaDTO;

import utils.Lecturas;

public class VistaCategoria {
	public void menuCategoria() throws IOException {
		boolean salir = false;
		do {
			System.out.println("\n=== Categorias =>>");
			System.out.println("1. Ver todos las categorias");
			System.out.println("2. Insertar Categoria ");
			System.out.println("3. Borrar categoria ");
			System.out.println("4. Actualizar categoria ");
			System.out.println("5. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 9);
			switch (opcion) {
			case 1:
				System.out.println("= VER TODAS LAS CATEGORIAS =");
				mostrarTodasCategorias();
				break;
			case 2:
				System.out.println("= INSERTAR CATEGORIA =");
				insertarCategoria();
				break;
			case 3:
				System.out.println("= BORRAR CATEGORIA =");
				borrarCategoria();
				break;
			case 4:
				System.out.println("= ACTUALIZAR CATEGORIA =");
				actualizarCategoria();
				break;

			case 5:
				salir = true;
				break;
			}
		} while (!salir);
	}

	public void mostrarTodasCategorias() {
		CategoriaController categoriaController = new CategoriaController();

		ArrayList<CategoriaDTO> lista = categoriaController.obtenerTodosLasCategorias();

		System.out.println("----------------");
		System.out.println("Categorias");
		System.out.println("----------------");
		for (CategoriaDTO categoria : lista) {
			System.out.println(categoria.getId() + "-" + categoria.getNombre());
		}
	}

	private void insertarCategoria() {

		String nombre = Lecturas.leerString("Introduce el nombre de la nueva categoria: ");

		CategoriaDTO categoriaAInsertar = new CategoriaDTO(nombre);

		CategoriaController categoriaController = new CategoriaController();
		boolean insertadoOK = categoriaController.insertar(categoriaAInsertar);
		if (insertadoOK)
			System.out.println("categoria añadido correctamente");
		else
			System.out.println("Error al añadir la categoria");
	}

	private void borrarCategoria() {
		int id = Lecturas.leerEntero("Introduce el id de la categoria a borrar:");
		CategoriaController categoriaController = new CategoriaController();
		boolean borradoOK = categoriaController.borrar(id);
		if (borradoOK)
			System.out.println("Categoria borrada correctamente");
		else
			System.out.println("Error al borrar la categoria");
	}

	public void actualizarCategoria() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		int id = Lecturas.leerEntero("Introduce el id de la categoria a modificar: ");

		System.out.println("Introduce el nombre de la categoria: ");
		String nombreCategoria = leer.readLine();

		CategoriaDTO categoria = new CategoriaDTO(id, nombreCategoria);
		CategoriaController categoriaController = new CategoriaController();
		boolean todoOk = categoriaController.actualizar(categoria);
		if (todoOk)
			System.out.println("Se ha modificado correctamente");
		else
			System.out.println("No se ha podido actualizar");

	}
}
