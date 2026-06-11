package Tienda_BBDD;

import java.io.IOException;

import utils.Lecturas;
import vista.VistaCategoria;
import vista.VistaPedido;
import vista.VistaProducto;

public class Principal {

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		do {
			System.out.println("\n === TIENDA ONLINE DAW === ");
			System.out.println("1. Productos");
			System.out.println("2. Categorias");
			System.out.println("5. Salir");

			int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 1, 5);

			switch (opcion) {
			case 1:
				VistaProducto vp = new VistaProducto();
				vp.menuProducto();
				break;
			case 2:
				VistaCategoria vc = new VistaCategoria();
				vc.menuCategoria();
				break;
			case 3:
				VistaPedido ved = new VistaPedido();
				ved.menuPedido();
				break;
			case 5:
				System.out.println("Saliendo del programa. Hasta pronto!");
				salir = true;
				break;
			}

		} while (!salir);

	}

}
