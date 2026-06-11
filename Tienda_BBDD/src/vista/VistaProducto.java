package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controlador.ProductoController;
import modelo.ProductoDTO;
import utils.Lecturas;

public class VistaProducto {

	public void menuProducto() throws IOException {
		boolean salir = false;
		do {
			System.out.println("\n=== PRODUCTOS =>>");
			System.out.println("1. Ver todos los productos");
			System.out.println("2. Buscar productos por precio máximo ");
			System.out.println("3. Buscar productos por precio y nombre ");
			System.out.println("4. BUSCAR PRODUCTOS CON Categoria ");
			System.out.println("5. AÑADIR PRODUCTO ");
			System.out.println("6. Eliminar Producto ");
			System.out.println("7. Actualizar Producto");
			System.out.println("9. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 9);
			switch (opcion) {
			case 1:
				System.out.println("= VER TODOS LOS PRODUCTOS =");
				mostrarTodosLosProductos();
				break;
			case 2:
				System.out.println("= BUSCAR PRODUCTOS POR PRECIo MAXIMO =");
				buscarProductoPorPrecio();
				break;
			case 3:
				System.out.println("= BUSCAR PRODUCTOS POR PRECIo y nombre =");
				buscarProductoPorPrecioyNombre();
				break;
			case 4:
				System.out.println("= BUSCAR PRODUCTOS CON Categoria =");
				buscarProductoConCategoria();
				break;
			case 5:
				System.out.println("\n AÑADIR PRODUCTO  ");
				insertarProducto();
				break;
			case 6:
				System.out.println("\n BORRAR PRODUCTO  ");
				borrarProducto();
				break;

			case 7:
				System.out.println("= ACTUALIZAR PRODUCTO =");
				actualizarProducto();
				break;
			case 9:
				salir = true;
				break;
			}
		} while (!salir);
	}

	public void mostrarTodosLosProductos() {
		ProductoController productoController = new ProductoController();
		ArrayList<ProductoDTO> lista = productoController.obtenerTodosLosProductos();

		for (ProductoDTO producto : lista) {
			System.out.println(producto.getId() + " - " + producto.getNombre() + " - " + producto.getPrecio() + " - "
					+ producto.getStock() + "- " + producto.getIdCategoria());
		}
	}

	public void buscarProductoPorPrecio() {
		ProductoController productoController = new ProductoController();

		double precioMaximo = Lecturas.leerDouble("Introduce el precio maximo a buscar: ");

		ArrayList<ProductoDTO> lista = productoController.buscarProductoPorPrecio(precioMaximo);

		if (lista.size() > 0) {
			for (ProductoDTO producto : lista) {
				System.out.println(producto.getId() + " - " + producto.getNombre() + " - " + producto.getPrecio()
						+ " - " + producto.getStock() + "- " + producto.getIdCategoria());
			}
		} else {
			System.out.println("No hay productos menos de " + precioMaximo);
		}

	}

	public void buscarProductoPorPrecioyNombre() {
		ProductoController productoController = new ProductoController();

		double precioMaximo = Lecturas.leerDouble("Introduce el precio maximo a buscar: ");
		String nombre = Lecturas.leerString("Introduce el nombre del producto a filtrar: ");

		ArrayList<ProductoDTO> lista = productoController.buscarProductoPorPrecioyNombre(precioMaximo, nombre);

		if (lista.size() > 0) {
			for (ProductoDTO producto : lista) {
				System.out.println(producto.getId() + " - " + producto.getNombre() + " - " + producto.getPrecio()
						+ " - " + producto.getStock() + "- " + producto.getIdCategoria());
			}
		} else {
			System.out.println("No hay productos con esos filtros");
		}

	}

	public void buscarProductoConCategoria() {
		ProductoController productoController = new ProductoController();

		ArrayList<ProductoDTO> lista = productoController.obtenerProductosConCategoria();

		if (lista.size() > 0) {
			for (ProductoDTO producto : lista) {
				System.out.println(producto.getId() + " - " + producto.getNombre() + " - " + producto.getPrecio()
						+ " - " + producto.getStock() + "- " + producto.getIdCategoria() + "-"
						+ producto.getCategoria());
			}
		} else {
			System.out.println("No hay productos con esos filtros");
		}

	}

	private void insertarProducto() {

		String nombre = Lecturas.leerString("Introduce el nombre del nuevo producto: ");
		double precio = Lecturas.leerDouble("Introduce el precio del nuevo producto: ");
		int stock = Lecturas.leerEntero("Introduce el stock del nuevo producto: ");
		String categoriaString = Lecturas.leerOpcion(
				"Introduce la categoria del nuevo producto (Electronica,Videojuegos, Libros): ",
				new String[] { "Electronica", "Videojuegos", "Libros" });
		int idCategoria;
		if (categoriaString.equalsIgnoreCase("Electronica"))
			idCategoria = 1;
		else if (categoriaString.equalsIgnoreCase("Videojuegos"))
			idCategoria = 2;
		else
			idCategoria = 3;

		ProductoDTO productoAInsertar = new ProductoDTO(nombre, precio, stock, idCategoria);

		ProductoController productoController = new ProductoController();
		boolean insertadoOK = productoController.insertar(productoAInsertar);
		if (insertadoOK)
			System.out.println("Producto añadido correctamente");
		else
			System.out.println("Error al añadir el producto");
	}

	private void borrarProducto() {
		int id = Lecturas.leerEntero("Introduce el id del producto a borrar:");
		ProductoController productoController = new ProductoController();
		boolean borradoOK = productoController.borrar(id);
		if (borradoOK)
			System.out.println("Producto borrado correctamente");
		else
			System.out.println("Error al borrar el producto");
	}

	public void actualizarProducto() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		int id = Lecturas.leerEntero("Introduce el id del producto a modificar: ");

		System.out.println("Introduce el nombre del producto: ");
		String nombreProducto = leer.readLine();

		System.out.println("Introduce el precio del producto (0 no modificar): ");
		double precioProducto = Double.parseDouble(leer.readLine());

		System.out.println("Introduce el stock del producto (0 no modificar): ");
		int stockProducto = Integer.parseInt(leer.readLine());

		System.out.println("Introduce la categoria del producto (Libros, Vidoejuegos, Electornica): ");
		String nombreCategoria = leer.readLine();

		int idCategoria;
		if (nombreCategoria.equalsIgnoreCase("Electronica"))
			idCategoria = 1;
		else if (nombreCategoria.equalsIgnoreCase("Videojuegos"))
			idCategoria = 2;
		else if (nombreCategoria.equalsIgnoreCase("Libros"))
			idCategoria = 3;
		else
			idCategoria = 0;

		ProductoDTO producto = new ProductoDTO(id, nombreProducto, precioProducto, stockProducto, idCategoria);
		ProductoController productoController = new ProductoController();
		boolean todoOk = productoController.actualizarProducto(producto);
		if (todoOk)
			System.out.println("Se ha modificado correctamentr");
		else
			System.out.println("No se ha podido actualizar");

	}
}